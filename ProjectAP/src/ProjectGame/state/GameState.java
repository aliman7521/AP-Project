package ProjectGame.state;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.Timer;

import ProjectGame.Game;
import ProjectGame.Bullets.Bullet;
import ProjectGame.Bullets.PlayerBullet;
import ProjectGame.entities.Player;

public class GameState extends State 
{

	private static Player player;
	private static LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	private static Timer tm = new Timer(2000, null);
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
			game.changeState(game.pauseState);
	}

	@Override
	public void render(Graphics g) 
	{
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

	public static void shoot() {
		bullets.add(new PlayerBullet(player.getX()+5,player.getY()));
		tm.start();
	}
	
}
