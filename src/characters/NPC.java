
package characters;

import game.GameMap;
import utils.OutOfMapException;

public class NPC extends Character {

	private static Faction faction;

	public NPC(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map) throws OutOfMapException {
		super(name, stre, inte, agil, luc, cons, level, faction, map);
	}

	@Override
	public Faction getFaction() {
		return faction;
	}

}
