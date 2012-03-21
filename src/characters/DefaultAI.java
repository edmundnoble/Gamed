
package characters;

import game.Action;
import game.GameMap;

import java.util.ArrayList;

public class DefaultAI extends AI {

	public DefaultAI(GameMap map) {
		super(map);
	}

	private ArrayList<Action> actions = new ArrayList<Action>();

	@Override
	public Action[] getNextAction(GameMap map) {
		Action[][] nextActions = new Action[9][9];
		for (Action[] nextAction : nextActions) {
			for (Character a : map.getActors().values()) {
				for (Character actor : map.getActors().values()) {
					if (a.getFaction() == Faction.Enemy) {
						if (a.equals(actor)) {
							continue;
						}
					}
				}
			}
		}

		return nextActions[1];
	}

	public ArrayList<Action> getActions() {
		return actions;
	}
}
