package dev.floresgaming.game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.floresgaming.game.Game;

/*
 * this class creates all of the tiles and sets them a specific id number
 * also creates an array of Tile
 * sets a default TILE_WIDTH and TILE_HEIGHT
 */

public class Tile {
	//STATIC
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile bushTile = new BushTile(2);
	public static Tile stoneTile = new StoneTile(3);
	//CLASS
	public static final int TILE_WIDTH = 16 * Game.SCALE, TILE_HEIGHT = 20 * Game.SCALE;
	
	protected final int ID;
	protected BufferedImage texture;
	
	/*
	 * takes a BufferedImage and and integer
	 * then stores this tile into an array of tiles
	 */
	public Tile(BufferedImage texture, int ID){
		this.texture = texture;
		this.ID = ID;
		tiles[ID] = this;
	}
	
	public int getID(){
		return ID;
	}
	
	/*
	 * used to perform a consistent action
	 */
	public void tick(){
		
	}
	
	/*
	 * renders the tile onto the screen
	 */
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	/*
	 * this method returns whether or not the tile is solid or not, meaning you can walk on it or not
	 */
	public boolean isSolid(){
		return false;
	}
}
