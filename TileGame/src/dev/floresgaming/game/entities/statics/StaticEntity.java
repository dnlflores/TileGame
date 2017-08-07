package dev.floresgaming.game.entities.statics;

import java.awt.Rectangle;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.entities.Entity;

/*
 * this class is the basis for all of the entities that don't move.
 * also sets a default water animation speed since there are so many classes and my moving water is so inefficient.
 */

public abstract class StaticEntity extends Entity{
	protected final int DEFAULT_WATER_ANIMATION_SPEED = 350;
	
	/*
	 * the constructor takes the handler, an initial x and y position as well as the width and the height, which are all
	 * passed through to the super class.
	 * a rectangle extended is created for the purpose of my DoorItem which recognizes if the entity is in front of the 
	 * object. 
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
		extended = new Rectangle((int) x, (int) y, width + 5, height + 5);
	}
	
	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.Entity#tick()
	 */
	public void tick() {
		
	}
}
