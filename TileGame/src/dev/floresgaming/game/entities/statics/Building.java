package dev.floresgaming.game.entities.statics;

/*
 * this a building object that i took from the game Pokemon Fire Red/Leaf Green for testing purposes. I am not an artist
 * and just wanted something that looked good for now. Planning on making my own sprites once the game functions properly
 */
import java.awt.Color;
import java.awt.Graphics;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.tiles.Tile;

public class Building extends StaticEntity{
	public Building(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 7, Tile.TILE_HEIGHT * 5);

		bounds.x = 0 * handler.getGame().SCALE;
		bounds.y = 20 * handler.getGame().SCALE;
		bounds.width = 112 * handler.getGame().SCALE;
		bounds.height = 75 * handler.getGame().SCALE;
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.statics.StaticEntity#tick()
	 */
	public void tick() {

	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.Entity#render(java.awt.Graphics)
	 * I have commented out a drawing of the boundary box of the building. it is there for testing purposes.
	 */
	public void render(Graphics g) {
		g.drawImage(Assets.building, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				//(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
}
