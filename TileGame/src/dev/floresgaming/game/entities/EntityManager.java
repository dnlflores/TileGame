package dev.floresgaming.game.entities;
/*
 * This Class is used to manage all the Entities in the game such as enemies, trees, etc.
 */

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.entities.creatures.Player;

public class EntityManager {
	private Handler handler;
	private ArrayList<Entity> entities;
	//this Comparator<> is used to determine which entity should be rendered first based on the bottom of the collision bounds.
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()){
				return -1;
			}
			return 1;
		}
	};
	
	/*
	 * takes in the handler and creates a new ArrayList<> to store all of the enemies
	 */
	public EntityManager(Handler handler){
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	/*
	 * is called whenever the tick method in the game is called. 
	 * sorts through all of the entities and calls each of their tick() methods
	 */
	public void tick(){
		for(int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			e.tick();
		}
		Collections.sort(entities, renderSorter);
	}
	
	/*
	 * takes in a graphics object in order to render all of the entities.
	 * sorts through them all and calls each of the entities individual render(g) method
	 */
	public void render(Graphics g){
		for(Entity e: entities){
			e.render(g);
		}
		Collections.sort(entities, renderSorter);
	}

	/*
	 * simply takes in an entity and adds that entity into the ArrayList<>
	 */
	public void addEntity(Entity e){
		entities.add(e);
		Collections.sort(entities, renderSorter);
	}
	
	/*
	 * clears all of the entities stored in the entities ArrayList<>
	 */
	public void clearEntities() {
		entities.clear();
	}
	
	//GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
