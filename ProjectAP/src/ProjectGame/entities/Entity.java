package ProjectGame.entities;

import java.awt.Graphics;

public abstract class Entity
{
	protected float x , y ;
	
	
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

	public void setX(float x) 
	{
		this.x = x;
	}

	public float getY() 
	{
		return y;
	}

	public void setY(float y) 
	{
		this.y = y;
	}

	

	
	
}
