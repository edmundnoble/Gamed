package game;

import java.awt.Graphics;

import characters.Actor;

public class GameMap {
	// g.drawImage(img, w, h, null);
	private Tile[] tiles;
	private Actor[] actors;

	public GameMap(Tile[] tiles) {
		this.tiles = tiles;
	}

	public Actor[] getActors() {
		return actors;
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public void paint(Graphics g, Tile t) {
		g.drawImage(t.img, 0, 0, null);
	}

	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}
}
