
package characters;

import game.GameMap;
import game.Item;
import game.Weapon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import utils.InventoryFullException;
import utils.NoSuchItemException;
import utils.OutOfMapException;

public abstract class Character {

	enum Save {
		FORTITUDE, WILL, REFLEX
	}

	private ArrayList<Item> inventory = new ArrayList<Item>();
	private Weapon weapon1 = Weapon.FISTS, weapon2 = null;
	private static int MAX_INVENTORY = 20;
	private GameMap currentMap;

	private boolean acted = false;

	public static final int MAXPARTYMEMBERS = 4;

	private Faction faction;

	private long xp;

	private ActorValue strength, intelligence, agility, constitution,
			luck, currentHP, maxHP, level = new ActorValue();

	private String name;

	private Point location = new Point();

	public Character(String name, int stre, int inte, int agil, int luc,
			int cons, int level, Faction faction, GameMap map, int x, int y)
			throws OutOfMapException {

		this.setName(name);
		strength = new ActorValue("Strength", stre);
		intelligence = new ActorValue("Intelligence", inte);
		agility = new ActorValue("Agility", agil);
		constitution = new ActorValue("Constitution", cons);
		luck = new ActorValue("Luck", luc);
		maxHP = new ActorValue("Max HP", (level * cons) * 2);
		currentHP = new ActorValue("HP", maxHP.getValue());
		this.faction = faction;
		map.putCharacter(new Point(x, y), this);
	}

	public void addToInventory(Item item) throws InventoryFullException {
		if (inventory.toArray().length >= 20) {
			throw new InventoryFullException();
		}
		else {
			inventory.add(item);
		}
	}

	public void dropItem(Item item) throws NoSuchItemException,
			OutOfMapException {
		if (!inventory.contains(item)) {
			throw new NoSuchItemException("You don't have a "
					+ item.getName());
		}
		else {
			try {
				currentMap.putItem(location, item);
				inventory.remove(item);
			} catch (OutOfMapException e) {

			}
		}
	}

	public void equip(Item item) {

	}

	public ActorValue getAgi() {
		return agility;
	}

	public ActorValue getCon() {
		return constitution;
	}

	public Weapon[] getEquippedWeapons() {
		Weapon[] weapons = { weapon1, weapon2 };
		return weapons;
	}

	public Faction getFaction() {
		return faction;
	}

	public int getHP() {
		return currentHP.getValue();
	}

	public ActorValue getInt() {
		return intelligence;
	}

	public Item[] getInventory() {
		return (Item[]) inventory.toArray();
	}

	public ActorValue getLevel() {
		return level;
	}

	public Point getLocation() {
		return location;
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

	public boolean hasActed() {
		return acted;
	}

	public void levelUp() {
		xp = 0;

	}

	public boolean makeSave(Save type, int DC) {
		Random dateRand = new Random(new Date().getTime());
		double result = (dateRand.nextDouble() * 19 + 1);
		return (result > DC);
	}

	public void pickup(Item item) {
		if (inventory.size() >= MAX_INVENTORY) {
			return;
		}
		else {
			inventory.add(item);
		}

	}

	public void setActed(boolean enable) {
		acted = enable;
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

	public void setLevel(ActorValue level) {
		this.level = level;
	}

	public void setLocation(Point newLoc) {
		location = newLoc;
	}

	public void setMap(GameMap gameMap) {
		currentMap = gameMap;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void useItem(Item item) {
		item.use(this);
	}

}
