import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {
   public MenuItemList menuItems = new MenuItemList("Play", "Info", "Highscores");

   @Override 
   public void displayOutput(AsciiPanel terminal) {
      //* DEBUG STUFF REMOVE LATER *//
      for (int i = 0; i < 100; i ++)
      {
         for (int j = 0; j < 50; j++)
         {
            terminal.setCursorX(i);
            terminal.setCursorY(j);
            if (i % 2 == 0 && j % 2 == 0)
               terminal.write(' ', AsciiPanel.white, AsciiPanel.white);
            else if (i % 2 == 0)
               terminal.write(' ', AsciiPanel.white, AsciiPanel.brightBlack);
            else if (j % 2 == 0)
               terminal.write(' ', AsciiPanel.white, AsciiPanel.brightBlack);
         }
      }
            
      terminal.writeCenter("X", 30);
      terminal.writeCenter("XX", 31);
      terminal.writeCenter("XXX", 32);
      terminal.writeCenter("XXXX", 33);
      // real stuff
      terminal.writeCenter("next generation roguelike", 10, AsciiPanel.brightRed);
      ConsoleHelper.rectNoFill(terminal, 25, 9, 50, 3);
      ConsoleHelper.rectNoFill(terminal, 35, 38, 30, 7); 
      
      menuItems.drawList(terminal, 40);
      
      
      //* DEBUG STUFF REMOVE LATER *//
      for (int i = 0; i < 50; i++)
         terminal.write("" + i, 0, i);
      for (int i = 0; i < 98; i++)
         terminal.write("" + i, i, 0);
   }

   @Override
   public Screen respondToUserInput(KeyEvent key) {
      /* Code for choosing menu items. */
      switch (key.getKeyCode()){
         case KeyEvent.VK_UP: 
            this.menuItems.select(-1);
            break;
         case KeyEvent.VK_DOWN: 
            this.menuItems.select(1);
            break;
         case KeyEvent.VK_ENTER:
            switch(menuItems.selected){
               case 0:
                  return new NameScreen();
               case 1:
                  return new InfoScreen();
               case 2:
                  return new ScoreScreen();
            }
      }
      /* /menu code */
   	
      return this;
   }
}
