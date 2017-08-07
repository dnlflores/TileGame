package dev.floresgaming.game.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Animation;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.tiles.Tile;

/*
 * A water object that has an animation to make it look like it is moving. there is a lot of water pieces because I could 
 * not figure out an efficient way to have water in my game and make it move. this was the solution i came up with 
 * temporarily but I know there are more efficient way I am just not sure how to implement them.
 */

public class Water extends StaticEntity{
	private Animation water;
	
	public Water(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 3);
		
		water = new Animation(DEFAULT_WATER_ANIMATION_SPEED, Assets.water);
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.statics.StaticEntity#tick()
	 * ticks the water animation.
	 */
	public void tick() {
		water.tick();
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.Entity#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		g.drawImage(water.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
