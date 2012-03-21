
package characters;

import game.GameMap;
import utils.OutOfMapException;

public class Player extends Character {

	public Player(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map) throws OutOfMapException {
		super(name, stre, inte, agil, luc, cons, level, Faction.Player,
				map);
	}
}
