
package game;

import characters.Actor;

public class Attack extends Action {

	private Actor target;

	public Attack() {
		super(ActionTypes.ATTACK);
	}

	@Override
	public void act(Actor actor, Direction direction) {
		switch (direction) {
			case DIRECTION_UP: {
				break;
			}
			case DIRECTION_DOWN: {
				break;
			}
			case DIRECTION_RIGHT: {
				break;
			}
			case DIRECTION_LEFT: {
				break;
			}
		}
	}
}
