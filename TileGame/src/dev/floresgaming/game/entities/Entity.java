package dev.floresgaming.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.items.Item;

/*
 * sets up requirements for entities in the game such as the player, potential enemies, and static objects in the game
 * items are set up in a different class and package all together 
 */

public abstract class Entity {
	private boolean open = false, close = true;
	protected float x, y;
	protected int width, height;
	protected Handler handler;
	protected Rectangle bounds, extended;
	
	/*
	 * takes the handler of the game, an initial x and y position and the width and height of the enitity
	 * also creates a new rectangle for the bounds 
	 */
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	//in case it needs to perform some check or actions
	public abstract void tick();
	//needed in order to draw the entity
	public abstract void render(Graphics g);
	
	/*
	 * takes an xOffset and yOffset
	 * sorts through all entities and checks to see if that entity has come into contact with the x and y offset passed
	 * if it does the method returns true other wise it will by default return false
	 */
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEManager().getEntities()){
			if(e.equals(this)) continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * very similar to the checkEntityCollisions(xOffset, yOffset) method but instead sorts through all the items in the
	 * game and checks if the entity has come in contact with the item.
	 */
	public boolean checkItemCollisions(float xOffset, float yOffset) {
		for (Item i : handler.getWorld().getiManager().getItems()) {
			if (i.equals(this))
				continue;
			if (i.getWalkingCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * this method takes an xOffset and a yOffset and returns a rectangle around the entity
	 * used for detecting collision in a more precise area instead of just around the entire entity image
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	//GETTERS AND SETTERS
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth(){
		return width;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
}
