
package characters;

import game.GameMap;

public class Enemy extends NPC {

	private static Faction faction = Faction.Enemy;

	public Enemy(String name, int stre, int inte, int agil, int luc,
			int cons, int level, GameMap map, int x, int y) {
		super(name, stre, inte, agil, luc, cons, level, map, x, y);
		// TODO Auto-generated constructor stub
	}

}
