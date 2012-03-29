
package characters;

import game.GameMap;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Random;

class CharacterModel {

	public static final int GREEN = 0, BLUE = 1, RED = 2;
	private boolean green, blue, red;
	private String headLoc, armsLoc, legsLoc, chestLoc;
	private String name = "default";
	private Image[] headImages = new Image[3], armImages = new Image[3],
			bodyImages = new Image[3];
	private Image finalImage;

	public CharacterModel(String name) {
		this(name, true, true, true);
	}

	public CharacterModel(String name, boolean green, boolean blue,
			boolean red) {
		this.name = name;
		this.green = green;
		this.blue = blue;
		this.red = red;
		if (!green && !blue && !red) {
			throw new IllegalArgumentException("No possible colours!");
		}
		initTextures();
	}

	private Image assembleImages(Image headImage, Image armsImage,
			Image bodyImage) {
		System.out.println(BufferedImage.class.isInstance(Raster.class));
		BufferedImage finalImage =
				new BufferedImage(50, 50, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D graphics = finalImage.createGraphics();
		graphics.drawImage(bodyImage, 0, 0, null);
		graphics.drawImage(armsImage, bodyImage.getHeight(null),
				bodyImage.getWidth(null) / 2, null);
		graphics.drawImage(headImage, bodyImage.getHeight(null)
				+ armsImage.getHeight(null), bodyImage.getWidth(null) / 2,
				null);
		return finalImage;
	}

	public Image getBlueImage() {
		return getImages(BLUE, BLUE, BLUE);
	}

	public Image getGreenImage() {
		return getImages(GREEN, GREEN, GREEN);
	}

	private Image getImages(int headColor, int armColor, int bodyColor) {
		return assembleImages(headImages[headColor], armImages[armColor],
				bodyImages[bodyColor]);
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
				headImages[GREEN] = GameMap.loadImage(headLoc + "green");
				armImages[GREEN] = GameMap.loadImage(armsLoc + "green");
				bodyImages[GREEN] = GameMap.loadImage(bodyLoc + "green");
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
