package ProjectGame.Enemy.Groups;

import java.awt.Graphics;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.Enemy.Enemy;

public abstract class Group 
{
	protected Game game;
	protected int number;
	protected ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	protected float groupX , groupY ;
	public Group(Game game , int number , float x , float y ) 
	{
		this.game = game;
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
	public abstract boolean isDead(Enemy enemy);
}
