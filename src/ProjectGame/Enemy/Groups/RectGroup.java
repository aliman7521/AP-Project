package ProjectGame.Enemy.Groups;

import java.awt.Graphics;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.Enemy.Enemy;

public class RectGroup extends Group {
	
	private int row , col , level;
	private float xgap,ygap ,groupVx , groupVy;
	private int minX=0,minY=0,maxX=1600,maxY=800;
	
	public RectGroup(int number, float x, float y ,float vx , float vy, int row ,int col , float xgap ,float ygap , int level) 
	{
		super(number, x, y);
		groupVx = vx;
		groupVy = vy;
		this.row = row;
		this.col = col;		
		this.xgap = xgap;
		this.ygap = ygap;
		this.level= level;
		init();
	}
	
	private void init()
	{
		
		float x = this.groupX , y = this.groupY;
		for(int i = 0 ; i<number;i++)
		{
			for(int j = 0; j<row ; j++)
			{
				enemies.add(new Enemy(x,y,groupVx,groupVy,level));
				x+=xgap;
			}
			y+=ygap;
		}
		
	}

	@Override
	public void update() 
	{
		if(groupX>maxX||groupX<minX)
		{
			for (Enemy enemy : enemies) 
			{
				enemy.setVx(-groupVx);
			}
		}
		if(groupY>maxY||groupY<minY)
		{
			for (Enemy enemy : enemies) 
			{
				enemy.setVy(-groupVy);
			}
		}
		for (Enemy enemy : enemies) 
		{
			enemy.update();
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
	
	public void setMinMax(int minX ,int minY , int maxX,int maxY)
	{
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

}
