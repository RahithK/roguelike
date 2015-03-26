import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class NameScreen implements Screen {
   private String name = "";
   private String message = "";

   @Override
   public void displayOutput(AsciiPanel terminal) {
      terminal.writeCenter(" _________________________________________ ", 1, AsciiPanel.brightWhite);
      terminal.writeCenter("/                                         \\", 2, AsciiPanel.brightWhite);
      terminal.writeCenter("|             create your hero             |", 3, AsciiPanel.brightWhite);
      terminal.writeCenter("\\_________________________________________/", 4, AsciiPanel.brightWhite);
      terminal.writeCenter("enter your name:", 9);
      terminal.writeCenter(name, 10, AsciiPanel.brightYellow);
      terminal.writeCenter("del to undo", 12);
      terminal.writeCenter("enter when finished", 13);
      terminal.writeCenter(message, 25);
      ConsoleHelper.rect(terminal, 5, 5, 10, 10);
   }

   @Override
   public Screen respondToUserInput(KeyEvent key)
   {
      // if they press enter go to the next screen
      if (key.getKeyCode() == KeyEvent.VK_ENTER)
      {
         return new PlayScreen();
      }
         // if delete is pressed, check to make sure there are letters in the string, delete one
      else if (key.getKeyCode() == KeyEvent.VK_DELETE && name.length() > 0)
      {
         name = name.substring(0, name.length()-1);
         return this;
      }
      else if(key.getKeyCode() == KeyEvent.VK_DELETE && name.length() == 0)
      {
         return this;
      }
         // if they pressed anything but enter or delete, add letter to the name
      else
      {
         name += key.getKeyChar();
      }
      return this;
   }
}
