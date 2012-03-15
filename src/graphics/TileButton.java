
package graphics;

import game.GameMap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import characters.Actor;

public class TileButton extends JComponent {

	/**
	 * 
	 */

	private static final long serialVersionUID = -12314L;
	private Rectangle2D rect = new Rectangle2D.Double();

	private Color color = Color.BLACK;

	private Actor actor = null;

	private int x;
	private int y;
	private int w;
	private int h;

	private Image image, brightImage;

	public TileButton(int x, int y) {
		super();
		image = GameMap.image;
		brightImage = GameMap.brightImage;
		this.x = x;
		this.y = y;
		this.h = image.getHeight(this);
		this.w = image.getWidth(this);
		setSize(w, h);
		setLocation(x, y);

	}

	public TileButton(int x, int y, Actor actor) {
		this(x, y);
		this.actor = actor;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	@Override
	public void paintComponent(Graphics g) {
		if (!entered) {
			g.drawImage(image, x, y, this);
		}
		else {
			g.drawImage(brightImage, x, y, this);
		}
	}

	public void entered(boolean enable) {
		entered = enable;
	}

	private boolean entered = false;

}
