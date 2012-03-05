package characters;

import game.GameMap;
import game.Tile;

public class Enemy extends NPC {
	private static Faction faction = Faction.Enemy;

	public Enemy(String name, int stre, int inte, int agil, int luc, int cons,
			int level, GameMap map, Tile currentTile) {
		super(name, stre, inte, agil, luc, cons, level, map, currentTile);
		// TODO Auto-generated constructor stub
	}

}
