import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bot extends JFrame implements KeyListener {
  JPanel p = new JPanel();
  JTextArea dialog = new JTextArea(20, 50);
  JTextArea input = new JTextArea(2,20);
  JScrollPane scroll = new JScrollPane(dialog, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


  public static void main(String[]args){
      new Bot();
  }

  String [][] bot = {
          //expected greetings
          {"hi", "hello","hola", "wagwan", "mambo"},
          //expected reply
          {"hi", "wagwaan","hi yourself"},
          //questions
          {"how are you", "how r u", "mambo"},
          //answers
          {"poa", "good","doing well"},
          //default if nothin expected is given
          {"bro si u talk well", "eish man", " error 404"}
  };

  public Bot(){
      super("Chat Bot");
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
 dialog.setEditable(false);// cant edit bots response
      input.addKeyListener(this);//listen in this input box
      p.add(scroll);
      p.add(input);
      add(p);

      setVisible(true);

  }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
          if(keyEvent.getKeyCode() ==KeyEvent.VK_ENTER){//if enter is pressed
              input.setEditable(false);//don't recognise as go down a line
              //---------get input-------------
              String userInput = input.getText();
              input.setText("");//clear text
              addText("-->You:\t" + userInput);
              userInput.trim();
              while (
                      userInput.charAt(userInput.length()-1)== '!' ||
                              userInput.charAt(userInput.length()-1)== '.' ||
                              userInput.charAt(userInput.length()-1)== '?'
              ){
                  userInput=userInput.substring(0,userInput.length()-1); //gets beginning character to last character

              }
              userInput.trim();
              byte response = 0; //0 means searching in bot array
                                 //1 nothing found
                                 //2 found

              //---------check for matches---------
              int j = 0; //which group in array we are checking (greetings, question)
              while (response == 0){
                  if (inArray(userInput.toLowerCase(), bot[j * 2])); //since only 2 groups exist greetings 0 *2 & questions 1 * 2
                  response = 2;
                  int r= (int) Math.floor(Math.random() *bot[(j * 2) + 1].length);
                  addText("\n-->Bot" + bot[(j*2)][r]);
              }
               j++;
              if(j*2==bot.length-1 && response==0){
                  response=1;
              }

              //---------else default----
              if(response==1){
                  int r= (int) Math.floor(Math.random() *bot[bot.length-1].length);
                  addText("\n-->Bot" + bot[bot.length-1][r]);
              }
              addText("\n");
          }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() ==KeyEvent.VK_ENTER){//if enter is pressed
            input.setEditable(true);//don't recognise as go down a line
        }
    }

    public void addText(String str){
      dialog.setText(dialog.getText() + str);
    }
    public boolean inArray(String in, String[] str){
      boolean match = false;
     for(int i = 0; i < str.length; i++){
         if(str[i].equals(in)){
             match = true;
         }
     }
     return match;
    }
}
