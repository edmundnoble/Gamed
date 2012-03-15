
package graphics;

import game.GameMap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Window {

	enum WindowType {
		START, GAME, CHARCREATE
	}

	public static final GameWindow gameWindow = new GameWindow();

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				gameWindow.setVisible(true);
			}
		});

	}

}

class GameWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3854950048874492L;
	public static final int DEFAULT_WIDTH = 1000, DEFAULT_HEIGHT = 600;
	private JPanel gameMap = new GameMap();
	private final JMenuBar dropDown = new JMenuBar();
	private final JMenu file = new JMenu("File"),
			save = new JMenu("Save"), load = new JMenu("Save");

	private final JPanel startMenu = new JPanel();
	private final JButton startButton = new JButton("New Game");
	private final JButton returnButton = new JButton("Return to Menu");
	private final JPanel overPanel = new JPanel();
	private final JPanel gamePanel = new JPanel();
	{
		dropDown.add(file);
		dropDown.add(save);
		dropDown.add(load);
		add(dropDown);
		overPanel.add(startMenu);
		overPanel.add(gamePanel);
		gamePanel.add(returnButton);
		gamePanel.add(gameMap);
		startMenu.add(startButton);
		// gameMap.setVisible(false);
		gamePanel.setVisible(false);
		overPanel.setVisible(true);
		add(gameMap);
	}

	public GameWindow() {
		setTitle("Game: The Game");
		// pack();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		add(gamePanel); // add(component);
		add(startMenu);
		startButton.addActionListener(this);
		setVisible(true);
		gameMap.setVisible(false);
		gamePanel.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startMenu.setVisible(false);
		// gamePanel.setVisible(true);
		gameMap.setVisible(true);
		System.out.println(gamePanel.isVisible());
		System.out.println(gameMap.isVisible());
		System.out.println(gameMap.getWidth() + "," + gameMap.getHeight());
	}

}
