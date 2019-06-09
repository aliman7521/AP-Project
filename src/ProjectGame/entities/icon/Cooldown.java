package ProjectGame.entities.icon;

import java.awt.Graphics;

import ProjectGame.entities.Player;

public class Cooldown extends PowerUp {

	
	public Cooldown(float x, float y) 
	{
		super(x, y);
	}

	@Override
	public void claimed(Player player) 
	{
		player.cooldown();
	}

	@Override
	public void update() 
	{
		y+=vy;
		bounds.setLocation((int)x , (int)y);
	}

	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub

	}

}
