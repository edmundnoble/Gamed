package utils;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {

	public Dimension preferredSize;
	int w, h, x, y;
	BufferedImage img = null;
	public Point center;
	public Point topLeft;

	public Tile(int x, int y, Graphics2D g, TerrainType terrain) {
		try {
			img = ImageIO.read(new File(""));
			w = img.getWidth(null);
			h = img.getHeight(null);

		} catch (IOException e) {
			e.printStackTrace();
		}
		preferredSize = new Dimension(w, h);

	}

	public Dimension getPreferredSize() {
		return preferredSize;
	}
}
