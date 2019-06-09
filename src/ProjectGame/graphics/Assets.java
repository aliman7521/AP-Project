package ProjectGame.graphics;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Assets 
{
	public static BufferedImage userBackground , menuBackground , gameBackground, heart , bomb2 ,coin ,button2;
	public static BufferedImage [] button   ;
	public static BufferedImage [] player = new BufferedImage[6];
	public static BufferedImage [] enemy = new BufferedImage[4];
	public static BufferedImage [] enemyBullet  , playerBullet ,bomb;
	
	private static final int playerX = 356 , xgap = 75 + 108, ygap = 121 , width = 108 , height= 94; 
	private static int playerY = 4;
	
	public static void init() 
	{
		SpriteSheet creatures = new SpriteSheet(ImageLoader.loadImage("/images/svg_spaceships.png"));
		SpriteSheet gui = new SpriteSheet(ImageLoader.loadImage("/images/GUI/SplatterGray.png"));
		SpriteSheet gui2 = new SpriteSheet(ImageLoader.loadImage("/images/GUI/IcyChill.png"));
		backgroundInit();
		entityInit(creatures);
		bulletInit();
		heart = ImageLoader.loadImage("/images/Icon/heart.png");
		coin = ImageLoader.loadImage("/images/Icon/coin-icon-3830.png");
		button = new BufferedImage[2];
		button[0] = gui.crop(370, 2160 , 2246, 475);
		button[1] = gui2.crop(370, 2160 , 2246, 475);
		button2 =  gui.crop(370, 2160 , 2246, 475);
	}
	
	private static void backgroundInit() 
	{
		userBackground = ImageLoader.loadImage("/images/background/stars.png");
		menuBackground = null;
		gameBackground = ImageLoader.loadImage("/images/background/nebula03.png");		
	}

	private static void entityInit(SpriteSheet creatures)
	{
		for (int i = 0; i < player.length-1; i++) 
		{
			player[i] = creatures.crop(playerX, playerY , width , height);
			playerY+=ygap;
		}
		player[5] = creatures.crop(playerX, 596, width, height);
		enemy[0] = creatures.crop(4*xgap, 0, width,height);
		enemy[1] = creatures.crop(xgap, ygap, width,height);
		enemy[2] = creatures.crop(0, 2*ygap, width,height);
		enemy[3] = creatures.crop(870, 3*ygap, 105,height);
		for(int i = 0 ; i < enemy.length ; i++)
		{
//		int i =2;
			AffineTransform transform = new AffineTransform();
		    transform.rotate(Math.toRadians(180), enemy[i].getWidth()/2, enemy[i].getHeight()/2);
		    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		    enemy[i] = op.filter(enemy[i], null);
		}
		
	}
	
	private static void bulletInit()
	{
		playerBullet = new BufferedImage[3];
		playerBullet[0] = ImageLoader.loadImage("/images/Bullet/bullet_blue.png");
		playerBullet[1] = ImageLoader.loadImage("/images/Bullet/bullet_red.png");
		playerBullet[2] = ImageLoader.loadImage("/images/Bullet/bullet_red.png");
		
		enemyBullet = new BufferedImage[4];
		
		bomb = new BufferedImage[2];
		bomb[0] = ImageLoader.loadImage("/images/Bomb/1.png");
		bomb[1] = ImageLoader.loadImage("/images/Bomb/2.png");
		bomb2 = ImageLoader.loadImage("/images/Bomb/space_mine.png");
	}

}
