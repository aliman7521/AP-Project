package ProjectGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.state.GameState;
import ProjectGame.state.State;

public class Player extends Creature {

	private Game game;
	private final int maxheat = 250;
	public int heat;
	private int bombs;
	private boolean overHeat;
	private boolean shooting;
	

	public Player(Game game, float x, float y) 
	{
		super(x, y);
		this.game = game;
		level = 0;
		HP = 100;
		heat = 0;
		bombs = 3;
		overHeat = false;
		shooting = false;
	}
	
	@Override
	public void update() 
	{
		getInput();
		move();
		if((!shooting ||overHeat)&& heat >0)
			heat-=1;

		if(heat <=0 && overHeat)
			overHeat = false;
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
		g.drawImage(Assets.player[level],(int) x ,(int) y , 60,80, null);
		g.drawString(Integer.toString(heat), 10, 10);
		g.drawString("HP : "+ Integer.toString(HP), 1450, 10);
		if(overHeat)
			g.drawString("OVER HEAT !", 30, 10);

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
			EntityManager.shoot();
			heat+=3;
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
			GameState.shoot();
			shooting = true;
			if(heat>=maxheat)
				overHeat = true;
			
		}else if(!game.getMouseManager().leftClick)
			shooting = false;
	
	}
}
