package game;

import characters.Actor;

class movement extends Action {
	public movement(Actor actor) {
		super(ActionTypes.MOVEMENT, actor);

	}

	public void move(Actor actor, int direction) {

		for (Tile t : actor.getMap().getTiles()) {
			if (t.x == actor.getTileX()
					&& (direction == DIRECTION_RIGHT || direction == DIRECTION_LEFT)) {
				switch (direction) {
					case DIRECTION_RIGHT:
						actor.setTile(t.x + 1, actor.getTileY());
						break;
					case DIRECTION_LEFT:
						actor.setTile(t.x - 1, actor.getTileY());
						break;
				}

			} else if (t.y == actor.getTileX() && direction == DIRECTION_UP
					|| direction == DIRECTION_DOWN) {
				switch (direction) {
					case DIRECTION_DOWN:
						;
				}
				;
			}
		}

	}
}
