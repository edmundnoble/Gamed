
package game;

import graphics.TileButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.IIOException;
import javax.swing.JPanel;
import javax.swing.Timer;

import utils.CustomHashtable;
import utils.ImageUtils;
import utils.OutOfMapException;
import characters.Character;
import characters.Player;

public class GameMap extends JPanel implements MouseListener,
		ActionListener {

	private static final int DEFAULT_HEIGHT_TEXTPANEL = 500,
			DEFAULT_WIDTH_TEXTPANEL = 500;

	private static final int FPS = 10;

	private static final long serialVersionUID = -2286832497356572097L;

	public static Image tileImage, brightTileImage, redTileImage,
			character1;

	private static final int tilesX = 10, tilesY = 10;

	public static void Log(String str) {
		System.out.println(str);
	}

	// g.drawImage(img, w, h, null);
	private CustomHashtable<Point, TileButton> buttons =
			new CustomHashtable<Point, TileButton>();
	public final CustomHashtable<Point, Character> characters =
			new CustomHashtable<Point, Character>();
	int imageHeight;
	int imageWidth;
	public final Hashtable<Point, Item> items =
			new Hashtable<Point, Item>();

	private TileButton lastPressedButton = null;

	private Date pressedTime = new Date();

	Timer renderTimer;

	private Character selectedCharacter = null;

	public GameMap() {
		super();
		renderTimer = new Timer(1000 / FPS, this);
		setLocation(10, 10);
		try {
			tileImage = ImageUtils.loadImage("tile.png");
			brightTileImage = ImageUtils.loadImage("bright_tile.png");
			redTileImage = ImageUtils.loadImage("tile_red.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			boolean valid =
					tileImage.getHeight(this) == brightTileImage
							.getHeight(this)
							&& tileImage.getHeight(this) == redTileImage
									.getHeight(this)
							&& tileImage.getHeight(null) == tileImage
									.getWidth(null)
							&& brightTileImage.getWidth(null) == redTileImage
									.getWidth(null)
							&& brightTileImage.getWidth(null) == tileImage
									.getHeight(null);
			if (!valid) {
				throw new IIOException(
						"Tile images have invalid dimensions!");
			}
		} catch (IIOException iioe) {
			iioe.printStackTrace();
		}
		enableInputMethods(true);
		addMouseListener(this);
		imageWidth = brightTileImage.getWidth(this);
		imageHeight = brightTileImage.getHeight(this);
		for (int i = 0; i < tilesX; i++) {
			for (int j = 0; j < tilesY; j++) {
				buttons.put(new Point(i, j), new TileButton(
						(i * imageWidth), (j * imageHeight)));
			}

		}
		int w = tileImage.getWidth(this) * tilesX;
		int h = tileImage.getHeight(this) * tilesY;
		setSize(w, h);
		setMinimumSize(new Dimension(w, h));
		try {
			putCharacter(new Point(2, 3), new Player("char1", 1, 1, 1, 1,
					1, 1, this));
			putCharacter(new Point(2, 3), new Player("char1", 1, 1, 1, 1,
					1, 1, this));
		} catch (OutOfMapException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		paintMap(getGraphics());
	}

	/**
	 * Returns the <code>TileButton</code> containing <code>Point</code> p.
	 * 
	 * @param p
	 */
	private TileButton containerButton(Point p) {
		Point newPoint = new Point(p.x / imageWidth, p.y / imageHeight);
		return buttons.get(newPoint);
	}

	public Hashtable<Point, Character> getActors() {
		return characters;
	}

	public Hashtable<Point, Item> getItems() {
		return items;
	}

	/**
	 * Returns true if the button is on the edge of the map.
	 * 
	 * @param button
	 */
	private boolean isEdgeButton(TileButton button) {
		if (!buttons.containsValue(button)) {
			return false;
		}
		if (button.getX() % (button.getWidth() * (tilesX - 1)) == 0
				|| button.getY() % (button.getHeight() * (tilesY - 1)) == 0) {
			return true;
		}

		else {
			return false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TileButton button = containerButton(e.getPoint());
		int x = button.getX() / button.getWidth() + 1, y =
				button.getY() / button.getHeight() + 1;
		Point xy = new Point(x, y);
		if (selectedCharacter == null
				&& !(characters.get(xy) instanceof Player)) {
			return;
		}/*
		 * if (selectedCharacter != null &&
		 * !(selectedCharacter.equals(characters.get(xy)))) { Point key =
		 * characters.keyOf(selectedCharacter); if (Math.abs(key.x - x) +
		 * Math.abs(key.y - y) == 1) { characters.put(xy,
		 * characters.remove(characters .keyOf(selectedCharacter))); } }
		 */
		if (selectedCharacter != null) {
			if (characters.get(xy) == null) {
				Point key = characters.keyOf(selectedCharacter);
				if (Math.abs(key.x - x) + Math.abs(key.y - y) == 1) {
					characters.put(xy, characters.remove(characters
							.keyOf(selectedCharacter)));
				}
			}
			else {
				selectedCharacter = characters.get(xy);
			}
		}
		else if (characters.get(xy) != null) {
			selectedCharacter = characters.get(xy);
		}

		if (!isEdgeButton(button)) {
			System.out.println("Not an edge button.");
		}
		else {
			System.out.println("Is an edge button.");
		}
		if (characters.get(e.getPoint()) != null) {
			selectedCharacter = characters.get(e.getPoint());
		}
		paintMap(getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Gamemap entered.");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Gamemap exited.");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressedTime = new Date();
		TileButton button = containerButton(e.getPoint());
		int x = button.getX() / button.getWidth() + 1, y =
				button.getY() / button.getHeight() + 1;
		Point xy = new Point(x, y);
		if (selectedCharacter == null && characters.get(xy) != null) {
			button.press(true);
		}
		else if (isEdgeButton(button) && selectedCharacter != null) {
			button.pressRed(true);
		}
		else if (selectedCharacter != null) {
			button.press(true);
		}
		System.out.print("Button " + "("
				+ (button.getX() / button.getWidth() + 1) + ","
				+ (button.getY() / button.getHeight() + 1)
				+ ") pressed.\n Pressed is " + button.isPressed() + ".\n");
		lastPressedButton = button;
		paintMap(getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (new Date().getTime() - pressedTime.getTime() > 900) {
			mouseClicked(e);
		}
		// TODO Auto-generated method stub
		/*
		 * for (TileButton[] buttons : this.buttons) { for (TileButton button :
		 * buttons) { Rectangle2D rect = new Rectangle2D.Double(button.getX(),
		 * button.getY(), button.getWidth(), button.getHeight()); if
		 * (rect.contains(e.getPoint())) {
		 */
		if (lastPressedButton == null) {
			return;
		}
		for (TileButton button : buttons.values()) {
			button.press(false);
			button.pressRed(false);
		}
		System.out
				.println("("
						+ (lastPressedButton.getX()
								/ lastPressedButton.getWidth() + 1)
						+ ","
						+ (lastPressedButton.getY()
								/ lastPressedButton.getHeight() + 1)
						+ ") released. Entered is "
						+ lastPressedButton.isPressed());
		lastPressedButton = null;
		paintMap(getGraphics());
	}

	public void paintMap(Graphics g) {
		for (TileButton button : this.buttons.values()) {
			button.paintComponent(g);
		}
		for (Character character : characters.values()) {
			character.paintCharacter(g, characters.keyOf(character));
		}
	}

	/**
	 * Adds a character to the map at Point <code>location</code>.
	 * 
	 * @param location
	 * @param actor
	 * @throws OutOfMapException
	 * */
	public void putCharacter(Point location, Character actor)
			throws OutOfMapException {

		if (location.getX() > tilesX | location.getY() > tilesY) {
			throw new OutOfMapException((int) location.getX(),
					(int) location.getY());
		}
		if (!characters.containsKey(location)) {
			actor.setMap(this);
			characters.put(location, actor);
		}
		else {
			putCharacter(new Point((int) location.getX() + 1,
					(int) location.getY()), actor);
		}
	}

	/**
	 * Adds an item to the map at Point <code>location</code>.
	 * 
	 * @param location
	 * @param item
	 * @throws OutOfMapException
	 * */

	public void putItem(Point location, Item item)
			throws OutOfMapException {
		// TODO Auto-generated method stub
		if (location.getX() > tilesX | location.getY() > tilesY) {
			throw new OutOfMapException((int) location.getX(),
					(int) location.getY());
		}
		if (!items.containsKey(location)) {
			items.put(location, item);
		}
		else {
			putItem(new Point((int) location.getX(), (int) location.getY()),
					item);
		}
	}

	public void send(String string) {
		JPanel textPanel = new JPanel();
		textPanel.setLocation((int) (getWidth() * 1.2),
				(int) (getHeight() * 1.2));
		textPanel.setSize(DEFAULT_HEIGHT_TEXTPANEL,
				DEFAULT_WIDTH_TEXTPANEL);
	}

	@Override
	public void setVisible(boolean enable) {
		super.setVisible(enable);
		if (enable) {
			renderTimer.start();
		}
		else {
			renderTimer.stop();
		}
	}
}
