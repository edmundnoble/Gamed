
package game;

import characters.Character;

public abstract class Action {

	protected static enum ActionType {
		MOVEMENT, ATTACK, ITEM
	}

	public static enum Direction {
		DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT
	}

	protected Direction direction;
	protected Character actor;

	protected ActionType type;

	public Action(ActionType type, Character actor, Direction direction) {
		this.type = type;
		this.actor = actor;
		this.direction = direction;
	}

	public abstract void act();

}
