import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import java.awt.*;

public class StartScreen implements Screen {
   public MenuItemList menuItems = new MenuItemList("Singleplayer", "Multiplayer", "Scores", "Info", "Exit");

   @Override 
   public void displayOutput(AsciiPanel terminal) {

      // real stuff
      String[] landscape = ArtReader.get("landscape");
      String[] title = ArtReader.get("title");
      
      ConsoleHelper.writeArray(terminal, landscape, 0, 0, new Color(210, 210, 210));
      ConsoleHelper.writeCenterArray(terminal, title, 28, new Color(175, 100, 150));

      menuItems.drawList(terminal, 40);
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
                  return new LoseScreen();
               case 2:
                  return new ScoreScreen();
               case 3:
                  return new InfoScreen();
               case 4:
                  System.exit(0);
            }
      }
      /* /menu code */
   	
      return this;
   }
}
