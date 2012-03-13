
package characters;

import game.Action;
import game.GameMap;
import game.Item;
import game.Tile;
import game.Weapon;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import utils.InventoryFullException;

public abstract class Actor {

	private ArrayList<Item> inventory = new ArrayList<Item>();
	private Weapon weapon1 = Weapon.FISTS, weapon2 = null;
	private static int MAX_INVENTORY = 20;
	private GameMap currentMap;
	private Action currentAction = null;

	enum Save {
		FORTITUDE, WILL, REFLEX
	}

	public Weapon[] getEquippedWeapons() {
		Weapon[] weapons = { weapon1, weapon2 };
		return weapons;
	}

	public void setNextAction(Action action) {
		currentAction = action;
	}

	public Action getNextAction() {
		return currentAction;
	}

	public void pickup(Item item) {
		if (inventory.size() >= MAX_INVENTORY) {
			return;
		}
		else {
			inventory.add(item);
		}

	}

	public void drop(Item item) {
		if (inventory.contains(item)) {
			inventory.remove(item);
			currentMap.addItem(item);
		}
		else {
			utils.UserMessage.send("");
		}
	}

	public static final int MAXPARTYMEMBERS = 4;

	private Faction faction;

	private int currentTileX, currentTileY;

	private ActorValue strength, intelligence, agility, constitution,
			luck, currentHP, maxHP, level = new ActorValue();

	private String name;

	public Actor(String name, int stre, int inte, int agil, int luc,
			int cons, int level, Faction faction, GameMap map,
			Tile currentTile) {
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

	public void useItem(Item item) {
		if (item instanceof Weapon) {
			equip(item);
		}
		else {
			item.use(this);
		}
	}

	public void addToInventory(Item item) throws InventoryFullException {
		if (inventory.toArray().length >= 20) {
			throw new InventoryFullException();
		}
		else {
			inventory.add(item);
		}
	}

	public ActorValue getAgi() {
		return agility;
	}

	public ActorValue getCon() {
		return constitution;
	}

	public int getHP() {
		return currentHP.getValue();
	}

	public Faction getFaction() {
		return faction;
	}

	public ActorValue getInt() {
		return intelligence;
	}

	public Item[] getInventory() {
		return (Item[]) inventory.toArray();
	}

	public void equip(Item item) {

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

	public boolean makeSave(Save type, int DC) {
		Random dateRand = new Random(new Date().getTime());
		double result = (dateRand.nextDouble() * 19 + 1);
		return (result > DC);
	}

	public void setAV(String name, int value) {

		ActorValue[] avs =
				{ strength, agility, constitution, intelligence, luck };
		for (ActorValue a : avs) {
			if (a.getName().equalsIgnoreCase(name)) {
				a.setValue(value);
				break;
			}
		}
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public void setHP(int hp) {
		currentHP.setValue(hp);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTileX(int x) {
		currentTileX = x;
	}

	public void setTileY(int y) {
		currentTileY = y;
	}

}
