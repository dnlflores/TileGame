package dev.floresgaming.game.worlds;

import java.awt.Graphics;

import dev.floresgaming.game.Game;
import dev.floresgaming.game.Handler;
import dev.floresgaming.game.entities.EntityManager;
import dev.floresgaming.game.entities.creatures.Player;
import dev.floresgaming.game.entities.statics.Building;
import dev.floresgaming.game.entities.statics.Water;
import dev.floresgaming.game.entities.statics.WaterLeftEdge;
import dev.floresgaming.game.entities.statics.WaterLeftEdgeUp;
import dev.floresgaming.game.entities.statics.WaterRightEdge;
import dev.floresgaming.game.entities.statics.WaterRightEdgeUp;
import dev.floresgaming.game.entities.statics.WaterUp;
import dev.floresgaming.game.entities.statics.WaterUpEdge;
import dev.floresgaming.game.entities.statics.WaterUpperLeftInner;
import dev.floresgaming.game.entities.statics.WaterUpperRightInner;
import dev.floresgaming.game.items.DoorItem;
import dev.floresgaming.game.items.ItemManager;
import dev.floresgaming.game.items.MasterBall;
import dev.floresgaming.game.items.PokeBall;
import dev.floresgaming.game.states.State;
import dev.floresgaming.game.tiles.Tile;
import dev.floresgaming.game.utils.Utils;

/*
 * properties of the world. this is where all of the items and the creatures are created.
 */

public class World {
	private Handler handler;
	// size of the map in terms of TILES
	private int width, height;
	// ----------------------------------
	private int spawnX, spawnY;
	private int[][] tiles;
	// ENTITIES
	private EntityManager eManager, eManager2;
	private Player player;
	// ITEMS
	private ItemManager iManager;

	/*
	 * takes in the handler and creates a new player, itemManager, and
	 * EntityManager loads in the world from the String passed in the parameters
	 * also loads the assets of the world based on the level of the game
	 */
	public World(Handler handler, String path) {
		this.handler = handler;
		player = new Player(handler, 100, 100);
		iManager = new ItemManager(handler);
		eManager = new EntityManager(handler);

		loadWorld(path);
		loadWorldAssets(Game.LEVEL);
	}

	/*
	 * loads in all of the worlds assets according to the level passed in the
	 * parameter
	 */
	@SuppressWarnings("static-access")
	private void loadWorldAssets(int level) {
		if (level == 1) {
			eManager.addEntity(player);
			// ----------------------------------------WATER-----------------------------------------------------------
			eManager.addEntity(
					new WaterRightEdge(handler, 128 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterRightEdge(handler, 128 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterRightEdgeUp(handler, 128 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterRightEdgeUp(handler, 128 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUpEdge(handler, 112 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUpEdge(handler, 96 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUpEdge(handler, 80 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUpEdge(handler, 64 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUpEdge(handler, 48 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUpEdge(handler, 32 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 112 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 96 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 80 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 64 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 48 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 32 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 112 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 96 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 80 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 64 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 48 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 32 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 112 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 96 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 80 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 64 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 48 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(new Water(handler, 32 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 112 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 96 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 80 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 64 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 48 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterUp(handler, 32 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(new WaterLeftEdge(handler, 16 * handler.getGame().SCALE, 600 * handler.getGame().SCALE));
			eManager.addEntity(new WaterLeftEdge(handler, 16 * handler.getGame().SCALE, 680 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterLeftEdgeUp(handler, 16 * handler.getGame().SCALE, 660 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterLeftEdgeUp(handler, 16 * handler.getGame().SCALE, 740 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterUpperLeftInner(handler, 16 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));
			eManager.addEntity(
					new WaterUpperRightInner(handler, 128 * handler.getGame().SCALE, 580 * handler.getGame().SCALE));

			eManager.addEntity(
					new Building(handler, 16 * 49 * handler.getGame().SCALE, 20 * 31 * handler.getGame().SCALE));
			// ----------------------------------------ITEMS-----------------------------------------------------------
			iManager.addItem(new PokeBall(handler, 100 * handler.getGame().SCALE, 100 * handler.getGame().SCALE));
			iManager.addItem(new MasterBall(handler, 50 * handler.getGame().SCALE, 100 * handler.getGame().SCALE));
			iManager.addItem(
					new DoorItem(handler, 16 * 52 * handler.getGame().SCALE, 20 * 35 * handler.getGame().SCALE));

			player.setX(spawnX);
			player.setY(spawnY);
		} else if (level == 2) {
			eManager = new EntityManager(handler);
			eManager.addEntity(player);

			eManager.addEntity(new Building(handler, 16 * 25 * handler.getGame().SCALE, 60 * handler.getGame().SCALE));

			player.setX(spawnX);
			player.setY(spawnY);
		}
	}

	/*
	 * ticks the entityManager and the itemManager
	 */
	public void tick() {
		eManager.tick();
		iManager.tick();
	}

	/*
	 * renders only a specific part of the world. whatever the camera can see is
	 * the only parts of the world rendered.
	 */
	public void render(Graphics g) {
		int xStart = Math.max(0, (int) handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = Math.max(0, (int) handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		iManager.render(g);
		eManager.render(g);
	}

	/*
	 * this method is used to switch the worlds. it takes a new String path for
	 * the world and the level of the world. doesn't work very well and causes
	 * errors and crashes.
	 */
	public void switchWorld(String path, int level) {
		eManager.clearEntities();
		iManager.clearItems();
		loadWorld(path);
		loadWorldAssets(level);
	}

	/*
	 * returns a tile based off of the x and y position passed in the parameters
	 * if the player somehow ends up on an undesignated Tile the default tile
	 * will be set to 0
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}

	/*
	 * reads the file passed in from the parameter and parses it each of the
	 * numbers then reads each number to coordinate which tile needs to be
	 * rendered. not entirely sure how it works
	 */
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public EntityManager getEManager() {
		return eManager;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getiManager() {
		return iManager;
	}

	public void setiManager(ItemManager iManager) {
		this.iManager = iManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
