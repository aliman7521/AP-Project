package ProjectGame.Enemy.Groups;

import java.awt.Graphics;
import java.util.Random;

import ProjectGame.Enemy.Enemy;

public class Something extends Group {

	public Something(int number, float x, float y ,int level) 
	{
		super(number, x, y);
		for(int i = 0 ; i<number;i++)
			enemies.add(new Enemy(randomPosition(), randomPosition(), 0, 0, level));
		
		for (Enemy enemy : enemies) 
		{
			enemy = randomChange(enemy);
		}
	}

	@Override
	public void update() 
	{
		for (Enemy enemy : enemies) 
		{
			enemy.update();
			if(enemy.getX()>1600 || enemy.getX()<50 || Math.random()<0.15)
				enemy = randomChange(enemy);
			
		}
	}

	@Override
	public void render(Graphics g) 
	{
		for (Enemy enemy : enemies) 
		{
			enemy.render(g);
		}
	}
	
	private float randomPosition()
	{
		Random r = new Random();
		float p = r.nextFloat();
		while(p>1000)
			p = r.nextFloat();
		
		return p;
	}

	private float randomVel()
	{
		Random r = new Random();
		float vel = r.nextFloat();
		while(vel<=0||vel>20)
		{
			vel=r.nextFloat();
		}
		return vel;
	}
	private float randomAngle()
	{
		Random r = new Random();
		return r.nextFloat();
	}
	
	private Enemy randomChange(Enemy enemy)
	{
		float vel = randomVel();
		float angle = randomAngle();
		float vx = (float) (vel*Math.cos(angle));
		float vy = (float) (vel*Math.sin(angle));
		enemy.setVx(vx);
		enemy.setVy(vy);
		return enemy;
	}
}
