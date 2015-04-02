import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {

   MenuItemList menuItems = new MenuItemList("WIN GAME", "LOSE GAME");
   
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("PLAY SCREEN (GAME CONTENT GOES HERE)", 10);
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
                  return new WinScreen();
               case 1:
                  return new LoseScreen();
            }
      }
      /* /menu code */

		return this;
	}
}
