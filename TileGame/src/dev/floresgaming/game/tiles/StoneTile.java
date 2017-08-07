package dev.floresgaming.game.tiles;

import dev.floresgaming.game.gfx.Assets;

/*
 * this is a tile of stone that the player cannot walk on.
 */

public class StoneTile extends Tile {

	public StoneTile(int ID) {
		super(Assets.stone_path, ID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.tiles.Tile#isSolid()
	 * returns true because the player cannot walk on it.
	 */
	@Override
	public boolean isSolid() {
		return true;
	}
}
