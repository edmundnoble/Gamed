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
					if (cpos + 2 >= apos || cpos - 2 <= apos) {
						if (Math.abs((c.getTileX() - a.getTileX())) < 3) {
						}
					}
				}
			}
		}
		return null;
	}
}
