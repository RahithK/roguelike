import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class InfoScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("INFO SCREEN", 1);
		terminal.writeCenter("[P]LAY  [M]ENU", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
      switch (key.getKeyCode()){
		case KeyEvent.VK_P: return new NameScreen();
		case KeyEvent.VK_M: return new StartScreen();
		}
		
		return this;
	}
}
