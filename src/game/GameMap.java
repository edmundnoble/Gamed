package game;

import java.awt.Graphics;

public class GameMap {
	// g.drawImage(img, w, h, null);
	private Tile[][] tiles;

	public GameMap(Tile[][] tiles) {

	}


	public void paint(Graphics g, Tile t) {
		g.drawImage(t.img, arg1, arg2, null);
	}
}
