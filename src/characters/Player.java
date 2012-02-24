package characters;

import game.GameMap;
import game.Tile;

public abstract class Player extends Actor {

	public Player(String name, int stre, int inte, int agil, int luc, int cons,
			int level, GameMap map, Tile currentTile) {
		super(name, stre, inte, agil, luc, cons, level, Faction.Player, map,
				currentTile);
	}

}
