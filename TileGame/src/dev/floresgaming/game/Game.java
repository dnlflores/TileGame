package dev.floresgaming.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.floresgaming.game.display.Display;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.gfx.GameCamera;
import dev.floresgaming.game.input.KeyManager;
import dev.floresgaming.game.input.MouseManager;
import dev.floresgaming.game.states.GameState;
import dev.floresgaming.game.states.MenuState;
import dev.floresgaming.game.states.SettingsState;
import dev.floresgaming.game.states.State;

/*The main class the main part of the game 
 * will hold all base code for the game
 * will start everything run everything and close everything out
 * there is a final int SCALE variable that will allow for resizing of the game in case things need to be smaller
 * or larger. However the way I have implemented the scale variable may not be the most efficient way and also gives a 
 * lot of warnings as I do not access this variable in a static way. 
 * this is also where the default level is set to 1.
*/

public class Game implements Runnable {
	public static final int SCALE = 3;
	public static int LEVEL = 1;

	private Thread thread;
	private Display display;
	private String title;
	private int width, height;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;

	// Handler
	private Handler handler;

	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// Camera
	private GameCamera gameCamera;

	// States
	public State gameState;
	public State menuState;
	public State settingsState;

	/*
	 * takes the title of the game,the width of the window and the height of the
	 * window as parameters creates a new KeyManager and MouseManager objects
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	/*
	 * this method initializes all necessary variables for the game. sets up the
	 * display and calls the assets init() method to initialize all of the games
	 * assets this is also where the state of the game is set.
	 */
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		gameState = new GameState(handler);
		menuState = new MenuState(handler, display);
		settingsState = new SettingsState(handler);
		State.setState(gameState);
	}

	// this will update everything in the game
	private void tick() {
		keyManager.tick();
		if (gameState.getState() != null)
			State.getState().tick();
	}

	// draws all of the graphics for this object
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear the screen
		g.clearRect(0, 0, width, height);
		// Draw here!
		if (gameState.getState() != null)
			State.getState().render(g);
		// End drawing..

		bs.show();
		g.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run() 
	 * i have set the fps for the game to 80
	 * because at 60 the game was not running smooth. this may be due to
	 * inefficiency in my code though.
	 */
	public void run() {
		init();

		int fps = 80;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	/*
	 * creates a new thread and starts the thread
	 */
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/*
	 * stops the thread
	 */
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// GETTERS AND SETTERS
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
