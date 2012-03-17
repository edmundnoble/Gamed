
package game;

import characters.Character;

public class Movement extends Action {

	public Movement(Character actor, Direction direction) {
		super(ActionType.MOVEMENT, actor, direction);
	}

	@Override
	public void act() {
		switch (direction) {

		}
	}
}
