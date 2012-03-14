
package game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	private static final long serialVersionUID = 3854950048877684492L;
	public static final int DEFAULT_WIDTH = 1000, DEFAULT_HEIGHT = 475;
	private JPanel gameMap = new GameMap();
	private final JPanel startMenu = new JPanel();
	private final JButton startButton = new JButton("New Game");

	{
		startMenu.add(startButton);
		gameMap.setVisible(false);
	}

	public GameWindow() {
		setTitle("Game: The Game");

		// pack();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		add(gameMap); // add(component);
		add(startMenu);
		startButton.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startMenu.setVisible(false);
		gameMap.setSize(100, 100);
		gameMap.setVisible(true);

	}

}
