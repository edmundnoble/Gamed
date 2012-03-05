
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;

import characters.Actor;

public class GameMap extends Box {

	// g.drawImage(img, w, h, null);
	private TileButton[][] buttons = new TileButton[8][10];
	private Actor[] actors = new Actor[20];
	private Image image;

	public GameMap() {
		super(BoxLayout.X_AXIS);
		// setLayout(new GridLayout(8, 10));

		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		for (int i = 0; i * imageWidth <= getWidth(); i++) {
			for (int j = 0; j * imageHeight <= getHeight(); j++) {
				buttons[i][j] =
						new TileButton((i * imageWidth) + imageWidth,
								(j * imageHeight) + imageHeight,
								imageWidth, imageHeight, image);
				add(buttons[i][j]);
			}

		}
	}

	public Actor[] getActors() {
		return actors;
	}

	public TileButton[][] getTiles() {
		return buttons;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		g2.drawImage(image, 0, 0, this);
		for (int i = 0; i * imageWidth <= getWidth(); i++) {
			for (int j = 0; j * imageHeight <= getHeight(); j++) {
				if (i + j > 0 && i + j < 80) {
					g.copyArea(imageWidth, imageHeight, imageWidth,
							imageHeight, i * imageWidth, j
									* imageHeight);
				}
			}
		}
	}

}
