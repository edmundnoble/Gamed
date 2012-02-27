package game;

import game.Window.WindowType;

import javax.swing.JFrame;

public class StartWindow extends JFrame {
	public StartWindow() {
		setTitle("Game");
		Window.pane = new ButtonPanel(WindowType.START);
		add(Window.pane);
	}
}