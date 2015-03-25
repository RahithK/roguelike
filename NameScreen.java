import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class NameScreen implements Screen {
   private String name = "";

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("ENTER YOUR NAME", 1);
      terminal.writeCenter("ENTER TO CONTINUE", 22);
      terminal.writeCenter(name, 10, AsciiPanel.yellow);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
      // if they press enter go to the next screen
      if (key.getKeyCode() == KeyEvent.VK_ENTER)
         return new PlayScreen();
      // if delete is pressed, check to make sure there are letters in the string, delete one
      else if (key.getKeyCode() == KeyEvent.VK_DELETE && name.length() > 0)
      {
         name = name.substring(0, name.length()-1);
         // return now so "delete char" doesnt get added
         return this;
      }
      // if they pressed anything but enter or delete, add letter to the name
      else
		   name += key.getKeyChar();
		return this;
	}
}
