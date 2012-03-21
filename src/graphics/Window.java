
package graphics;

import game.GameMap;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import utils.OutOfMapException;
import characters.NPC;

class GameWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3854950048874492L;

	public static final int DEFAULT_WIDTH = 1000, DEFAULT_HEIGHT = 600;
	private GameMap gameMap = new GameMap();
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
		// add(dropDown);
		overPanel.add(startMenu);
		overPanel.add(gamePanel);
		gamePanel.add(returnButton);
		startMenu.add(startButton);
		// gameMap.setVisible(false);
		gamePanel.setVisible(false);
		overPanel.setVisible(true);
		// gamePanel.add(gameMap);
		try {
			gameMap.putCharacter(new Point(1, 1), new NPC("Test", 1, 1, 1,
					1, 1, 1, gameMap));
		} catch (OutOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GameWindow() {
		setTitle("Game: The Game");
		// pack();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// add(gamePanel);
		add(gameMap);// add(component);
		startButton.addActionListener(this);
		gameMap.setVisible(false);
		startMenu.setVisible(true);
		add(startMenu);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startMenu.setVisible(false);
		gamePanel.setVisible(true);
		gameMap.setVisible(true);
	}

}

public class Window {

	public static GameWindow gameWindow = new GameWindow();

	public static void main(String[] args) throws IOException,
			OutOfMapException {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				gameWindow.setVisible(true);
			}
		});

	}

}
