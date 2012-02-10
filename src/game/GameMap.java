package game;

import java.awt.Graphics;

public class GameMap {
	// g.drawImage(img, w, h, null);
	private Tile[] tiles;

	public GameMap(Tile[] tiles) {

	}

	public void paint(Graphics g, Tile t) {
		g.drawImage(t.img, 0, 0, null);
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}
}
