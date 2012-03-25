
package graphics;

import game.GameMap;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JComponent;

public class TileButton extends JComponent {

	private static final long serialVersionUID = -1789637952468141155L;

	private int x;
	private int y;
	private int w;
	private int h;

	private Image image = GameMap.tileImage,
			brightImage = GameMap.brightTileImage,
			redImage = GameMap.redTileImage;

	private boolean pressed = false, redPressed = false;

	public TileButton(int x, int y) throws HeadlessException {
		super();
		this.x = x;
		this.y = y;
		this.h = image.getHeight(this);
		this.w = image.getWidth(this);
		setSize(w, h);
		setLocation(x, y);
	}

	public boolean isPressed() {
		return pressed;
	}

	public boolean isRed() {
		return redPressed;
	}

	@Override
	public void paintComponent(Graphics g) {
		if (redPressed) {
			g.drawImage(redImage, x, y, this);
		}
		else if (pressed) {
			g.drawImage(brightImage, x, y, this);
		}
		else {
			g.drawImage(image, x, y, this);
		}

	}

	public void press(boolean enable) {
		pressed = enable;
	}

	public void pressRed(boolean enable) {
		redPressed = enable;
	}

}
