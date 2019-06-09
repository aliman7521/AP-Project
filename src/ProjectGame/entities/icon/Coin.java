package ProjectGame.entities.icon;

import java.awt.Graphics;

import ProjectGame.entities.Player;

public class Coin extends PowerUp {

	private final int score = 100;
	public Coin(float x, float y) 
	{
		super(x, y);
	}

	@Override
	public void claimed(Player player) 
	{
		player.addScore(score);
	}

	@Override
	public void update() 
	{
		y+=vy;
		bounds.setLocation((int)x , (int)y);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
