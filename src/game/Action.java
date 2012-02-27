package game;

import characters.Actor;

public abstract class Action {
	static enum ActionTypes {
		MOVEMENT, ATTACK, ITEMMANIP
	}

	public static enum Direction {
		DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT
	}

	private Actor actor;
	private ActionTypes type;
	public final static int DIRECTION_UP = 0, DIRECTION_RIGHT = 1,
			DIRECTION_DOWN = 2, DIRECTION_LEFT = 3;

	public Action(ActionTypes type, Actor actor) {
		this.actor = actor;
		this.type = type;
	}

	public Actor getActor() {
		return actor;
	}

}
