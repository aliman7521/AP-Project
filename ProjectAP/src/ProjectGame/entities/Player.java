package ProjectGame.entities;

import java.awt.Graphics;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.state.GameState;

public class Player extends Creature
{

	private Game game;
	
	public Player(Game game ,float x, float y) 
	{
		super(x, y);
		this.game = game;
	}

	@Override
	public void update() 
	{
		getInput();
		move();
		
	}
	
	public void getInput()
	{
		vx = 5;
		vy = 5;
		
		if(game.getKeyManager().up)
			y += -vel ;
		if(game.getKeyManager().down)
			y += vel ;
		if(game.getKeyManager().left)
			x += -vel ;
		if(game.getKeyManager().right)
			x += vel;
		if(game.getKeyManager().space)
			GameState.shoot();
	}

	@Override
	public void render(Graphics g) 
	{
//		g.drawImage(Assets.player, (int) x , (int) y , width , height , null);
		g.drawRect((int)x ,(int) y, 10, 10);
		
	}
	
}
