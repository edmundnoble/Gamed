package game;

import characters.Actor;

public class Attack extends Action {
	private Actor target;

	public Attack(String name, int direction, Actor attacker, Actor target) {
		super(name, ActionTypes.ATTACK, attacker);
		this.target = target;
	}
}
