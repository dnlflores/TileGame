package dev.floresgaming.game.items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.gfx.Animation;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.states.State;
import dev.floresgaming.game.tiles.Tile;

/*
 * this is the Door object. this object is able to animate. when the player is in front of the door the door will open and
 * that animation will only play once while the player is still within the openBounds set. the door will close if the
 *  player walks away from the openBounds area. the animation is glitchy and inconsistent. i was trying to implement a 
 * way to switch levels once the player has walked passed the door but i haven't been successful in doing so. instead
 * i made it so that if the player stands in the openBounds area for longer that 1 second then the level will switch.
 */

public class DoorItem extends Item {
	private Animation doorOpen, doorClose, lastAnim;
	private boolean open = false, close = false;
	private long lastTime, timer;
	
	/*
	 * takes the handler and an initial x and y position.
	 * the doorOpen animation at index 1 is set in the constructor and the title "Door" is set with an ID of 4 and a 
	 * default width and height of the tile.
	 * the setPosition(x, y) method is called to set the item in the correct x and y coordinate.
	 * also the walkingBounds are set again in this method
	 */
	public DoorItem(Handler handler, float x, float y) {
		super(Assets.doorOpen[1], "Door", 4, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		setPosition((int) x, (int) y);

		doorOpen = new Animation(450, Assets.doorOpen);
		doorClose = new Animation(450, Assets.doorClose);
		lastAnim = doorClose;

		walkingBounds.x = 0 * handler.getGame().SCALE;
		walkingBounds.y = 0 * handler.getGame().SCALE;
		walkingBounds.width = 16 * handler.getGame().SCALE;
		walkingBounds.height = 16 * handler.getGame().SCALE;
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.items.Item#tick()
	 * this is where the variables open and close are set depending on whether the player is in the openBounds or not.
	 * i have created a timer in this method in order to tell when a second has gone by and to switch the level at that
	 * point but it does not work very well and it is just a temporary fix until I figure out how to implement the level
	 * change the way i wanted. 
	 */
	public void tick() {
		if (handler.getWorld().getPlayer().getCollisionBounds(0f, 0f).intersects(openBounds)) {
			open = true;
			close = false;
			Timer t = new Timer();
			t.schedule(new TimerTask() {

				@Override
				public void run() {
					handler.getGame().LEVEL = 2;
					State.setState(handler.getGame().menuState);
					handler.getWorld().switchWorld("res/worlds/world2.txt", handler.getGame().LEVEL);
				}
			}, 1500);
		} else if (!handler.getWorld().getPlayer().getCollisionBounds(0f, 0f).intersects(openBounds) && open) {
			open = false;
			close = true;
		}
		if (open && !close) {
			doorClose.playOnce(false);
			doorOpen.playOnce(true);
		} else if (!open && close) {
			doorOpen.playOnce(false);
			doorClose.playOnce(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see dev.floresgaming.game.items.Item#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		g.drawImage(getDoorAnimation(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	/*
	 * much like the getWalkingAnimation() method in the player class, this does
	 * the same by returning the correct animation frame depending on the
	 * current situation. by default returns the last animation played's current
	 * frame.
	 */
	private BufferedImage getDoorAnimation() {
		if (open && !close) {
			lastAnim = doorOpen;
			return doorOpen.getCurrentFrame();
		} else if (!open && !close) {
			lastAnim = doorOpen;
			return doorOpen.getStillFrame(0);
		} else if (close && !open) {
			lastAnim = doorClose;
			return doorClose.getCurrentFrame();
		} else if (close && open) {
			lastAnim = doorClose;
			return doorClose.getStillFrame(3);
		}
		return lastAnim.getCurrentFrame();
	}
}
