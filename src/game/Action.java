package game;

import characters.Actor;

public abstract class Action {
	static enum ActionTypes {
		MOVEMENT, ATTACK, ITEMMANIP
	}

	private String name;
	private Actor actor;
	private ActionTypes type;

	public final static int DIRECTION_UP = 0, DIRECTION_RIGHT = 1,
			DIRECTION_DOWN = 2, DIRECTION_LEFT = 3;

	public Action(String name, ActionTypes type, Actor actor) {
		this.name = name;
		this.actor = actor;
		this.type = type;
	}

	public Actor getActor() {
		return actor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
