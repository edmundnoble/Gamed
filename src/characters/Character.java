
package characters;

import game.GameMap;
import game.Item;
import game.Weapon;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import utils.InventoryFullException;

public abstract class Character {

	enum Save {
		FORTITUDE, WILL, REFLEX
	}

	private CharacterModel model;

	private ArrayList<Item> inventory = new ArrayList<Item>();

	private Weapon weapon1 = Weapon.FISTS, weapon2 = null;
	private static final int MAX_INVENTORY = 20;
	private GameMap currentMap;
	private boolean acted = false;

	public static final int MAXPARTYMEMBERS = 4;

	private Faction faction;

	private long xp;

	private ActorValue strength, intelligence, agility, constitution,
			luck, currentHP, maxHP, level = new ActorValue();

	private String name;

	public Character(String name, int stre, int inte, int agil, int luc,
			int cons, int level, Faction faction, GameMap map) {
		model = new CharacterModel(name);
		this.name = name;
		strength = new ActorValue("Strength", stre);
		intelligence = new ActorValue("Intelligence", inte);
		agility = new ActorValue("Agility", agil);
		constitution = new ActorValue("Constitution", cons);
		luck = new ActorValue("Luck", luc);
		maxHP = new ActorValue("Max HP", (level * cons) * 2);
		currentHP = new ActorValue("HP", maxHP.getValue());
		this.faction = faction;
	}

	public void addToInventory(Item item) throws InventoryFullException {
		if (inventory.toArray().length >= 20) {
			throw new InventoryFullException();
		}
		else {
			inventory.add(item);
		}
	}

	public void addXp(long xp) {
		if (calcXP(level.getValue()) < this.xp + xp) {
			this.xp = (this.xp + xp) % calcXP(level.getValue() + 1);
		}
		else {
			this.xp += xp;
		}
	}

	public long calcXP(int level) {
		long xp = (1L >>> level) * 100;
		return xp;
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

	public long getXp() {
		return xp;
	}

	public boolean hasActed() {
		return acted;
	}

	public void kill(Character other) {

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
				return;
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

	public void setMap(GameMap gameMap) {
		currentMap = gameMap;
	}

	public void useItem(Character actor, Item item) {
		item.use(actor);
	}

}
