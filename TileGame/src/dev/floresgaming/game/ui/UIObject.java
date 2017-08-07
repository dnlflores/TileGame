package dev.floresgaming.game.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/*
 * Holds the core components of user interface objects such as buttons, sliders, etc.
 */
public abstract class UIObject {
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;

	/*
	 * takes in an initial x and y position and the width and height
	 * creates a new rectangle object around the UIObject's dimensions 
	 */
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle((int) x, (int) y, width, height);
	}

	/*
	 * called when object needs to perform an action
	 */
	public abstract void tick();

	/*
	 * called when object needs to be drawn to the screen
	 */
	public abstract void render(Graphics g);

	/*
	 * called when the mouse has clicked on the object
	 */
	public abstract void onClick();

	/*
	 * sets the boolean hovering variable to true if the mouse is over the UIObject and if otherwise sets the variable
	 * to false.
	 */
	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;
	}

	/*
	 * if the left mouse button and the mouse is hovering over the button the onClick() method will be called.
	 */
	public void onMouseRelease(MouseEvent e) {
		if (hovering && e.getButton() == MouseEvent.BUTTON1)
			onClick();
	}

	// GETTERS AND SETTERS
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
}
