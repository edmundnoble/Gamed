package characters;

import game.Action;
import game.GameMap;

public abstract class AI {
	private GameMap map;

	public AI(GameMap map) {
		this.map = map;
	}

	public Action[] computeNext() {
		return getNextAction(map);
	}

	public abstract Action[] getNextAction(GameMap map);

}
