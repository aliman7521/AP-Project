package ProjectGame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{
	protected float x , y ;
	protected Rectangle bounds;
	
	public Entity(float x , float y) 
	{
		this.x = x;
		this.y = y;

	}
		
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	//getter and setter
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public Rectangle getBounds() 
	{
		return bounds;
	}
	
	
}
