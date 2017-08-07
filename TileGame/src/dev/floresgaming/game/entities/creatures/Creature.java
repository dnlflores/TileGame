package dev.floresgaming.game.entities.creatures;

import dev.floresgaming.game.Game;
import dev.floresgaming.game.Handler;
import dev.floresgaming.game.entities.Entity;
import dev.floresgaming.game.tiles.Tile;

/*
 * This class is the basis for all of the entities that can move 
 * sets a default health, speed, width, and height for those entities.
 */

public abstract class Creature extends Entity {
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 16 * Game.SCALE, DEFAULT_CREATURE_HEIGHT = 20 * Game.SCALE;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	/*
	 * takes in the handler, an initial x and y position and a width and height
	 * xMove and yMove variables are initialized to 0 to begin with;
	 */
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	/*
	 * this method checks to see if the creature is colliding with an item or entity and then moves the creature
	 */
	public void move() {
		if(!checkEntityCollisions(xMove, 0f)){
			if(!checkItemCollisions(xMove, 0f)){
				moveX();
			}
		}
		if(!checkEntityCollisions(0f, yMove)){
			if(!checkItemCollisions(0f, yMove)){
				moveY();
			}
		}
	}

	/*
	 * this method allows the creature to move either left or right.
	 * not entirely sure how this method works fully
	 */
	public void moveX() {
		if (xMove > 0) {// MOVING RIGHT
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else{
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {// MOVING LEFT
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else{
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
	}

	/*
	 * same as moveX() but for moving up and down.
	 * again not entirely sure how this method works.
	 */
	public void moveY() {
		if (yMove > 0) {// MOVING DOWN
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else{
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		} else if (yMove < 0) {// MOVING UP
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else{
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
		}
	}

	/*
	 * this method returns true if the creature is in collision with a tile and returns false if otherwise.
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// GETTERS AND SETTERS
	public float getXMove() {
		return xMove;
	}

	public void setXMove(float xMove) {
		this.xMove = xMove;
	}

	public float getYMove() {
		return yMove;
	}

	public void setYmove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
