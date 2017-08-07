package dev.floresgaming.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * pretty straightforward. loads images.
 */

public class ImageLoader {
	
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
}
