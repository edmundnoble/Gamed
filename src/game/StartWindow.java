
package game;

import javax.swing.JFrame;

public class StartWindow extends JFrame {

	public StartWindow() {
		setTitle("Game");
		setSize(1000, 500);
		Window.contentBox = new GameMap();
		add(Window.contentBox);
	}
}
