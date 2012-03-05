
package game;

import javax.swing.JFrame;

public class StartWindow extends JFrame {

	public StartWindow() {
		setTitle("Game");
		Window.contentBox = new GameMap();
		add(Window.contentBox);
	}
}
