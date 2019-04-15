package ProjectGame.state;

import java.awt.Graphics;
import java.util.LinkedList;

import ProjectGame.Game;
import ProjectGame.Bullets.Bullet;
import ProjectGame.Bullets.PlayerBullet;
import ProjectGame.entities.Player;

public class GameState extends State {

	private static Player player;
	private static LinkedList<Bullet> bullets = new LinkedList<Bullet>();

	public GameState(Game game) {
		super(game);
		player = new Player(game, 10, 10);

	}

	@Override
	public void update() {
		player.update();
		for (Bullet bullet : bullets) {
			bullet.update();
		}
	}

	@Override
	public void render(Graphics g) 
	{
		player.render(g);
		for (int counter = 0; counter<bullets.size() ; counter++) 
		{
			if(bullets.get(counter).getY()<0) 
			{
				bullets.remove(counter);
			}else {
			bullets.get(counter).render(g);
			}
			
		}

	}

	public static void shoot() {
		bullets.add(new PlayerBullet((int)player.getX(),(int)player.getY()));
		
	}
	
}
