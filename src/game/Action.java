
package game;

import characters.Actor;

public abstract class Action {

	public Action(ActionType type, Actor actor, Direction direction) {
		this.type = type;
		this.actor = actor;
		this.direction = direction;
	}

	protected Direction direction;
	protected Actor actor;
	protected ActionType type;

	static enum ActionType {
		MOVEMENT, ATTACK, ITEM
	}

	public static enum Direction {
		DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT
	}

	public abstract void act();

}
