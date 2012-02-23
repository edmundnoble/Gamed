package characters;

import game.GameMap;
import game.Item;
import game.Tile;

import java.util.Date;
import java.util.Random;

public abstract class Actor {

	private Item[] inventory = new Item[20];

	private GameMap currentMap;

	int[] saves = { 1, 2, 3 };

	private int currentTileX, currentTileY;

	private ActorValue strength, intelligence, agility, constitution,
			luck = new ActorValue("Default", 0);

	private String name;

	public Actor(String name, int stre, int inte, int agil, int luc, int cons,
			GameMap map, Tile currentTile) {
		this.name = name;
		strength = new ActorValue("Strength", stre);
		intelligence = new ActorValue("Intelligence", inte);
		agility = new ActorValue("Agility", agil);
		constitution = new ActorValue("Constitution", cons);
		luck = new ActorValue("Luck", luc);
	}

	public int addToInventory(Item item) {
		for (int i = 0; i < inventory.length - 1; i++) {
			if (inventory[i].getName().equals("")) {
				inventory[i] = item;
				return 0;
			} else if (i == inventory.length - 1) {
				return 1;
			}
		}
		return 2;
	}

	public Item[] getInventory() {
		return inventory;
	}

	public GameMap getMap() {
		return currentMap;
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

	public void setTile(int x, int y) {
		currentTileX = x;
		currentTileY = y;
	}

}
