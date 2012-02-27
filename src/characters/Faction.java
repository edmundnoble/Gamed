package characters;

public class Faction {
	private static enum FactionID {
		PLAYER, TRADER, ENEMY
	}

	public static final Faction Enemy = new Faction(FactionID.ENEMY);
	public static final Faction Player = new Faction(FactionID.PLAYER);
	public static final Faction Trader = new Faction(FactionID.TRADER);

	private FactionID id;

	public Faction(FactionID id) {
		this.id = id;
	}

	public Faction(FactionID id, boolean[] l) {
	}

	public Faction(FactionID id, int[] RELATIONS) {
		this.id = id;
	}

	public FactionID getID() {
		return id;
	}
}
