package characters;

import game.GameMap;
import game.Tile;

public abstract class NPC extends Actor {
	private static Faction faction;

	public NPC(String name, int stre, int inte, int agil, int luc, int cons,
			int level, GameMap map, Tile currentTile) {
		super(name, stre, inte, agil, luc, cons, level, faction, map,
				currentTile);
	}

	@ Override
	public Faction getFaction() {
		return faction;
	}

}
