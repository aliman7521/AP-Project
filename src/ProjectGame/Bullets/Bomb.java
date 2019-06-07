package ProjectGame.Bullets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import ProjectGame.graphics.Animation;
import ProjectGame.graphics.Assets;

public class Bomb extends Bullet
{

	private Animation anim;
	private BufferedImage image;
	public boolean explode;
	private int time = 0;
	public Bomb(float x, float y) 
	{
		super(x, y);
		image = Assets.bomb2;
		anim = new Animation(400, Assets.bomb);
		explode = false;
		bounds = new Rectangle((int)x ,(int)y ,60 , 60);
		setvelocity();
		
	}

	private void setvelocity() 
	{
		Random r = new Random();
		setVx((800-x)/100);	
		setVy((400-y)/100);
	}

	@Override
	public void update() 
	{
		x+=vx;
		y+=vy;
		anim.update();
		time++;
		if(time>100)
			explode = true;
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(getImage(),(int)x,(int)y,60,60,null);
	}
	
	public BufferedImage getImage()
	{
		if(time>70)
		{
			return image;
		}
		else
		{
			return anim.getCurrentFrame();
		}
	}
	
}
