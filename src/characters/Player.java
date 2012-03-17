
package characters;

import game.GameMap;
import game.OutOfMapException;

public class Player extends Character {

	public Player(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map, int x, int y)
			throws OutOfMapException {
		super(name, stre, inte, agil, luc, cons, level, Faction.Player,
				map, x, y);
	}
}
