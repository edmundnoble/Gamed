
package game;

import characters.Character;

public class Attack extends Action {

	public Attack(Character actor, Direction direction) {
		super(ActionType.ATTACK, actor, direction);
	}

	@Override
	public void act() {
		switch (direction) {
			case DIRECTION_UP: {
				for (Weapon w : actor.getEquippedWeapons()) {
					break;
				}
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
