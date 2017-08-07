package dev.floresgaming.game.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.floresgaming.game.Handler;

/*
 * this manages all of the items in the game
 */

public class ItemManager {
	private Handler handler;
	private ArrayList<Item> items;

	/*
	 * takes the handler and initializes a new ArrayList<>
	 */
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}

	/*
	 * ticks all of the items in the list and then checks to see if the item's
	 * pickedUp variable returns true which means that the player has pressed
	 * the pickUp key and is in the area to pick up the item. In that case the
	 * item is removed from the list
	 */
	public void tick() {
		for (int i = 0; i < items.size(); i++) {
			items.get(i).tick();
			if (items.get(i).getId() > 0 && items.get(i).pickedUp) {
				items.remove(i);
				i--;
			}
		}
	}

	/*
	 * this method goes through the list and renders each item
	 */
	public void render(Graphics g) {
		for (Item i : items)
			i.render(g);
	}

	/*
	 * this method adds items to the items ArrayList<>. adding an item to the
	 * ArrayList<> the handler is assigned to that item and then the item is
	 * added.
	 */
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}

	/*
	 * clears all of the items in the items ArrayList<>.
	 */
	public void clearItems() {
		items.clear();
	}

	//GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
}
