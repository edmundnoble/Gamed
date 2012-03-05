
package characters;

import game.Action;
import game.Attack;
import game.GameMap;
import game.Movement;

public abstract class AI {

	private GameMap map;
	private static final Attack attack = new Attack();
	private static final Movement movement = new Movement();

	public AI(GameMap map) {
		this.map = map;
	}


	public abstract Action[] getNextAction(GameMap map);

}
