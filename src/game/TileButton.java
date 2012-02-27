package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

class TileButton extends JComponent implements MouseListener {
	private interface Executable {
		public void run(MouseEvent e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle2D rect = new Rectangle2D.Double();

	private Color color;

	private int x, y, w, h;

	private Image image;

	public TileButton(int x, int y, int w, int h, Image image) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		setSize(w, h);
		setLocation(x, y);
		enableInputMethods(true);
		addMouseListener(this);
		rect = new Rectangle2D.Double(x, y, w, h);
		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Title.png");
			image = ImageIO.read(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean Contains(Point point) {
		return rect.contains(point);
	}

	@ Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@ Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (contains(e.getPoint())) {
			setBackground(color.brighter());
		}
	}

	@ Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(color.darker());
	}

	@ Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@ Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@ Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.RED);
		g2.draw(rect);
	}

}
