
package characters;

import game.GameMap;

public class Player extends Actor {

	public Player(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map, int x, int y) {
		super(name, stre, inte, agil, luc, cons, level, Faction.Player,
				map, x, y);
	}

}
