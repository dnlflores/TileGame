package dev.floresgaming.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.floresgaming.game.ui.UIManager;

/*
 * this manages all of the mouse input of the game. creates a UIManager object
 */

public class MouseManager implements MouseListener, MouseMotionListener {
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager(){
		
	}
	
	/*
	 * sets the UIManager in the parameter to the global variable.
	 */
	public void setUIManager(UIManager uiManager){
		this.uiManager = uiManager;
	}
	// GETTERS
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
	// IMPLEMENTED
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

		if(uiManager != null){
			uiManager.onMouseMove(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 * if the left button is pressed the variable leftPressed is set to true.
	 * if the right button is pressed the variable rightPressed is set to true
	 * if the uiManager is not null uiManager's onMouseMove(e) is called.. not entirely sure what this does.
	 */
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;

		if(uiManager != null){
			uiManager.onMouseMove(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 * if the left button is released the variable leftPressed is set to false.
	 * if the right button is released the variable rightPressed is set to false.
	 */
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
		if(uiManager != null){
			uiManager.onMouseRelease(e);
		}
	}

}
