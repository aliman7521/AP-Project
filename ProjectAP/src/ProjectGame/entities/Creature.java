package ProjectGame.entities;

import java.awt.Graphics;

public abstract class Creature extends Entity
{

	
	
	protected int HP;
	protected float vel =5;
	protected float vx , vy;
	
	public Creature(float x, float y) 
	{
		super(x, y);
		vx = 0;
		vy = 0 ;
	}
	
	public void move()
	{
		
		
	}
	
	//getter and setter
	
	public float getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	

	
	
}
