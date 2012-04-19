
package utils;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public final class ImageUtils {

	public static Image loadImage(String location) throws IOException {
		ClassLoader classLoader =
				Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(location);
		Image image = ImageIO.read(input);
		return image;
	}

}
