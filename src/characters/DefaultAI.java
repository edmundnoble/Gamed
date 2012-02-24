package characters;

import game.Action;
import game.GameMap;

public class DefaultAI extends AI {

	public DefaultAI(GameMap map) {
		super(map);
	}

	@ Override
	public Action getNextAction(GameMap map) {
		for (Actor a : map.getActors()) {
			if (a.getFaction() == Faction.Enemy) {
				for (Actor c : map.getActors()) {
					int cpos = c.getTileX() + c.getTileY();
					int apos = a.getTileX() + a.getTileY();
					if ((c.getTileX() + c.getTileY() < (a.getTileX() + c
							.getTileY() * 0.8))) {
					}
				}
			}
		}
		return null;
	}
}
