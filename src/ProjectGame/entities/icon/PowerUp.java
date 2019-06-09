package ProjectGame.entities.icon;

import java.awt.Rectangle;

import ProjectGame.entities.Entity;
import ProjectGame.entities.Player;

public abstract class PowerUp extends Entity
{
	protected float vy;
	
	public PowerUp(float x, float y) 
	{
		super(x, y);
		vy = 3;
		this.bounds =new Rectangle(50 , 50);
	}
	
	public abstract void claimed(Player player);
	
}
