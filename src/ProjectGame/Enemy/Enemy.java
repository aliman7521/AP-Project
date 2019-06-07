package ProjectGame.Enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import ProjectGame.entities.Creature;
import ProjectGame.graphics.Assets;

public class Enemy extends Creature
{
	public int width , height;
	private BufferedImage image;
	private boolean shoot;
	private double chance;
	public Enemy(float x, float y , float vx , float vy , int level) 
	{
		super(x, y);
		this.vx = vx;
		this.vy = vy;
		this.level = level;
//		r =new Random();
		init();
	}
	private void init() 
	{
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
		x+=vx;
		y+=vy;
		
		if(Math.random() < chance)
			shoot = true;
		else
			shoot = false;
			
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(image,(int)x , (int)y , 50 , 60 , null);
	}
	
	public void getDamage(int damage)
	{
		HP-=damage;
	}
	
	public int getLevel()
	{
		return level;
	}
}
