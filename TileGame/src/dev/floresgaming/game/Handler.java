package dev.floresgaming.game;

import dev.floresgaming.game.gfx.GameCamera;
import dev.floresgaming.game.input.KeyManager;
import dev.floresgaming.game.input.MouseManager;
import dev.floresgaming.game.worlds.World;

/*
 * This class is used to easily access the game and world in many of the classes
 * returns the game and world and some elements of each 
 */

public class Handler {
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
