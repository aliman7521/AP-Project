package ProjectGame.Enemy.Groups;

import java.awt.Graphics;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.Enemy.Enemy;

public class LineGroup extends Group {
	
	private int gap , col;
	private float groupVx , groupVy;

	public LineGroup(Game game, int number, float x, float y ,float vx , float vy, int col , int gap) 
	{
		super(game, number, x, y);
		groupVx = vx;
		groupVy = vy;
		this.col = col;		
		this.gap = gap;
		init();
	}
	
	private void init()
	{
		int enemyCounts = number;
		float x = this.groupX , y = this.groupY;
		for (Enemy enemy : enemies) 
		{
			enemy.setX(x);
			enemy.setY(y);
			enemy.setVx(groupVx);
			enemy.setVy(groupVy);
			x+=gap;
		}
	}

	@Override
	public void update() 
	{
		for (Enemy enemy : enemies) 
		{
			enemy.update();
			if(isDead(enemy))
				enemies.remove(enemy);
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

	@Override
	public boolean isDead(Enemy enemy) 
	{
		if(enemy.getHP()<=0)
			return true;
		else
			return false;
	}
	


}
