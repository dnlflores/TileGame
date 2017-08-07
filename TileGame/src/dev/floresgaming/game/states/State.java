package dev.floresgaming.game.states;

import java.awt.Graphics;

import dev.floresgaming.game.Game;
import dev.floresgaming.game.Handler;

/*
 * this sets up what all other states should have. sets currentState to null
 */

public abstract class State {
	private static State currentState = null;

	/*
	 * takes a State variable sets currentState to the state variable passed
	 */
	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	protected Handler handler;

	public State(Handler handler) {
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);
}
