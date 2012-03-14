
package characters;

import game.GameMap;

public abstract class NPC extends Actor {

	private static Faction faction;

	public NPC(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map, int x, int y) {
		super(name, stre, inte, agil, luc, cons, level, faction, map, x, y);
	}

	@Override
	public Faction getFaction() {
		return faction;
	}

}
