package ProjectGame.state;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import ProjectGame.Game;
import ProjectGame.Bullets.Bullet;
import ProjectGame.Bullets.PlayerBullet;
import ProjectGame.entities.Player;

public class GameState extends State implements ActionListener
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
			bullets.add(new PlayerBullet(player.getX()+5,player.getY()));
			time = delay;
			player.heat +=20;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
