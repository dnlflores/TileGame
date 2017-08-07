package dev.floresgaming.game.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.floresgaming.game.Handler;

/*
 * manages all of the UIObjects
 */

public class UIManager {
	private Handler handler;
	private ArrayList<UIObject> objects;

	/*
	 * takes the handler objects is set to a new ArrayList<>
	 */
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}

	/*
	 * ticks all of the UIObjects in the objects ArrayList<>
	 */
	public void tick() {
		for (UIObject o : objects) {
			o.tick();
		}
	}

	/*
	 * renders all of the UIObjects in the objects ArrayList<>
	 */
	public void render(Graphics g) {
		for (UIObject o : objects) {
			o.render(g);
		}
	}

	/*
	 * calls the onMouseMove(e) method to every UIObject in the objects ArrayList<>
	 */
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseMove(e);
		}
	}

	/*
	 * calls the onMouseRelease(e) method to every UIObject in the objects ArrayList<>
	 */
	public void onMouseRelease(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}

	/*
	 * adds a UIObject to the objects ArrayList<>
	 */
	public void addObject(UIObject o) {
		objects.add(o);
	}

	/*
	 * removes a UIObject from the objects ArrayList<>
	 */
	public void removeObject(UIObject o) {
		objects.remove(o);
	}

	// GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}
}
