package dev.floresgaming.game.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.tiles.Tile;

/*
 * A tree object.
 */

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 3);

		bounds.x = 0 * handler.getGame().SCALE;
		bounds.y = 40 * handler.getGame().SCALE;
		bounds.width = 32 * handler.getGame().SCALE;
		bounds.height = 20 * handler.getGame().SCALE;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
			//	(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
}
