package ProjectGame.state;

import java.awt.Graphics;
import java.util.ArrayList;


import ProjectGame.Game;
import ProjectGame.Bullets.Bullet;
import ProjectGame.Bullets.PlayerBullet;
import ProjectGame.entities.Creature;
import ProjectGame.entities.Entity;
import ProjectGame.entities.EntityManager;
import ProjectGame.entities.Player;
import ProjectGame.graphics.Assets;
import ProjectGame.level.Level;

public class GameState extends State
{

	private static Player player;
	private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private static int time;
	private final static int delay = 10;
	
	public GameState(Game game) 
	{
		super(game);
		player = new Player(game, 500, 380);
	}

	@Override
	public void update() 
	{
		player.update();
//		System.out.println("successfully");
		for (Bullet bullet : bullets) 
		{
			bullet.update();
		}
		if(game.getKeyManager().escape)
			game.changeState(3);
		
		if(time>=0)
		{
			time-=1;
		}
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.gameBackground, 0,0,2000,1500,null);
		player.render(g);
//		System.out.println("here");
		for (int counter = 0; counter<bullets.size() ; counter++) 
		{
			if(bullets.get(counter).getY()<0 || bullets.get(counter).getX()<0) 
			{
				bullets.remove(counter);
			}else {
			bullets.get(counter).render(g);
			}
			
		}

	}

	public static void shoot() 
	{
		if(time <0)
		{
			bullets.add(new PlayerBullet(player.getX()+20,player.getY()));
			time = delay;
			player.heat +=20;
		}
	}
	
}
