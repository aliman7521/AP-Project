package ProjectGame.Bullets;

import java.awt.Color;
import java.awt.Graphics;

import ProjectGame.state.GameState;

public class PlayerBullet extends Bullet {

	
	
	public PlayerBullet(float x, float y) 
	{
		super(x, y);
		vx = 0;
		vy = -5;
		
	}

	@Override
	public void update() 
	{
		
		
		x += vx;
		y += vy;
		
	}


	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 5,5);
		
	}

}
