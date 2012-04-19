
package characters;

import game.GameMap;
import game.Item;
import game.Restorative;
import game.Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;

import utils.ImageUtils;
import utils.InventoryFullException;

public class Character {

	enum Save {
		FORTITUDE, REFLEX, WILL
	}

	private static final int BODY_PARTS = 4;
	public static final int GREEN = 0, BLUE = 1, RED = 2;
	private static final int MAX_INVENTORY = 20;
	public static final int MAXPARTYMEMBERS = 4;

	private boolean acted = false;

	private GameMap currentMap;

	private Faction faction;

	private Image fullImage;

	private boolean green, blue, red;

	private ArrayList<Item> inventory = new ArrayList<Item>();

	private String name;

	private ActorValue strength, intelligence, agility, constitution,
			luck, currentHP, maxHP, level = new ActorValue();

	private Weapon weapon1 = Weapon.FISTS, weapon2 = null;

	private long xp;

	public Character(String name, int stre, int inte, int agil, int luc,
			int cons, int level, Faction faction, GameMap map) {
		// model = new CharacterModel(name);
		this.name = name;
		strength = new ActorValue("Strength", stre);
		intelligence = new ActorValue("Intelligence", inte);
		agility = new ActorValue("Agility", agil);
		constitution = new ActorValue("Constitution", cons);
		luck = new ActorValue("Luck", luc);
		maxHP = new ActorValue("Max HP", (level * cons) * 2);
		currentHP = new ActorValue("HP", maxHP.getValue());
		this.faction = faction;
		fullImage = assembleImages(loadImages(name));
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

	private Image assembleImages(Hashtable<String, Image> table) {
		// if (table.size() != BODY_PARTS) {
		// throw new IllegalArgumentException(
		// table.size() > BODY_PARTS ? "Too many images!"
		// : "Not enough images!");
		// }
		BufferedImage finalImage =
				new BufferedImage(50, 50, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D graphics = finalImage.createGraphics();
		graphics.drawImage(table.get("HEAD"), 10, 10, null);
		return finalImage;
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
	};;

	public Faction getFaction() {
		return faction;
	}

	public Image getFullImage() {
		return fullImage;
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

	public Hashtable<String, Image> loadImages(String name) {
		Image currentArms, currentBody, currentHead;
		String imageLoc = name + "_";
		String headLoc = imageLoc + "head.png", armsLoc =
				imageLoc + "arms.png", bodyLoc = imageLoc + "body.png";
		try {
			currentArms = ImageUtils.loadImage("char1_head.png");
			currentArms = ImageUtils.loadImage(armsLoc);
			currentBody = ImageUtils.loadImage(bodyLoc);
			currentHead = ImageUtils.loadImage(headLoc);
			Hashtable<String, Image> table =
					new Hashtable<String, Image>();
			table.put("HEAD", currentHead);
			table.put("ARMS", currentArms);
			table.put("BODY", currentBody);
			return table;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean makeSave(Save type, int DC) {
		Random dateRand = new Random(new Date().getTime());
		double result = (dateRand.nextDouble() * 19 + 1);
		return (result > DC);
	}

	public void paintCharacter(Graphics g) {
		g.drawImage(fullImage, 1, 1, null);
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
		if (item instanceof Weapon) {
		}
		else if (item instanceof Restorative) {
		}
	}

}
