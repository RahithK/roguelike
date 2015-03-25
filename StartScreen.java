import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {
   public MenuItemList menuItems = new MenuItemList("Play", "Info", "Highscores");

   @Override 
   public void displayOutput(AsciiPanel terminal) {
      terminal.writeCenter(" _________________________________________ ", 21, AsciiPanel.brightWhite);
      terminal.writeCenter("/                                         \\", 22, AsciiPanel.brightWhite);
      terminal.writeCenter("|        next generation roguelike        |", 23, AsciiPanel.brightWhite);
      terminal.writeCenter("\\_________________________________________/", 24, AsciiPanel.brightWhite);
      
      menuItems.drawList(terminal, 40);
   }

   @Override
   public Screen respondToUserInput(KeyEvent key) {
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
                  return new PlayScreen();
               case 1:
                  return new InfoScreen();
               case 2:
                  return new LoseScreen(); //change this to ScoreScreen
            }
      }
   	
      return this;
   }
}
