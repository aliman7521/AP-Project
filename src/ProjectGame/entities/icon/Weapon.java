package ProjectGame.entities.icon;

import java.awt.Graphics;
import java.util.Random;

import ProjectGame.entities.Player;

public class Weapon extends PowerUp {

	private int type;
	public Weapon(float x, float y) 
	{
		super(x, y);
		Random r = new Random();
		type = r.nextInt(2);
		
	}

	@Override
	public void claimed(Player player) 
	{
		player.weaponChanged(type);
	}

	@Override
	public void update() 
	{
		y +=vy;
		bounds.setLocation((int)x , (int)y);
	}

	@Override
	public void render(Graphics g) 
	{
		
	}

}
