package dev.floresgaming.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * this class manages all the keyboard input for the game. creates booleans of size 256 to store the key inputs of the
 * game.
 */

public class KeyManager implements KeyListener{
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, keyDown, quit, run, pickUp;
	
	public KeyManager(){
		keys = new boolean[256];
		keyDown = false;
		
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	/*
	 * sets the movement keys accordingly and have added a method that will check to see if a key is pressed and not to
	 * continue to execute that keys commands if the key is held down. haven't implemented it yet but that is the top 
	 * portion of the code.
	 */
	public void tick(){
		for(int i = 0; i < keys.length; i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i] = false;
			}else if(justPressed[i]){
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i] = true;
			}
		}
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		quit = keys[KeyEvent.VK_ESCAPE];
		run = keys[KeyEvent.VK_SPACE];
		pickUp = keys[KeyEvent.VK_ENTER];
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 * sets true to the key that is pressed
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length)
			return;
		keys[e.getKeyCode()] = true;
		keyDown = true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 * sets false to the keys that are released
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		keyDown = false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
		
	}
	
	/*
	 * returns true if the keyCode passed was just pressed and returns false if otherwise.
	 */
	public boolean keyJustPressed(int keyCode){
		  if(keyCode < 0 || keyCode >= keys.length)
		    return false;
		  return justPressed[keyCode];
		}

	/*
	 * returns the value of the keyDown boolean.
	 */
	public boolean isKeyDown(){
		return keyDown;
	}
}
