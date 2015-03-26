import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class ScoreScreen implements Screen {

   public MenuItemList menuItems = new MenuItemList("Play", "Menu", "Info");
   
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("score SCREEN", 1);
		terminal.writeCenter("[P]LAY  [M]ENU", 22);
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
                  return new StartScreen();
               case 2:
                  return new InfoScreen();
            }
      }
      /* /menu code */
   	
      return this;
	}
}
