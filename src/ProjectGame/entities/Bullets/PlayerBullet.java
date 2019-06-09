package ProjectGame.entities.Bullets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ProjectGame.graphics.Assets;
import ProjectGame.state.GameState;

public class PlayerBullet extends Bullet {

	private int type , heat , angle = 0 , width = 30 , height = 50;
	
	public PlayerBullet(float x, float y,int type , int angle) 
	{
		super(x, y);
		this.type = type;
		this.angle=angle;
		init();
		bounds = new Rectangle((int)x,(int) y, width, height);
		
	}

	private void init() 
	{
		switch(type)
		{
		case 1:
			vel = -5;
			setVx((float)(vel*Math.sin(Math.toRadians(angle))));
			setVy((float)(vel*Math.cos(Math.toRadians(angle))));
			heat = 12;
			damage = 50;
			break;
		case 2:
			setVx(0);
			setVy(-2.5f);
			heat = 6;
			damage = 75;
			break;
		case 3:
			setVx(0);
			setVy(-10);
			heat = 24;
			damage = 30;
			break;
		}
	}

	@Override
	public void update() 
	{
		
		bounds.add((int)x,(int)y);
		x += vx;
		y += getVy();
		
	}


	@Override
	public void render(Graphics g) 
	{
//		g.setColor(Color.red);
//		g.fillRect((int)x,(int) y, 7, 15);
		
		g.drawImage(Assets.playerBullet[0],(int)x, (int)y, width ,height ,null);
//		g.drawImage(Assets.enemy[3],(int) x ,(int) y , 60,80, null);
		
	}
	
	public int getHeat()
	{
		return heat;
	}
}