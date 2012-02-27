package game;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6321508593667230654L;

	private JPanel panel;

	private TileButton[][] buttons = new TileButton[7][8];

	private GameMap mainmap;
	private Image image;

	public ButtonPanel(Window.WindowType windowtype) {
		TileComponent component = new TileComponent();
		image = component.getImage();
		// setLayout(new BorderLayout());
		ActionListener move = new MovementAction();
		ActionListener attack = new AttackAction();
		ActionListener newGame = new NewGame();
		ActionListener loadGame = new NewGame(); // TODO: Add loading
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		// panel.setLayout(new GridLayout(4, 4));
		if (windowtype == Window.WindowType.GAME) {
			addTiles(image);
			// addButton("Attack", attack);
			// addButton("Move", move);
		} else if (windowtype == Window.WindowType.START) {
			// addButton("New Game", newGame);
			// addButton("Load Game", loadGame);
		}
	}

	private void addTiles(Image image) {

	}
}
