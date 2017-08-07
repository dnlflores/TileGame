package dev.floresgaming.game.gfx;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.entities.Entity;
import dev.floresgaming.game.tiles.Tile;

/*
 * this is the camera for the game. this makes sure that everything rendered is centered around the player. it also makes
 * sure that what is being is only what is visible. whatever is not visible in the game is not rendered for efficiency 
 * purposes. Not entirely sure how this class works fully.
 */

public class GameCamera {
	private Handler handler;
	private float xOffset, yOffset;

	/*
	 * initializes the handler, xOffset, and yOffset
	 */
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	/*
	 * not sure how this method works or what it really does
	 */
	public void checkBlankSpace() {
		if (xOffset < 0)
			xOffset = 0;
		else if (xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth())
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		if (yOffset < 0)
			yOffset = 0;
		else if (yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight())
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
	}

	/*
	 * centers the camera on the entity passed through and calls the checkBlankSpace() method.
	 * not entirely sure how this method works either.
	 */
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth();
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight();
		checkBlankSpace();
	}

	/*
	 * takes in floats xAmt and yAmt
	 * determines the movement of the camera.
	 * calls the checkBlankSpace() method at the end
	 */
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	//GETTERS AND SETTERS -- the set methods for the x and y Offsets call the checkBlankSpace() method at the end.
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
		checkBlankSpace();
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
		checkBlankSpace();
	}
}
