
package characters;

import game.GameMap;
import utils.OutOfMapException;

public class Enemy extends NPC {

	private static Faction faction = Faction.Enemy;

	public Enemy(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map) throws OutOfMapException {
		super(name, stre, inte, agil, luc, cons, level, map);
		// TODO Auto-generated constructor stub
	}

}
