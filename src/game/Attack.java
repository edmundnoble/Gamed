
package game;

import characters.Actor;

public class Attack extends Action {

	private Actor target;

	public Attack() {
		super(ActionTypes.ATTACK);
	}

	@Override
	public void act(Actor actor, Direction direction) {

	}
}
