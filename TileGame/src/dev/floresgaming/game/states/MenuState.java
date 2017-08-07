package dev.floresgaming.game.states;

import java.awt.Graphics;

import dev.floresgaming.game.Handler;
import dev.floresgaming.game.display.Display;
import dev.floresgaming.game.gfx.Assets;
import dev.floresgaming.game.ui.ClickListener;
import dev.floresgaming.game.ui.UIImageButton;
import dev.floresgaming.game.ui.UIManager;

/*
 * this is the start menu of the game. at the moment the only time this state is displayed is when the esc key is pressed
 * in the game and when the player transitions into a new world.
 */

public class MenuState extends State {
	private Display display;
	private UIManager uiManager;
	private UIImageButton startButton;

	public MenuState(Handler handler, Display display) {
		super(handler);
		this.display = display;
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		startButton = new UIImageButton(360, 200, 256, 200, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		});

		
		uiManager.addObject(startButton);
	}

	public void tick() {
		uiManager.tick();
	}

	public void render(Graphics g) {
		uiManager.render(g);
		//g.drawImage(Assets.btn_start_txt[1], 363, 380, 200, 40, null);
	}

}
