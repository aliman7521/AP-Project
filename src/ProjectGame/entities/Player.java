package ProjectGame.entities;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.save.Save;
import ProjectGame.state.GameState;
import ProjectGame.state.State;

public class Player extends Creature 
{

	private Game game;
	private int maxheat = 240 , time =5;
	public int heat;
	
	public boolean shoot, fire , fading = false;
	private boolean overHeat , shooting ;
	
	private int bombs ,bulletType = 1, fadingTime = 300 ;
	private long score = 0;
	
	private Color clr = Color.orange;
	
//set the level in the constructor!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
 	public Player(Game game, float x, float y) 
	{
		super(x, y);
		level = 1;
		this.game = game;
		HP = 5 ;
		heat = 0 ;
		bombs = 3 ;
		overHeat = false;
		shooting = false;
		bounds = new Rectangle((int) x ,(int) y , 60,80);
	}
	
	@Override
	public void update() 
	{
		getInput();
		move();
		if(overHeat&& heat >0)
			heat-=1;
		else if(!shooting && heat >0)
		{
			if(time>0)
				time--;
			else 
			{
				heat--;
				time = 5;
			}
				
			
		}

		if(heat <=0 && overHeat)
		{
			overHeat = false;
			clr = Color.ORANGE;
		}
		
		if(fading)
		{
			if(fadingTime>0)
				fadingTime--;
			else
				fading = false;
		}
	}

	public void getInput()
	{
		if (game.keyInput) 
		{
			keyInput();
		}else 
		{
			mouseInput();
		}

	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.player[5],(int) x ,(int) y , 60,80, null);
//		heat gauge
		g.setColor(Color.white);
		g.drawRect(20, 800, maxheat, 30);
		g.setColor(clr);
		g.fillRect(22, 802, heat, 28);
		if(overHeat)
		{
			g.drawString("OVER HEAT !", 50, 850);
			clr = Color.RED;
		}
//		icons
		g.drawImage(Assets.bomb[0],30,775 , 20 , 20 , null );
		g.setColor(Color.WHITE);
		g.drawString(" x " + Integer.toString(bombs), 50, 790);
		
		g.drawImage(Assets.heart,80, 775 , 20 , 20,null);
		g.drawString(" x " + Integer.toString(HP), 110, 790);
//		score 
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial" , Font.BOLD , 20));
		g.drawString(Long.toString(score), 20, 40);
//		and
		
	}
	
	private void keyInput()
	{
		if (game.getKeyManager().up && y > 4.7)
			y += -vel;
		if (game.getKeyManager().down && y < 812)
			y += vel;
		if (game.getKeyManager().left && x > 4.5)
			x += -vel;
		if (game.getKeyManager().right && x < 1515)
			x += vel;
		if (game.getKeyManager().space &&!overHeat)
		{
			shooting = true;
			if(heat>=maxheat)
				overHeat = true;
			
		}else if(!game.getKeyManager().space)
			shooting = false;
	}

	private void mouseInput()
	{
		x = game.getMouseManager().getX()-20;
		y = game.getMouseManager().getY()-35;
		if (game.getMouseManager().leftClick &&!overHeat)
		{
			shoot = true;
			shooting = true;
			if(heat>=maxheat)
				overHeat = true;
			
		}
		else if(!game.getMouseManager().leftClick)
			shooting = false;
		
//here
		if(game.getMouseManager().rightClick)
		{
			if(bombs>0)
			{	
				fire = true;
			}	
		}
	}
	
	public void crash() 
	{
		if(fading)
			return;
		HP-=1;
		fading = true;
		try {
			Robot r = new Robot();
			r.mouseMove(850, 750);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void setSave(Save save)
	{
		HP = save.HP;
		bombs =save.bombs;
		bulletType = save.weapon;
		level = save.weaponLevel;
		score = save.score;
		
	}
	
	
	public void addBomb()
	{
		bombs+=1;
	}
	
	public void usedBomb()
	{
		bombs-=1;
	}
	
	
	public void levelup()
	{
		if(level<4)
			level++;
	}

	public void resetLevel()
	{
		level = 1;
	}

	public void weaponChanged(int type)
	{
		if(bulletType == type)
			levelup();
		else
		{
			bulletType = type;
			resetLevel();
		}
	}
	public void addScore(int score)
	{
		this.score+=score;
	}

	public int getWeaponType()
	{
		return bulletType;
	}
	
	public void cooldown()
	{
		maxheat+=30;
	}
}
