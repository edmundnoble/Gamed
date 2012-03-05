
package characters;

import game.Action;
import game.GameMap;

public class DefaultAI extends AI {

	public DefaultAI(GameMap map) {
		super(map);
	}


	@Override
	public Action[] getNextAction(GameMap map) {
		Action[][] nextActions = new Action[9][9];
		for (Action[] nextAction : nextActions) {
			for (Actor a : map.getActors()) {
				if (a.getFaction() == Faction.Enemy) {

				}
			}
		}

		return nextActions[1];
	}
}
