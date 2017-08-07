package dev.floresgaming.game.gfx;

import java.awt.image.BufferedImage;

/*
 * this loads in a spritesheet. the spritesheet i have been using has tiles that are 16x20 in dimension and have for the 
 * most part been imported from the game Pokemon Fire Red/Leaf Green. the spritesheet is not what i will continue to use
 * it was soley used for testing purposes to see if what i was writing was working correctly. i plan on making my own 
 * sprites and things once this code runs better.
 */

public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	/*
	 * used to crop out certain parts of the spritesheet.
	 */
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
}
