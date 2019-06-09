package ProjectGame.Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import java.util.Random;

import ProjectGame.entities.Creature;
import ProjectGame.graphics.Assets;

public class Enemy extends Creature
{
	private final int width = 50, height = 70;
	private BufferedImage image;
	private boolean shoot , ovalMove;
	private double chance ;
	private float vo ,angle ,radius;
	public final int score;
	
	public Enemy(float x, float y , float vx , float vy , int level) 
	{
		super(x, y);
		this.vx = vx;
		this.vy = vy;
		this.level = level;
		this.score = level*15;
		ovalMove = false;
		init();
	}
	
	public Enemy(float x , float y ,float radius ,float vo ,float angle , int level)
	{
		super(x,y);
		this.angle = angle;
		this.vo = vo;
		this.level = level;
		this.score = level*15;
		ovalMove = true;
		init();
	}
	
	private void init() 
	{
		bounds= new Rectangle(width, height);
		image = Assets.enemy[level-1];
		switch(level) 
		{
		case 1:
			HP = 100;
			chance = 0.05/60;
			break;
		case 2:
			HP = 150;
			chance = 0.06/60;
			break;
		case 3:
			HP = 250;
			chance = 0.1/60;
			break;
		case 4:
			HP = 400;
			chance = 0.2/60;
			break;
		}
		
	}
	
	@Override
	public void update() 
	{
		if(ovalMove)
		{
			angle+=vo;
			if(angle>=360)
				angle%=360;
			if(angle<=-360)
			{
				angle=-angle;
				angle%=360;
				angle=-angle;
			}
				
			x=(float) ((float)radius*Math.cos(Math.toRadians(angle)));
			y=(float) ((float)radius*Math.sin(Math.toRadians(angle)));
		}
		else 
		{
			x+=vx;
			y+=vy;
		}
		bounds.setLocation((int)x,(int) y);
		if(Math.random() < chance)
			shoot = true;
		else
			shoot = false;
			
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(image,(int)x , (int)y , width , height , null);
	}
	
	public void getDamage(int damage)
	{
		HP-=damage;
	}
	
	public boolean fired()
	{
		return shoot;
	}
	public int getLevel()
	{
		return level;
	}
}
