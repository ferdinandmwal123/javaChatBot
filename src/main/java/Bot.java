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
              input.setEditable(false);//dont recognise as
          }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
