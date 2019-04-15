package ProjectGame.Bullets;

import java.awt.Graphics;

import ProjectGame.entities.Entity;


public abstract class Bullet extends Entity
{
	
	protected int damage;
	protected float vx , vy , vel;
	
	
	public Bullet(float x,float y) 
	{
		super(x,y);
		
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}
