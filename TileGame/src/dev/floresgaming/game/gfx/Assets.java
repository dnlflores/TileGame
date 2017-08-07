package dev.floresgaming.game.gfx;

import java.awt.image.BufferedImage;

/*
 * This Class initializes all of the graphics of the game such as pictures, audio, etc.
 */
public class Assets {

	private static final int WIDTH = 16, HEIGHT = 20;
	public static BufferedImage dirt, bush, tree, grass, building, stone_path, pokeball, masterball, soda, ledgeLeft,
			ledgeRight, ledgeUp, ledgeDown, upRightCorner, upRightCorner_inner, upLeftCorner, upLeftCorner_inner,
			downLeftCorner, downLeftCorner_inner, downRightCorner, downRightCorner_inner;
	public static BufferedImage[] player_down_walk, player_up_walk, player_left_walk, player_right_walk,
			player_down_run, player_up_run, player_left_run, player_right_run, btn_start, water, water_up,
			water_rightEdge, water_rightEdge_up, water_rightEdge_down, water_upperRightInner, water_lowerRightInner, water_upEdge,
			water_downEdge, water_leftEdge, water_leftEdge_down, water_leftEdge_up, water_upperLeftInner,
			water_lowerLeftInner, water_down, doorOpen, doorClose;

	/*
	 * this is the method that initializes EVERYTHING GRAPHIC
	 * i have separated them from animated to non animated
	 * i have noticed that depending on the order of the animations here determines the order of render in the game.
	 * for example if building and soda where placed in the same tile then building would be rendered first because it is
	 * initialized first below.
	 * i would like to fix this so that does not happen.
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/biggerspritesheet.png"));

		// ANIMATED
		water_rightEdge = new BufferedImage[8];
		water_rightEdge[0] = sheet.crop(WIDTH * 3, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[1] = sheet.crop(WIDTH * 4, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[2] = sheet.crop(WIDTH * 5, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[3] = sheet.crop(WIDTH * 6, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[4] = sheet.crop(WIDTH * 7, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[5] = sheet.crop(WIDTH * 8, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[6] = sheet.crop(WIDTH * 9, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);
		water_rightEdge[7] = sheet.crop(WIDTH * 10, HEIGHT * 11, WIDTH * 1, HEIGHT * 3);

		water_rightEdge_up = new BufferedImage[8];
		water_rightEdge_up[0] = sheet.crop(WIDTH * 3, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[1] = sheet.crop(WIDTH * 4, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[2] = sheet.crop(WIDTH * 5, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[3] = sheet.crop(WIDTH * 6, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[4] = sheet.crop(WIDTH * 7, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[5] = sheet.crop(WIDTH * 8, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[6] = sheet.crop(WIDTH * 9, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_up[7] = sheet.crop(WIDTH * 10, HEIGHT * 10, WIDTH * 1, HEIGHT * 1);

		water_rightEdge_down = new BufferedImage[8];
		water_rightEdge_down[0] = sheet.crop(WIDTH * 3, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[1] = sheet.crop(WIDTH * 4, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[2] = sheet.crop(WIDTH * 5, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[3] = sheet.crop(WIDTH * 6, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[4] = sheet.crop(WIDTH * 7, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[5] = sheet.crop(WIDTH * 8, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[6] = sheet.crop(WIDTH * 9, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);
		water_rightEdge_down[7] = sheet.crop(WIDTH * 10, HEIGHT * 12, WIDTH * 1, HEIGHT * 1);

		water_upperRightInner = new BufferedImage[8];
		water_upperRightInner[0] = sheet.crop(WIDTH * 3, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[1] = sheet.crop(WIDTH * 4, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[2] = sheet.crop(WIDTH * 5, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[3] = sheet.crop(WIDTH * 6, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[4] = sheet.crop(WIDTH * 7, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[5] = sheet.crop(WIDTH * 8, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[6] = sheet.crop(WIDTH * 9, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperRightInner[7] = sheet.crop(WIDTH * 10, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);

		water_lowerRightInner = new BufferedImage[8];
		water_lowerRightInner[0] = sheet.crop(WIDTH * 3, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[1] = sheet.crop(WIDTH * 4, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[2] = sheet.crop(WIDTH * 5, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[3] = sheet.crop(WIDTH * 6, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[4] = sheet.crop(WIDTH * 7, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[5] = sheet.crop(WIDTH * 8, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[6] = sheet.crop(WIDTH * 9, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_lowerRightInner[7] = sheet.crop(WIDTH * 10, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);

		water_upperLeftInner = new BufferedImage[8];
		water_upperLeftInner[0] = sheet.crop(WIDTH * 12, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[1] = sheet.crop(WIDTH * 13, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[2] = sheet.crop(WIDTH * 14, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[3] = sheet.crop(WIDTH * 15, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[4] = sheet.crop(WIDTH * 16, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[5] = sheet.crop(WIDTH * 17, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[6] = sheet.crop(WIDTH * 18, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);
		water_upperLeftInner[7] = sheet.crop(WIDTH * 19, HEIGHT * 15, WIDTH * 1, HEIGHT * 1);

		water_lowerLeftInner = new BufferedImage[8];
		water_lowerLeftInner[0] = sheet.crop(WIDTH * 12, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[1] = sheet.crop(WIDTH * 13, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[2] = sheet.crop(WIDTH * 14, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[3] = sheet.crop(WIDTH * 15, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[4] = sheet.crop(WIDTH * 16, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[5] = sheet.crop(WIDTH * 17, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[6] = sheet.crop(WIDTH * 18, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_lowerLeftInner[7] = sheet.crop(WIDTH * 19, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);

		water_upEdge = new BufferedImage[8];
		water_upEdge[0] = sheet.crop(WIDTH * 3, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[1] = sheet.crop(WIDTH * 4, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[2] = sheet.crop(WIDTH * 5, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[3] = sheet.crop(WIDTH * 6, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[4] = sheet.crop(WIDTH * 7, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[5] = sheet.crop(WIDTH * 8, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[6] = sheet.crop(WIDTH * 9, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);
		water_upEdge[7] = sheet.crop(WIDTH * 10, HEIGHT * 16, WIDTH * 1, HEIGHT * 1);

		water_downEdge = new BufferedImage[8];
		water_downEdge[0] = sheet.crop(WIDTH * 3, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[1] = sheet.crop(WIDTH * 4, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[2] = sheet.crop(WIDTH * 5, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[3] = sheet.crop(WIDTH * 6, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[4] = sheet.crop(WIDTH * 7, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[5] = sheet.crop(WIDTH * 8, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[6] = sheet.crop(WIDTH * 9, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);
		water_downEdge[7] = sheet.crop(WIDTH * 10, HEIGHT * 17, WIDTH * 1, HEIGHT * 1);

		water_leftEdge = new BufferedImage[8];
		water_leftEdge[0] = sheet.crop(WIDTH * 3, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[1] = sheet.crop(WIDTH * 4, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[2] = sheet.crop(WIDTH * 5, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[3] = sheet.crop(WIDTH * 6, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[4] = sheet.crop(WIDTH * 7, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[5] = sheet.crop(WIDTH * 8, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[6] = sheet.crop(WIDTH * 9, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water_leftEdge[7] = sheet.crop(WIDTH * 10, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);

		water_leftEdge_up = new BufferedImage[8];
		water_leftEdge_up[0] = sheet.crop(WIDTH * 3, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[1] = sheet.crop(WIDTH * 4, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[2] = sheet.crop(WIDTH * 5, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[3] = sheet.crop(WIDTH * 6, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[4] = sheet.crop(WIDTH * 7, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[5] = sheet.crop(WIDTH * 8, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[6] = sheet.crop(WIDTH * 9, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_up[7] = sheet.crop(WIDTH * 10, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);

		water_leftEdge_down = new BufferedImage[8];
		water_leftEdge_down[0] = sheet.crop(WIDTH * 3, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[1] = sheet.crop(WIDTH * 4, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[2] = sheet.crop(WIDTH * 5, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[3] = sheet.crop(WIDTH * 6, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[4] = sheet.crop(WIDTH * 7, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[5] = sheet.crop(WIDTH * 8, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[6] = sheet.crop(WIDTH * 9, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_leftEdge_down[7] = sheet.crop(WIDTH * 10, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);

		water = new BufferedImage[8];
		water[0] = sheet.crop(WIDTH * 12, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[1] = sheet.crop(WIDTH * 13, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[2] = sheet.crop(WIDTH * 14, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[3] = sheet.crop(WIDTH * 15, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[4] = sheet.crop(WIDTH * 16, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[5] = sheet.crop(WIDTH * 17, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[6] = sheet.crop(WIDTH * 18, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);
		water[7] = sheet.crop(WIDTH * 19, HEIGHT * 21, WIDTH * 1, HEIGHT * 3);

		water_up = new BufferedImage[8];
		water_up[0] = sheet.crop(WIDTH * 12, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[1] = sheet.crop(WIDTH * 13, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[2] = sheet.crop(WIDTH * 14, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[3] = sheet.crop(WIDTH * 15, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[4] = sheet.crop(WIDTH * 16, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[5] = sheet.crop(WIDTH * 17, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[6] = sheet.crop(WIDTH * 18, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);
		water_up[7] = sheet.crop(WIDTH * 19, HEIGHT * 20, WIDTH * 1, HEIGHT * 1);

		water_down = new BufferedImage[8];
		water_down[0] = sheet.crop(WIDTH * 12, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[1] = sheet.crop(WIDTH * 13, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[2] = sheet.crop(WIDTH * 14, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[3] = sheet.crop(WIDTH * 15, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[4] = sheet.crop(WIDTH * 16, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[5] = sheet.crop(WIDTH * 17, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[6] = sheet.crop(WIDTH * 18, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);
		water_down[7] = sheet.crop(WIDTH * 19, HEIGHT * 23, WIDTH * 1, HEIGHT * 1);

		btn_start = new BufferedImage[2];
		btn_start[1] = sheet.crop(WIDTH * 0, HEIGHT * 4, WIDTH * 8, HEIGHT * 5);
		btn_start[0] = sheet.crop(WIDTH * 8, HEIGHT * 0, WIDTH * 8, HEIGHT * 5);
		
		doorOpen = new BufferedImage[4];
		doorOpen[0] = sheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT - 4);
		doorOpen[1] = sheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT - 4);
		doorOpen[2] = sheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT - 4);
		doorOpen[3] = sheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT - 4);
		
		doorClose = new BufferedImage[4];
		doorClose[0] = sheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT - 4);
		doorClose[1] = sheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT - 4);
		doorClose[2] = sheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT - 4);
		doorClose[3] = sheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT - 4);

		player_down_walk = new BufferedImage[4];
		player_down_walk[0] = sheet.crop(WIDTH * 0, HEIGHT * 0, WIDTH, HEIGHT);
		player_down_walk[1] = sheet.crop(WIDTH * 1, HEIGHT * 0, WIDTH, HEIGHT);
		player_down_walk[2] = sheet.crop(WIDTH * 2, HEIGHT * 0, WIDTH, HEIGHT);
		player_down_walk[3] = sheet.crop(WIDTH * 1, HEIGHT * 0, WIDTH, HEIGHT);

		player_up_walk = new BufferedImage[4];
		player_up_walk[0] = sheet.crop(WIDTH * 0, HEIGHT * 1, WIDTH, HEIGHT);
		player_up_walk[1] = sheet.crop(WIDTH * 1, HEIGHT * 1, WIDTH, HEIGHT);
		player_up_walk[2] = sheet.crop(WIDTH * 2, HEIGHT * 1, WIDTH, HEIGHT);
		player_up_walk[3] = sheet.crop(WIDTH * 1, HEIGHT * 1, WIDTH, HEIGHT);

		player_left_walk = new BufferedImage[4];
		player_left_walk[0] = sheet.crop(WIDTH * 0, HEIGHT * 2, WIDTH, HEIGHT);
		player_left_walk[1] = sheet.crop(WIDTH * 1, HEIGHT * 2, WIDTH, HEIGHT);
		player_left_walk[2] = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
		player_left_walk[3] = sheet.crop(WIDTH * 1, HEIGHT * 2, WIDTH, HEIGHT);

		player_right_walk = new BufferedImage[4];
		player_right_walk[0] = sheet.crop(WIDTH * 0, HEIGHT * 3, WIDTH, HEIGHT);
		player_right_walk[1] = sheet.crop(WIDTH * 1, HEIGHT * 3, WIDTH, HEIGHT);
		player_right_walk[2] = sheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
		player_right_walk[3] = sheet.crop(WIDTH * 1, HEIGHT * 3, WIDTH, HEIGHT);

		player_up_run = new BufferedImage[4];
		player_up_run[0] = sheet.crop(WIDTH * 0, HEIGHT * 9, WIDTH, HEIGHT);
		player_up_run[1] = sheet.crop(WIDTH * 1, HEIGHT * 9, WIDTH, HEIGHT);
		player_up_run[2] = sheet.crop(WIDTH * 2, HEIGHT * 9, WIDTH, HEIGHT);
		player_up_run[3] = sheet.crop(WIDTH * 1, HEIGHT * 9, WIDTH, HEIGHT);

		player_down_run = new BufferedImage[4];
		player_down_run[0] = sheet.crop(WIDTH * 0, HEIGHT * 10, WIDTH, HEIGHT);
		player_down_run[1] = sheet.crop(WIDTH * 1, HEIGHT * 10, WIDTH, HEIGHT);
		player_down_run[2] = sheet.crop(WIDTH * 2, HEIGHT * 10, WIDTH, HEIGHT);
		player_down_run[3] = sheet.crop(WIDTH * 1, HEIGHT * 10, WIDTH, HEIGHT);

		player_left_run = new BufferedImage[4];
		player_left_run[0] = sheet.crop(WIDTH * 0, HEIGHT * 11, WIDTH, HEIGHT);
		player_left_run[1] = sheet.crop(WIDTH * 1, HEIGHT * 11, WIDTH, HEIGHT);
		player_left_run[2] = sheet.crop(WIDTH * 2, HEIGHT * 11, WIDTH, HEIGHT);
		player_left_run[3] = sheet.crop(WIDTH * 1, HEIGHT * 11, WIDTH, HEIGHT);

		player_right_run = new BufferedImage[4];
		player_right_run[0] = sheet.crop(WIDTH * 0, HEIGHT * 12, WIDTH, HEIGHT);
		player_right_run[1] = sheet.crop(WIDTH * 1, HEIGHT * 12, WIDTH, HEIGHT);
		player_right_run[2] = sheet.crop(WIDTH * 2, HEIGHT * 12, WIDTH, HEIGHT);
		player_right_run[3] = sheet.crop(WIDTH * 1, HEIGHT * 12, WIDTH, HEIGHT);

		// NON-ANIMATED
		dirt = sheet.crop(WIDTH * 4, HEIGHT * 0, WIDTH, HEIGHT);
		stone_path = sheet.crop(WIDTH * 5, HEIGHT * 0, WIDTH, HEIGHT);
		tree = sheet.crop(WIDTH * 6, HEIGHT * 0, WIDTH * 2, HEIGHT * 3);
		grass = sheet.crop(WIDTH * 3, HEIGHT * 0, WIDTH, HEIGHT);
		building = sheet.crop(WIDTH * 8, HEIGHT * 5, WIDTH * 7, HEIGHT * 5);
		bush = sheet.crop(WIDTH * 3, HEIGHT * 1, WIDTH, HEIGHT);
		pokeball = sheet.crop(WIDTH * 4, HEIGHT * 1, WIDTH, HEIGHT);
		masterball = sheet.crop(WIDTH * 5, HEIGHT * 1, WIDTH, HEIGHT);
		soda = sheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
	}
}
