
package game;

import graphics.TileButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import characters.Character;

public class GameMap extends JPanel implements MouseListener {

	private static final long serialVersionUID = -2286832497356572097L;

	// g.drawImage(img, w, h, null);
	private HashMap<Point, TileButton> buttons =
			new HashMap<Point, TileButton>();

	public final HashMap<Point, Character> actors =
			new HashMap<Point, Character>();

	public final HashMap<Point, Item> items = new HashMap<Point, Item>();

	private int tilesX = 8, tilesY = 10;

	int imageWidth;
	int imageHeight;
	public static Image tileImage, brightTileImage, character1;
	private TileButton lastClickedButton = null;

	private BufferedImage char1Image;

	public GameMap() {
		super();
		ClassLoader classLoader =
				Thread.currentThread().getContextClassLoader();

		try {
			InputStream input =
					classLoader.getResourceAsStream("tile.png");
			tileImage = ImageIO.read(input);
			input = classLoader.getResourceAsStream("bright_tile.png");
			brightTileImage = ImageIO.read(input);
			input = classLoader.getResourceAsStream("char1.png");
			char1Image = ImageIO.read(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(getX() + " " + getY());
		assert tileImage.getHeight(this) == brightTileImage
				.getHeight(this);
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
	}

	private TileButton containerButton(Point point) {
		Point newPoint =
				new Point(point.x / imageWidth, point.y / imageHeight);
		return buttons.get(newPoint);
	}

	public HashMap<Point, Character> getActors() {
		return actors;
	}

	public HashMap<Point, Item> getItems() {
		return items;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TileButton button = containerButton(e.getPoint());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (contains(e.getPoint())) {
			System.out.println("Gamemap entered.");
			// TODO Auto-generated method stub
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Gamemap exited.");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		/*
		 * for (TileButton[] buttons : this.buttons) { for (TileButton button :
		 * buttons) { Rectangle2D rect = new Rectangle2D.Double(button.getX(),
		 * button.getY(), button.getWidth(), button.getHeight()); if
		 * (rect.contains(e.getPoint()))
		 */{
			TileButton button = containerButton(e.getPoint());
			button.press(true);
			System.out.print("Button " + "("
					+ (button.getX() / button.getWidth() + 1) + ","
					+ (button.getY() / button.getHeight() + 1)
					+ ") pressed.\n Pressed is " + button.isPressed()
					+ ".\n");

		}
		paintComponent(getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * for (TileButton[] buttons : this.buttons) { for (TileButton button :
		 * buttons) { Rectangle2D rect = new Rectangle2D.Double(button.getX(),
		 * button.getY(), button.getWidth(), button.getHeight()); if
		 * (rect.contains(e.getPoint())) {
		 */
		TileButton button = containerButton(e.getPoint());
		button.press(false);
		System.out.println("(" + (button.getX() / button.getWidth() + 1)
				+ "," + (button.getY() / button.getHeight() + 1)
				+ ") released. Entered is " + button.isPressed());

		paintComponent(getGraphics());
	}

	@Override
	public void paintComponent(Graphics g) {
		for (TileButton button : this.buttons.values()) {
			button.paintComponent(g);
		}
	}

	public void putCharacter(Point location, Character actor)
			throws OutOfMapException {

		if (location.getX() > tilesX | location.getY() > tilesY) {
			throw new OutOfMapException((int) location.getX(),
					(int) location.getY());
		}
		if (!actors.containsKey(location)) {
			actor.setMap(this);
			actors.put(location, actor);
		}
		else {
			putCharacter(new Point((int) location.getX() + 1,
					(int) location.getY()), actor);
		}
	}

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
}
