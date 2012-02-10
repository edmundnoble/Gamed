package game;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {

	public Dimension preferredSize;
	public int x, y, w, h;
	BufferedImage img = null;
	public Point center;
	public Point topLeft;
	private boolean walkable = true;
	private boolean destructible = false;

	public Tile(int x, int y, Graphics2D g, TerrainType terrain) {
		try {
			img = ImageIO.read(new File(terrain.textureLocation));
			w = img.getWidth(null);
			h = img.getHeight(null);

		} catch (IOException e) {
			e.printStackTrace();
		}
		preferredSize = new Dimension(w, h);

	}

	public Tile(int x, int y, Graphics2D g, TerrainType terrain,
			boolean walkable, boolean destructible) {

	}

	public Dimension getPreferredSize() {
		return preferredSize;
	}

	public boolean isDestructible() {
		return destructible;
	}

	public void setDestructible(boolean destructible) {
		this.destructible = destructible;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}
}
