package dev.floresgaming.game.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Animation;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.tiles.Tile;

/*
 * part of moving water.
 */

public class WaterLeftEdge extends StaticEntity{
	private Animation water;
	
	public WaterLeftEdge(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 3);
		
		water = new Animation(DEFAULT_WATER_ANIMATION_SPEED, Assets.water_leftEdge);
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.statics.StaticEntity#tick()
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
