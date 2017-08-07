package dev.floresgaming.game.tiles;

import dev.floresgaming.game.gfx.Assets;

/*
 * A tile of a bush
 */

public class BushTile extends Tile {

	public BushTile(int ID) {
		super(Assets.bush, ID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.tiles.Tile#isSolid()
	 * this tile will return true so the player will not be able to walk on these tiles
	 */
	@Override
	public boolean isSolid() {
		return true;
	}
}
