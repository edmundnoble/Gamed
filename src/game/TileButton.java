
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import characters.Actor;

public class TileButton extends JComponent implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle2D rect = new Rectangle2D.Double();

	private Color color;

	private Actor actor = null;

	private int x, y, w, h;

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
		enableInputMethods(true);
		addMouseListener(this);
		rect = new Rectangle2D.Double(x, y, w, h);
	}

	public TileButton(int x, int y, Image image, Actor actor) {
		this(x, y, image);
		this.actor = actor;
	}

	public boolean Contains(Point point) {
		return rect.contains(point);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * if (contains(e.getPoint())) {
		 * setBackground(color.brighter().brighter().brighter()); }
		 */
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// setBackground(color.darker().darker().darker());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.RED);
		// g2.drawRect(100, 100, 100, 100);
		g.drawImage(image, x, y, color, this);
	}

}
