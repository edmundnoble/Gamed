package characters;

import game.GameMap;
import game.Item;
import game.Tile;

import java.util.Date;
import java.util.Random;

import utils.InventoryFullException;
import utils.NoSuchItemException;

public abstract class Actor {

	private Item[] inventory = new Item[20];

	private GameMap currentMap;

	int[] saves = { 1, 2, 3 };

	public static final int MAXPARTYMEMBERS = 4;

	private Faction faction;

	private int currentTileX, currentTileY;

	private ActorValue strength, intelligence, agility, constitution, luck,
			currentHP, maxHP, level = new ActorValue();

	private String name;

	public Actor(String name, int stre, int inte, int agil, int luc, int cons,
			int level, Faction factions, GameMap map, Tile currentTile) {
		this.setName(name);
		strength = new ActorValue("Strength", stre);
		intelligence = new ActorValue("Intelligence", inte);
		agility = new ActorValue("Agility", agil);
		constitution = new ActorValue("Constitution", cons);
		luck = new ActorValue("Luck", luc);
		maxHP = new ActorValue("Max HP", (level * cons) * 2);
		currentHP = new ActorValue("HP", maxHP.getValue());
		this.faction = faction;
	}

	public int addToInventory(Item item) throws InventoryFullException,
			NoSuchItemException {
		for (int i = 0; i < inventory.length - 1; i++) {
			if (inventory[i].getName().equals("")) {
				inventory[i] = item;
				return 0;
			} else if (i == inventory.length - 1) {
				throw new InventoryFullException();
			}
		}
		throw new NoSuchItemException(item.getName());
	}

	public ActorValue getAgi() {
		return agility;
	}

	public ActorValue getCon() {
		return constitution;
	}

	public ActorValue getCurrentHP() {
		return currentHP;
	}

	public Faction getFaction() {
		return faction;
	}

	public ActorValue getInt() {
		return intelligence;
	}

	public Item[] getInventory() {
		return inventory;
	}

	public ActorValue getLuck() {
		return luck;
	}

	public GameMap getMap() {
		return currentMap;
	}

	public ActorValue getMaxHP() {
		return currentHP;
	}

	public String getName() {
		return name;
	}

	public ActorValue getStr() {
		return strength;
	}

	public int getTileX() {
		return currentTileX;
	}

	public int getTileY() {
		return currentTileY;
	}

	public boolean makeSave(int DC) {
		Random dateRand = new Random(new Date().getTime());
		double result = (dateRand.nextDouble() * 19 + 1);
		return (result > DC);
	}

	public void Move(int direction) {
	}

	public void setAV(String name, int value) {
		ActorValue[] avs = { strength, agility, constitution, intelligence,
				luck };
		for (ActorValue a : avs) {
			if (a.getName().equalsIgnoreCase(name)) {
				a.setValue(value);
			}
		}
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public void setHP(ActorValue HP) {
		currentHP = HP;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTile(int x, int y) {
		currentTileX = x;
		currentTileY = y;
	}

}
