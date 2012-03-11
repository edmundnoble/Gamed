
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import characters.Actor;

public class GameMap extends JPanel {

	// g.drawImage(img, w, h, null);
	private TileButton[][] buttons = new TileButton[8][10];
	private Actor[] actors = new Actor[20];
	private Image image;

	public GameMap() {
		super();
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
		for (int i = 0; i * imageWidth <= getWidth(); i++) {
			for (int j = 0; j * imageHeight <= getHeight(); j++) {
				add(new TileButton((i * imageWidth + 1),
						(j * imageHeight), image));
			}

		}
		for (int i = 0; i < 10; i++) {
			add(new TileButton(0, 0, image));
		}
	}

	public Actor[] getActors() {
		return actors;
	}

	@Override
	public void paintComponent(Graphics g) {
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
}
