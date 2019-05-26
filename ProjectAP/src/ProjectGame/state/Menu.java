package ProjectGame.state;

import java.awt.Graphics;

import javax.swing.text.GapContent;

import ProjectGame.Game;

public class Menu extends State
{
	private int x = 715, y1 = 250;
	private int gapY = 150;
	private int y2 = y1 + gapY;
	private int y3 = y2 + gapY;
	private int x0 =30 , y0 = 770;
	private int width = 100 , height = 30;
	
	private int x1 = x-20 ;
	
	public Menu(Game game) 
	{
		super(game);
	}
	
	@Override
	public void update() 
	{
		if(clickedOnNewGame())
		{
			game.changeState(2);
		}
		if(clickedOnLoadGame())
			game.changeState(2);
		
		if(clickedOnExitGame())
			System.exit(1);
	}

	

	@Override
	public void render(Graphics g) 
	{
		g.drawString("New Game", x, y1);
		g.drawRect(x1, y1-20, width, height);
		
		g.drawString("Load Game",x, y2);
		g.drawRect(x1, y2-20, width, height);
		
		g.drawString("Exit Game", x, y3);
		g.drawRect(x1, y3-20, width, height);
		
		g.drawString("Back", x0, y0);
		g.drawRect(x0-10, y0-20, width-45, height);
		
		
	}
	
	private boolean clickedOnNewGame()
	{
		if(game.getMouseManager().getX()>x1 && game.getMouseManager().getX()<x1+width)
		{
			if(game.getMouseManager().getY()>y1 - 20 && game.getMouseManager().getY()<y1 + height)
			{
				if(game.getMouseManager().leftClick)
					return true;
			}
		}
		return false;
	}
	
	private boolean clickedOnLoadGame()
	{
		if(game.getMouseManager().getX()>x1 && game.getMouseManager().getX()<x1+width)
		{
			if(game.getMouseManager().getY()>y2 - 20 && game.getMouseManager().getY()<y2 + height)
			{
				if(game.getMouseManager().leftClick)
					return true;
			
			}
		}
		return false;
	}
	
	private boolean clickedOnExitGame() 
	{
		if(game.getMouseManager().getX()>x1 && game.getMouseManager().getX()<x1+width)
		{
			if(game.getMouseManager().getY()>y3 - 20 && game.getMouseManager().getY()<y3 + height)
			{
				if(game.getMouseManager().leftClick)
					return true;
			}
		}
		return false;
	}
	
	
}
