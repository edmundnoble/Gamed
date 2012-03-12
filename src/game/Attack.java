
package game;

import characters.Actor;

public class Attack extends Action {

	public Attack(Actor actor, Direction direction) {
		super(ActionType.ATTACK, actor, direction);
	}

	@Override
	public void act() {
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
