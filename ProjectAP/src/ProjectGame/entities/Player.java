package ProjectGame.entities;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.state.GameState;

public class Player extends Creature {

	private Game game;
	private Timer tm = new Timer(20,null);
	private int heat;
	private int bombs;
	private boolean overHeat;
	private boolean shooting;

	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
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

		if(heat <=0)
			overHeat = false;
	}

	public void getInput()
	{
		if (game.keyInput) 
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
				GameState.shoot();
				tm.start();
				heat+=3;
				shooting = true;
				if(heat>=200)
					overHeat = true;
				
			}else if(!game.getKeyManager().space)
				shooting = false;
		}

		else 
		{
			x = game.getMouseManager().getX()-3;
			y = game.getMouseManager().getY()-20;
			if (game.getMouseManager().leftClick &&!overHeat)
			{
				GameState.shoot();
				tm.start();
				heat+=3;
				shooting = true;
				if(heat>=200)
					overHeat = true;
				
			}else if(!game.getKeyManager().space)
				shooting = false;
		
		}

//		x = (float)game.getMouseManager().getX();
//		y = (float)game.getMouseManager().getY();

		

	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(Assets.player, (int) x , (int) y , width , height , null);
//		g.setColor(Color.RED);
//		g.fillOval((int)x+2 , (int)y, 11, 33);
//		g.setColor(Color.ORANGE);
//		g.fillOval((int)x + 2, (int)y + 60, 11, 20);
//
//		g.setColor(Color.BLUE);
//		g.fillRoundRect((int)x, (int)y, shuttleWidth, shuttleLength, 30, 100);
//		g.fillOval(wingLx, wingY, wingWid, wingLen);
//		g.fillOval(wingRx, wingY, wingWid, wingLen);

		g.fillRect((int) x, (int) y, 20, 30);
		g.drawString(Integer.toString(heat), 10, 10);
		g.drawString("HP : "+ Integer.toString(HP), 1450, 10);
		if(overHeat)
			g.drawString("OVER HEAT !", 30, 10);

	}

}
