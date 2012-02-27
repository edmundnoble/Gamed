package game;

import game.Window.WindowType;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GameWindow extends JFrame {

	public static final int DEFAULT_WIDTH = 1000, DEFAULT_HEIGHT = 475;

	GameMap map;
	Tile[] tiles;

	public GameWindow() {
		tiles = new Tile[20];
		map = new GameMap();
		setTitle("Game");
		Window.pane = new ButtonPanel(WindowType.GAME);

		// pack();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		Box box = new Box(BoxLayout.LINE_AXIS);
		box.setLocation(20, 32);
		box.setSize(400, 400);
		// pane.add(box);
		// component.setSize(DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2);
		// JButton button = new JButton("Move Up"), button1 = new
		// JButton("Attack"), endTurnButton = new JButton(
		// "End Turn");
		// pane.add(button);
		// pane.add(button1);
		// pane.add(endTurnButton);
		add(map);
		add(box);
		add(Window.pane); // add(component);
		setSize(500, 475);
		setVisible(true);
	}
}