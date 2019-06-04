package ProjectGame.graphics;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static BufferedImage userBackground , menuBackground , gameBackground;
	public static BufferedImage button , button2;
	public static BufferedImage [] player = new BufferedImage[6];
	public static BufferedImage enemyBullet , playerBullet  ;
	
	private static final int playerX = 356 ,  playergap = 121 , playerWidth = 108 , playerheight= 94; 
	private static int playerY = 4;
	public static void init() 
	{
		SpriteSheet creatures = new SpriteSheet(ImageLoader.loadImage("/images/svg_spaceships.png"));
		SpriteSheet gui = new SpriteSheet(ImageLoader.loadImage("/images/GUI/CavernCobble.png"));
		
		backgroundInit();
		playerInit(creatures);
		
		button = gui.crop(370, 2160 , 2246, 475);
		enemyBullet = null;
		playerBullet = null;
		
	}
	
	private static void backgroundInit() 
	{
		userBackground = ImageLoader.loadImage("/images/background/stars.png");
		menuBackground = null;
		gameBackground = ImageLoader.loadImage("/images/background/nebula03.png");		
	}

	private static void playerInit(SpriteSheet creatures)
	{
		for (int i = 0; i < player.length-1; i++) 
		{
			player[i] = creatures.crop(playerX, playerY , playerWidth , playerheight);
			playerY+=playergap;
		}
		player[5] = creatures.crop(playerX, 596, 108, 94);
		
	}

}
