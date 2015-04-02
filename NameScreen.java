import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import java.awt.Color;

public class NameScreen implements Screen {
   private String name = "";
   private String message = "";

   @Override
   public void displayOutput(AsciiPanel terminal) {
      String[] title = ArtReader.get("name");
      String[] face = ArtReader.get("face");
      ConsoleHelper.writeArray(terminal, face, 0, 13, new Color(50, 50, 50), false);
      ConsoleHelper.writeCenterArray(terminal, title, 10, new Color(255, 100, 100));
      
      terminal.writeCenter("enter your name:", 25);
      terminal.writeCenter(name, 27, AsciiPanel.brightYellow);
      terminal.writeCenter("FOR NOW DON'T USE SHIFT", 29, new Color(255, 0, 0));
      terminal.writeCenter("del to undo", 30);
      terminal.writeCenter("enter when finished", 31);
      terminal.writeCenter(message, 25);
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
         name += ("" + key.getKeyChar()).toUpperCase();
         if (name.length() > 32)
            name = name.substring(0, 32);
      }
      return this;
   }
}
