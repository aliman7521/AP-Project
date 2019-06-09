package ProjectGame.entities.icon;

import java.awt.Graphics;

import ProjectGame.entities.Player;

public class LevelUp extends PowerUp {

	public LevelUp(float x, float y) 
	{
		super(x, y);
		
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
		// g.drawImage(image , x , y , width , height , null);
	}

	@Override
	public void claimed(Player player) 
	{
		player.levelup();
	}
}
