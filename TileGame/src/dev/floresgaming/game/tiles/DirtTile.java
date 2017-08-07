package dev.floresgaming.game.tiles;

import dev.floresgaming.game.gfx.Assets;

/*
 * A tile that is dirt which the player can walk on.
 */

public class DirtTile extends Tile{

	public DirtTile(int ID) {
		super(Assets.dirt, ID);
	}

}
