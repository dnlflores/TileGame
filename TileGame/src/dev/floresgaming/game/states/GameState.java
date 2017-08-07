package dev.floresgaming.game.states;

import java.awt.Graphics;

import dev.floresgaming.game.Game;
import dev.floresgaming.game.Handler;
import dev.floresgaming.game.worlds.World;

/*
 * this class is where the world is created and ticked. 
 */

public class GameState extends State {
	private World world, world2;

	/*
	 * takes in the handler and passes it through to the super class. the world
	 * is a txt file. the handler then sets the world to the world object that
	 * was just created.
	 */
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.states.State#tick()
	 */
	public void tick() {
		world.tick();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.floresgaming.game.states.State#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		world.render(g);
	}
}
