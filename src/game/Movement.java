
package game;

import characters.Actor;

public class Movement extends Action {


	public Movement() {
		super(ActionTypes.MOVEMENT);
	}


	@Override
	public void act(Actor actor, Direction direction) {
		switch (direction) {
			case DIRECTION_UP:
				if (actor.getTileY() == 9) {
					actor.setTileY(0);
				}
				else {
					actor.setTileY(actor.getTileY() + 1);
				}
			case DIRECTION_DOWN:
				if (actor.getTileY() == 0) {
					actor.setTileY(9);
				}
				else {
					actor.setTileY(actor.getTileY() - 1);
				}
			case DIRECTION_RIGHT:
				if (actor.getTileX() == 9) {
					actor.setTileX(0);
				}
				else {
					actor.setTileX(actor.getTileX() + 1);
				}
			case DIRECTION_LEFT:
				if (actor.getTileX() == 0) {
					actor.setTileX(9);
				}
				else {
					actor.setTileX(actor.getTileX() - 1);
				}
		}
	}
}
