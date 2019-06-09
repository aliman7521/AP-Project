package ProjectGame.Enemy.Groups;

import java.awt.Graphics;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.Enemy.Enemy;

public abstract class Group 
{
	protected int number;
	protected ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	protected float groupX , groupY ;
	public Group(int number , float x , float y ) 
	{
		this.number = number;
		groupX = x;
		groupY = y;
	}
	public ArrayList getEnemies()
	{
		return enemies;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public ArrayList<Enemy> getEnemy(ArrayList<Enemy> collection)
	{
		for (Enemy enemy : enemies) 
		{
			collection.add(enemy);
		}
		for (Enemy enemy : enemies) 
		{
			enemies.remove(enemy);
		}
		return collection;
	}
	
	
}
