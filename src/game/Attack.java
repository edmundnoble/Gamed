package game;

import characters.Actor;

public class Attack extends Action {
	private Actor target;

	public Attack(int direction, Actor attacker, Actor target) {
		super(ActionTypes.ATTACK, attacker);
		this.target = target;
	}
}
