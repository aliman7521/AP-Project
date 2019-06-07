package ProjectGame.Bullets;

import java.awt.Graphics;
import java.awt.Rectangle;

import ProjectGame.entities.Entity;


public abstract class Bullet extends Entity
{
	
	protected int damage;
	protected float vx , vy;
	protected float vel;
	
	
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
	
	public float getVx() {
		return vx;
	}

	public void setVx(float vx) 
	{
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) 
	{
		this.vy = vy;
	}
	
	
}
