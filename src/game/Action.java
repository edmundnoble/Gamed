
package game;

import characters.Character;

public abstract class Action {

	public Action(ActionType type, Character actor, Direction direction) {
		this.type = type;
		this.actor = actor;
		this.direction = direction;
	}

	protected Direction direction;
	protected Character actor;
	protected ActionType type;

	static enum ActionType {
		MOVEMENT, ATTACK, ITEM
	}

	public static enum Direction {
		DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT
	}

	public abstract void act();

}
