
package game;

import graphics.TileButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import characters.Actor;

public class GameMap extends JPanel implements MouseListener {

	// g.drawImage(img, w, h, null);
	private TileButton[][] buttons = new TileButton[8][10];
	private HashMap<Point2D, Actor> actors = new HashMap<Point2D, Actor>();
	private int tilesX = 8, tilesY = 10;
	public static Image image, brightImage;

	public void addActor(Point2D location, Actor actor)
			throws OutOfMapException {

		if (!actors.containsKey(location)) {
			actors.put(location, actor);
		}
		else if (location.getX() > tilesX | location.getY() > tilesY) {
			throw new OutOfMapException((int) location.getX(),
					(int) location.getY());
		}
		else {
			addActor(
					new Point((int) location.getX() + 1,
							(int) location.getY()), actor);
		}
	}

	public GameMap() {
		super();
		enableInputMethods(true);
		addMouseListener(this);
		try {
			ClassLoader classLoader =
					Thread.currentThread().getContextClassLoader();
			InputStream input =
					classLoader.getResourceAsStream("Title.png");
			image = ImageIO.read(input);
			input = classLoader.getResourceAsStream("Title_brighter.png");
			System.out.println(input == null);
			brightImage = ImageIO.read(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// setLayout(new GridLayout(8, 10));

		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		for (int i = 0; i < tilesX; i++) {
			for (int j = 0; j < tilesY; j++) {
				buttons[i][j] =
						new TileButton((i * imageWidth + 1),
								(j * imageHeight));
			}

		}
		int w = image.getWidth(this) * tilesX;
		int h = image.getHeight(this) * tilesY;

		setSize(w, h);
	}

	public HashMap<Point2D, Actor> getActors() {
		return actors;
	}

	@Override
	public void paintComponent(Graphics g) {
		for (TileButton[] buttons : this.buttons) {
			for (TileButton button : buttons) {
				button.paintComponent(g);
			}
		}
		for (TileButton[] buttons : this.buttons) {
			for (TileButton button : buttons) {
				button.paintComponent(g);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (TileButton[] buttons : this.buttons) {
			for (TileButton button : buttons) {
				Rectangle2D rect =
						new Rectangle2D.Double(button.getX(),
								button.getY(), button.getWidth(),
								button.getHeight());
				if (rect.contains(e.getPoint())) {
					System.out.print("Button " + "("
							+ (button.getX() / button.getWidth() + 1)
							+ ","
							+ (button.getY() / button.getHeight() + 1)
							+ ") pressed.\n Pressed is "
							+ button.isPressed() + ".\n");
					button.press(true);
					button.paintComponent(getGraphics());
				}

				else {
					button.press(false);
				}

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		for (TileButton[] buttons : this.buttons) {
			for (TileButton button : buttons) {
				Rectangle2D rect =
						new Rectangle2D.Double(button.getX(),
								button.getY(), button.getWidth(),
								button.getHeight());
				if (rect.contains(e.getPoint())) {
					System.out.println("("
							+ (button.getX() / button.getWidth() + 1)
							+ ","
							+ (button.getY() / button.getHeight() + 1)
							+ ") released. Entered is "
							+ button.isPressed());
				}
				button.press(false);
				button.paintComponent(getGraphics());
			}
		}

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

	public void addItem(Item item) {
		// TODO Auto-generated method stub

	}
}
