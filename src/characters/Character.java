
package characters;

import game.GameMap;
import game.Item;
import game.Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import utils.InventoryFullException;

public abstract class Character {

	enum Save {
		FORTITUDE, WILL, REFLEX
	}

	public void paintCharacter(Graphics g) {
		CharacterModel model = new CharacterModel(name);
	}

	class CharacterModel {

		public static final int GREEN = 0, BLUE = 1, RED = 2;
		private boolean green, blue, red;
		private String name;
		private Image[] headImages = new Image[3],
				armImages = new Image[3], bodyImages = new Image[3];
		private Image currentBody, currentArms, currentHead, fullImage,
				weaponImage;

		public CharacterModel(String name) {
			this(name, true, false, false);
		}

		public void updateWeaponTexture() {
			BufferedImage finalImage =
					new BufferedImage(60, 60,
							BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D graphics = finalImage.createGraphics();
			graphics.drawImage(currentBody, 0, 0, null);
			graphics.drawImage(currentArms, currentBody.getHeight(null),
					currentBody.getWidth(null) / 2, null);
			graphics.drawImage(currentHead, currentBody.getHeight(null)
					+ currentArms.getHeight(null),
					currentBody.getWidth(null) / 2, null);
			if (weaponImage != null) {
				graphics.drawImage(
						weaponImage,
						(currentBody.getWidth(null) / 2)
								+ (currentArms.getWidth(null) / 2),
						currentBody.getHeight(null)
								+ currentArms.getHeight(null), null);
			}
			fullImage = finalImage;
		}

		public Image getFullImage() {
			return fullImage;
		}

		public CharacterModel(String name, boolean green, boolean blue,
				boolean red) {
			this.name = name;
			this.green = green;
			this.blue = blue;
			this.red = red;
			if (!(green || blue || red)) {
				throw new IllegalArgumentException("No possible colours!");
			}
			initTextures();
		}

		public void setWeaponImage(Image image) {
			weaponImage = image;
		}

		private Image assembleImages(Image headImage, Image armsImage,
				Image bodyImage) {
			BufferedImage finalImage =
					new BufferedImage(50, 50,
							BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D graphics = finalImage.createGraphics();
			currentBody = bodyImage;
			currentArms = armsImage;
			currentHead = headImage;
			updateWeaponTexture();
			return finalImage;
		}

		public Image getBlueImage() {
			return getImages(BLUE, BLUE, BLUE);
		}

		public Image getGreenImage() {
			return getImages(GREEN, GREEN, GREEN);
		}

		private Image getImages(int headColor, int armColor, int bodyColor) {
			return assembleImages(headImages[headColor],
					armImages[armColor], bodyImages[bodyColor]);
		}

		public String getName() {
			return name;
		}

		public Image getRandomImage() {
			Random rand = new Random();
			boolean[] colours = { green, red, blue };
			int possibleInts = 3;
			for (boolean b : colours) {
				if (!b) {
					possibleInts--;
				}
			}
			int[] randNums = new int[3];
			Image image;
			for (int i = 0; i < possibleInts - 1; i++) {
				randNums[i] = (int) (rand.nextDouble() * 3);
			}
			return getImages(randNums[0], randNums[1], randNums[2]);
		}

		public Image getRedImages() {
			return getImages(RED, RED, RED);
		}

		public void initTextures() {
			try {
				String imageLoc = "res" + File.separator + name + "_";
				String headLoc = imageLoc + "head_", armsLoc =
						imageLoc + "arms_", bodyLoc = imageLoc + "body_";
				if (green) {
					headImages[GREEN] =
							GameMap.loadImage(headLoc + "green");
					armImages[GREEN] =
							GameMap.loadImage(armsLoc + "green");
					bodyImages[GREEN] =
							GameMap.loadImage(bodyLoc + "green");
				}
				if (blue) {
					headImages[BLUE] = GameMap.loadImage(headLoc + "blue");
					armImages[BLUE] = GameMap.loadImage(armsLoc + "blue");
					bodyImages[BLUE] = GameMap.loadImage(bodyLoc + "blue");
				}
				if (red) {
					headImages[RED] = GameMap.loadImage(headLoc + "red");
					armImages[RED] = GameMap.loadImage(armsLoc + "red");
					bodyImages[RED] = GameMap.loadImage(bodyLoc + "red");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected CharacterModel model;

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

	public void paint(Graphics2D g) {

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
