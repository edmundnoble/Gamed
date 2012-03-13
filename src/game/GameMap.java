
package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	private Image image;

	public void addActor(Actor actor, Point2D location) {
		actors.put(location, actor);
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
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// setLayout(new GridLayout(8, 10));

		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {
				buttons[i][j] =
						new TileButton((i * imageWidth + 1),
								(j * imageHeight), image);
			}

		}
		int w = 0;
		int h = 0;
		for (TileButton[] buttons : this.buttons) {
			for (TileButton button : buttons) {
				w += button.getWidth();
				h += button.getHeight();
			}
		}
		setSize(new Dimension(w, h));
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
		g.drawImage(image, 1, 1, this);
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		Graphics2D g2 = (Graphics2D) g;
		// g2.drawImage(image, 0, 0, this);
		/*
		 * for (int i = 0; i * imageWidth <= getWidth(); i++) { for (int j = 0;
		 * j * imageHeight <= getHeight(); j++) { if (i + j > 0 && i + j < 80) {
		 * g2.copyArea(0, 0, imageWidth, imageHeight, i imageWidth + imageWidth,
		 * j imageHeight); } } }
		 */
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
					System.out.print("Button " + "(" + button.getX()
							/ button.getWidth() + "," + button.getY()
							/ button.getHeight() + ") pressed.\n");
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (contains(e.getPoint())) {
			System.out.println("LOL");
			// TODO Auto-generated method stub
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void addItem(Item item) {
		// TODO Auto-generated method stub

	}
}
