package dev.floresgaming.game;
 /*
  * responsible for starting the game
  * creates a new game object and passes through the name width and height and calls the start method of the game.
  */

public class Launcher {
	public static void main(String[] args) {
		int width = 1000;
		int height = width / 12 * 9;
		Game game = new Game("Daniel's game", width, height);
		game.start();
	}
}
