package characters;

import game.Action;
import game.Attack;
import game.GameMap;

public class DefaultAI extends AI {

	public DefaultAI(GameMap map) {
		super(map);
	}

	@ Override
	public Action[] getNextAction(GameMap map) {
		Action[][] nextActions = new Action[9][9];
		for (int l = 0; l < nextActions.length; l++) {
			for (Actor a : map.getActors()) {
				if (a.getFaction() == Faction.Enemy) {
					for (Actor c : map.getActors()) {
						if (c.getFaction() == Faction.Player) {
							if (c == a) {
								continue;
							}
						}
						for (int i = 0; i < 10; i++) {
							if (a.getTileX() - c.getTileX() == 1) {
								nextActions[l][i] = new Attack(
										Action.DIRECTION_RIGHT, a, c);
							} else if (a.getTileX() - c.getTileX() == -1) {
								nextActions[l][i] = new Attack(
										Action.DIRECTION_LEFT, a, c);
							} else if (a.getTileY() - c.getTileY() == 1) {
								nextActions[l][i] = new Attack(
										Action.DIRECTION_DOWN, a, c);
							} else if (a.getTileY() - c.getTileY() == -1) {
								nextActions[l][i] = new Attack(
										Action.DIRECTION_DOWN, a, c);
							}
							// nextActions[0] = new Attack(a, c);
						}
					}
				}
			}
		}

		return nextActions[1];
	}
}
