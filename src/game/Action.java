
package game;

import characters.Actor;


public abstract class Action {

	static enum ActionTypes {
		MOVEMENT, ATTACK, ITEM
	}

	public static enum Direction {
		DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT
	}

	private ActionTypes type;

	public abstract void act(Actor actor, Direction direction);

	public Action(ActionTypes type) {
		this.type = type;
	}

	public ActionTypes getType() {
		return type;
	}

}
