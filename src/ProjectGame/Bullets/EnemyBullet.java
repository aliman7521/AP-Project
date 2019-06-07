package ProjectGame.Bullets;

import java.awt.Graphics;

public class EnemyBullet extends Bullet
{
	private int level;
//	private 
	public EnemyBullet(float x, float y , int level) 
	{
		super(x, y);
		this.level = level;
	}

	@Override
	public void update() 
	{
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
