package dev.floresgaming.game.gfx;

import java.awt.image.BufferedImage;

/*
 * this holds all of the animation work in order for all of my objects to have some sort of animation.
 * the BufferedImage array of frames stores all of the frames of animation
 * the boolean playedOnce is used to tell if the animation has played once already.
 */

public class Animation {
	private int speed, index;
	long lastTime, timer;
	private BufferedImage[] frames;
	boolean playedOnce = false;

	/*
	 * takes in the array of BufferedImages and the speed that those animations should be played at.
	 * index is used to tell which image is being selected and the timer is used to keep track of time
	 * lastTime is used to track the last time that the animation object was created.
	 */
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 1;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	/*
	 * calls the playOnce(play) method and passes through false by default to play the animation at least once.
	 */
	public void tick() {
		playOnce(false);
	}

	/*
	 * gets the cuurent frame that the animation is in.
	 */
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

	/*
	 * gets a specific frame at index 1.
	 */
	public BufferedImage getStillFrame() {
		return frames[1];
	}

	/*
	 * gets a specific frame at the index passed through.
	 */
	public BufferedImage getStillFrame(int index) {
		return frames[index];
	}

	/*
	 * plays the animation once if play is true and does the opposite if false is passed through
	 */
	public void playOnce(boolean play) {
		if (!play) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();

			if (timer > speed) {
				index++;
				timer = 0;
				if (index >= frames.length)
					index = 0;
			}
		}else if(play) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();

			if (timer > speed) {
				index++;
				timer = 0;
				playedOnce = true;
				if (index >= frames.length && !playedOnce)
					index = 0;
				else if(index >= frames.length && playedOnce)
					index = frames.length - 1;
			}
		}
	}
}
