
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
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

	private Image image;

	public TileButton(int x, int y, Image image) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.h = image.getHeight(this);
		this.w = image.getWidth(this);
		setSize(w, h);
		setLocation(x, y);
		// enableInputMethods(true);
		// addMouseListener(this);
	}

	public TileButton(int x, int y, Image image, Actor actor) {
		this(x, y, image);
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
		setBackground(Color.RED);
		g.drawImage(image, x, y, color, this);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(x + " button clicked.");
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed.");
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(x + "," + y + " button clicked.");
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
