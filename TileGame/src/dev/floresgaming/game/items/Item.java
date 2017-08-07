package dev.floresgaming.game.items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.entities.Entity;
import dev.floresgaming.game.gfx.Assets;

/*
 * this is the main item class that will store all of the items in the game.
 * it creates a default ITEM_WIDTH and ITEM_HEIGHT as well an array to store all of the items in the game.
 * it has 3 bounds: walkingBounds, pickUpBounds, and openBounds.
 */

public class Item {
	public static Item[] items = new Item[256];
	// CLASS
	public static final int ITEM_WIDTH = 16, ITEM_HEIGHT = 20;

	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	protected Rectangle walkingBounds, pickUpBounds, openBounds;
	protected boolean pickedUp = false;

	protected int x, y, count, width, height;

	/*
	 * takes a BufferedImage to determine what to draw from the spritesheet, the
	 * name of the item which will later be used for the inventory system that i
	 * have not implemented yet. the id is another identifier of items which can
	 * group them by class such as potions, collectibles, etc. count is
	 * initialized to 0 in the beginning. the id of the item is added to the
	 * items list.
	 */
	public Item(BufferedImage texture, String name, int id, int width, int height) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.width = width;
		this.height = height;
		count = 0;

		items[id] = this;

		walkingBounds = new Rectangle(x, y, width, height);
		pickUpBounds = new Rectangle(x, y, width + 5, height + 5);
		openBounds = new Rectangle(x, y + 3, width, height);
	}

	/*
	 * this constantly checks to see if the player is in collision with the item
	 * and if the player is then the item will disappear and the item's count
	 * will go up one.
	 */
	public void tick() {
		if (handler.getWorld().getPlayer().getCollisionBounds(0f, 0f).intersects(pickUpBounds)
				&& handler.getKeyManager().pickUp) {
			pickedUp = true;
			count++;
		}
	}

	/*
	 * this method renders the graphics
	 */
	public void render(Graphics g) {
		if (handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}

	/*
	 * this method renders the graphics at a specific point.
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEM_WIDTH * handler.getGame().SCALE, ITEM_HEIGHT * handler.getGame().SCALE, null);
	}

	/*
	 * this method sets the position of the item indicated by the x and y
	 * parameters. it also sets each bounds accordingly.
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		walkingBounds.x = x;
		walkingBounds.y = y;
		pickUpBounds.x = x;
		pickUpBounds.y = y;
		openBounds.x = x;
		openBounds.y = y;
	}

	/*
	 * returns a new item at an x and y position.
	 */
	public Item createNew(int x, int y) {
		setPosition(x, y);
		return new Item(texture, name, id, width, height);
	}

	/*
	 * returns a rectangle around the item where the player cannot walk.
	 */
	public Rectangle getWalkingCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + walkingBounds.x + xOffset), (int) (y + walkingBounds.y + yOffset),
				walkingBounds.width, walkingBounds.height);
	}

	// GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
}
