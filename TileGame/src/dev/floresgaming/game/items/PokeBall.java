package dev.floresgaming.game.items;

import java.awt.Color;
import java.awt.Graphics;

import dev.floresgaming.game.Game;
import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.tiles.Tile;

/*
 * This is just a test item. there is no significance to this item it is just to test different items being collected
 */

public class PokeBall extends Item{
	public PokeBall(Handler handler, float x, float y) {
		super(Assets.pokeball, "PokeBall", 1, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		setPosition((int) x, (int)y);
		
		walkingBounds.x = 3 * Game.SCALE;
		walkingBounds.y = 9 * Game.SCALE;
		walkingBounds.width = 10 * Game.SCALE;
		walkingBounds.height = 10 * Game.SCALE;
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.pokeball, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x + walkingBounds.x - handler.getGameCamera().getxOffset()),
		//		(int) (y + walkingBounds.y - handler.getGameCamera().getyOffset()), walkingBounds.width,
		//		walkingBounds.height);
	}
}
