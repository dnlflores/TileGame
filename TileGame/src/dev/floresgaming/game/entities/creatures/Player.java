package dev.floresgaming.game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Animation;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.states.State;

/*
 *this is the main player class. There is a default animation speed set. this is for the main player and their movement
 *and interactions
 */

public class Player extends Creature {
	private Animation walkDown, walkUp, walkLeft, walkRight, lastAnim, runDown, runUp, runLeft, runRight;
	private static final int DEFAULT_PLAYER_ANIMATION_SPEED = 190;
	private boolean isRunning = false;

	/*
	 * takes a handler and an initial x and y position. 
	 * the handler, x, and y are all passed to the super class Creature and the default creature height and width are
	 * also passed through to the super class.
	 * the bounds for the player is also re assigned here so that the box can be below the player's head so that the
	 * animations look more real. I have multiplied them by the Game's scale in order to keep the scaling in order.
	 * but again it may not be the most efficient way
	 */
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 0 * handler.getGame().SCALE;
		bounds.y = 13 * handler.getGame().SCALE;
		bounds.width = 16 * handler.getGame().SCALE;
		bounds.height = 6 * handler.getGame().SCALE;

		// ANIMATIONS
		// 		WALKING
		walkDown = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED - 40, Assets.player_down_walk);
		walkUp = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED - 40, Assets.player_up_walk);
		walkLeft = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED - 40, Assets.player_left_walk);
		walkRight = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED - 40, Assets.player_right_walk);
		// 		RUNNING
		runDown = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED / 2, Assets.player_down_run);
		runUp = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED / 2, Assets.player_up_run);
		runLeft = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED / 2, Assets.player_left_run);
		runRight = new Animation(DEFAULT_PLAYER_ANIMATION_SPEED / 2, Assets.player_right_run);

		lastAnim = walkDown;

		setSpeed(2.25f);
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.Entity#tick()
	 * this tick() method will constantly check to see if the running button is being pressed and if it is to set the 
	 * right animation ticks in order.
	 * it also calls the geInput() and move() methods at the end and finally centers the GameCamera() on the player.
	 */
	public void tick() {
		// ANIMATIONS
		if (!handler.getKeyManager().run) {
			walkDown.tick();
			walkUp.tick();
			walkLeft.tick();
			walkRight.tick();
		} else if (handler.getKeyManager().run) {
			runDown.tick();
			runUp.tick();
			runLeft.tick();
			runRight.tick();
		}
		// MOVEMENT
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	/*
	 * this method reacts to the input of the keyboard by setting the isRunning variable to true or false accordingly
	 * and sets the yMove and xMove to the correct speed.
	 * i have added a quit method to test out my main menu state but it causes bugs when going back into the game
	 */
	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up && !handler.getKeyManager().left && !handler.getKeyManager().right
				&& !handler.getKeyManager().run) {
			isRunning = false;
			yMove = -speed;
		}
		if (handler.getKeyManager().down && !handler.getKeyManager().left && !handler.getKeyManager().right
				&& !handler.getKeyManager().run) {
			isRunning = false;
			yMove = speed;
		}
		if (handler.getKeyManager().left && !handler.getKeyManager().up && !handler.getKeyManager().down
				&& !handler.getKeyManager().run) {
			isRunning = false;
			xMove = -speed;
		}
		if (handler.getKeyManager().right && !handler.getKeyManager().up && !handler.getKeyManager().down
				&& !handler.getKeyManager().run) {
			isRunning = false;
			xMove = speed;
		}
		if (handler.getKeyManager().up && !handler.getKeyManager().left && !handler.getKeyManager().right
				&& handler.getKeyManager().run) {
			isRunning = true;
			yMove = -speed * 3;
		}
		if (handler.getKeyManager().down && !handler.getKeyManager().left && !handler.getKeyManager().right
				&& handler.getKeyManager().run) {
			isRunning = true;
			yMove = speed * 3;
		}
		if (handler.getKeyManager().left && !handler.getKeyManager().up && !handler.getKeyManager().down
				&& handler.getKeyManager().run) {
			isRunning = true;
			xMove = -speed * 3;
		}
		if (handler.getKeyManager().right && !handler.getKeyManager().up && !handler.getKeyManager().down
				&& handler.getKeyManager().run) {
			isRunning = true;
			xMove = speed * 3;
		}
		if (handler.getKeyManager().quit)
			State.setState(handler.getGame().menuState);
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.entities.Entity#render(java.awt.Graphics)
	 * this method renders the player based off of the GameCamera(). Not entirely sure how this method works either.
	 */
	public void render(Graphics g) {
		g.drawImage(getWalkingAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	/*
	 * this method returns a BufferedImage. the image returned depends on if the player is moving or not and the type
	 * of movement the player is doing. it returns the last animation by default so that the player is not constantly
	 * moving when there is not movement.
	 */
	private BufferedImage getWalkingAnimationFrame() {
		if (xMove < 0 && !isRunning) {
			lastAnim = walkLeft;
			return walkLeft.getCurrentFrame();
		} else if (xMove < 0 && isRunning) {
			lastAnim = walkLeft;
			return runLeft.getCurrentFrame();
		} else if (xMove > 0 && !isRunning) {
			lastAnim = walkRight;
			return walkRight.getCurrentFrame();
		} else if (xMove > 0 && isRunning) {
			lastAnim = walkRight;
			return runRight.getCurrentFrame();
		} else if (yMove < 0 && !isRunning) {
			lastAnim = walkUp;
			return walkUp.getCurrentFrame();
		} else if (yMove < 0 && isRunning) {
			lastAnim = walkUp;
			return runUp.getCurrentFrame();
		} else if (yMove > 0 && !isRunning) {
			lastAnim = walkDown;
			return walkDown.getCurrentFrame();
		} else if (yMove > 0 && isRunning) {
			lastAnim = walkDown;
			return runDown.getCurrentFrame();
		} else
			return lastAnim.getStillFrame();
	}
}
