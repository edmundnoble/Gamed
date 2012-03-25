
package characters;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Random;

public class CharacterModel {

	private Point handPoint;
	public static final int GREEN = 0, BLUE = 1, RED = 2;
	private boolean green, blue, red;
	private String headLoc, armsLoc, legsLoc, chestLoc;
	private String name = "default";
	private Image[] headImages = new Image[3], armImages = new Image[3],
			legImages = new Image[3];
	private Image finalImage;

	public CharacterModel(String name) {
		this(name, true, true, true);
	}

	public CharacterModel(String name, boolean green, boolean blue,
			boolean red) {
		this.green = green;
		this.blue = blue;
		this.red = red;
		if (!green && !blue && !red) {
			throw new IllegalArgumentException("No possible colours!");
		}
		initTextures();
		findHandPoint(new BufferedImage(1, 1,
				BufferedImage.TYPE_4BYTE_ABGR));
	}

	public Image assembleImages(Image[] images) {
		System.out.println(BufferedImage.class.isInstance(Raster.class));
		return new BufferedImage(0, 0, BufferedImage.TYPE_4BYTE_ABGR_PRE,
				null);
	}

	public void findHandPoint(Image armsImage) {
		BufferedImage bufImage = (BufferedImage) armsImage;
		Raster raster = bufImage.getData();
		System.out.println(raster.getWidth());
		int numChannels = raster.getNumBands();
		int[] iBufferArray = new int[400000];
		int[] iArray = new int[400000];
		/*
		 * new int[numChannels * raster.getWidth() * raster.getMinY()], iArray =
		 * new int[4];
		 */
		System.out.println(raster.getNumBands() * raster.getWidth()
				* raster.getHeight());
		iArray =
				raster.getPixels(raster.getWidth(), raster.getMinY(), 1,
						raster.getHeight(), iBufferArray);

		for (int i : iBufferArray) {
			System.out.println(i);
		}
	}

	public Image[] getBlueImages() {
		Image[] images =
				{ headImages[BLUE], armImages[BLUE], legImages[BLUE] };
		return images;
	}

	public Image[] getGreenImages() {
		Image[] images =
				{ headImages[GREEN], armImages[GREEN], legImages[GREEN] };
		return images;
	}

	public Image[] getImages(int headColor, int armColor, int legColor) {
		Image[] images =
				{ headImages[headColor], armImages[armColor],
						legImages[legColor] };

		return images;
	}

	public String getName() {
		return name;
	}

	public Image[] getRandomImages() {
		Random rand = new Random(System.nanoTime());
		int possibleInts = 3;
		if (!green) {
			possibleInts--;
		}
		if (!red) {
			possibleInts--;
		}
		if (!blue) {
			possibleInts--;
		}
		int[] randNums = new int[3];
		Image[] images = new Image[3];
		for (int i = 0; i < possibleInts - 1; i++) {
			randNums[i] = (int) (rand.nextDouble() * 3);
		}
		images = getImages(randNums[0], randNums[1], randNums[2]);
		return images;
	}

	public Image[] getRedImages() {
		Image[] images =
				{ headImages[RED], armImages[RED], legImages[RED] };
		return images;
	}

	public void initTextures() {/*
								 * headLoc = "res" + File.separatorChar + name +
								 * "_head_"; armsLoc = "res" +
								 * File.separatorChar + name + "_arms_"; legsLoc
								 * = "res" + File.separatorChar + name +
								 * "_legs_"; ClassLoader classLoader =
								 * Thread.currentThread
								 * ().getContextClassLoader();
								 * 
								 * try { if (green) { headImages[GREEN] =
								 * ImageIO.read(classLoader
								 * .getResourceAsStream(headLoc + "GREEN"));
								 * armImages[GREEN] = ImageIO.read(classLoader
								 * .getResourceAsStream(armsLoc + "GREEN"));
								 * legImages[GREEN] = ImageIO.read(classLoader
								 * .getResourceAsStream(legsLoc + "GREEN")); }
								 * if (blue) { headImages[BLUE] =
								 * ImageIO.read(classLoader
								 * .getResourceAsStream(headLoc + "BLUE"));
								 * armImages[BLUE] = ImageIO.read(classLoader
								 * .getResourceAsStream(armsLoc + "BLUE"));
								 * legImages[BLUE] = ImageIO.read(classLoader
								 * .getResourceAsStream(legsLoc + "BLUE")); } if
								 * (red) { headImages[RED] =
								 * ImageIO.read(classLoader
								 * .getResourceAsStream(headLoc + "RED"));
								 * armImages[RED] = ImageIO.read(classLoader
								 * .getResourceAsStream(armsLoc + "RED"));
								 * legImages[RED] = ImageIO.read(classLoader
								 * .getResourceAsStream(legsLoc + "RED")); } }
								 * catch (IOException ioe) {
								 * ioe.printStackTrace(); }
								 */

	}
}
