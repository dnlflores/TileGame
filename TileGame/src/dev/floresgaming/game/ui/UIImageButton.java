package dev.floresgaming.game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * this is for the button on the main menu which starts the game.
 */

public class UIImageButton extends UIObject {
	private BufferedImage[] images;
	private ClickListener clicker;

	/*
	 * takes an initial x and y position, a width and height, an array of
	 * BufferedImages, and the ClickListener. passes the x, y, width and height
	 * to the super class
	 */
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.ui.UIObject#tick() no implementation
	 */
	public void tick() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.ui.UIObject#render(java.awt.Graphics) if the
	 * mouse is hovering over the button a certain image is showed and if it is
	 * not another image shows
	 */
	public void render(Graphics g) {
		if (hovering)
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[1], (int) x, (int) y, width, height, null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.ui.UIObject#onClick()
	 * calls the onClick() method of the clicker
	 */
	public void onClick() {
		clicker.onClick();
	}

}
