package ProjectGame.state;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Robot;

import javax.swing.text.GapContent;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.save.Save;
import ProjectGame.ui.UIManager;

public class Menu extends State
{
	private int stringX = 715, stringY = 250;
	private int stringX2 =30 , y0 = 770;
	private final int gap = 200 , y2 = stringY + gap ,y3 = y2 + gap;
	private UIManager uimanager;
	
	private int width = 170 , height = 30;
	
	private int x1 = stringX-20 ;
	
	public Menu(Game game) 
	{
		super(game);
		game.getMouseManager();
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
		
//		if(clickedOnBack()) 
//		{
//			game.changeState(0);
//		}
	}

	

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.userBackground,0,0,null);
		
		g.setFont(new Font("Arial" , Font.BOLD , 30));
		g.setColor(Color.WHITE);
		
		g.drawString("New Game", stringX, stringY);
		
		
		g.drawString("Load Game",stringX, y2);
		
		g.drawString("Exit Game", stringX, y3);
		
		g.drawString("Back", stringX2, y0);
		
		
	}
	
	private void delete()
	{
		
	}
	
	private boolean clickedOnNewGame()
	{
		if(game.getMouseManager().getX()>x1 && game.getMouseManager().getX()<x1+width)
		{
			if(game.getMouseManager().getY()>stringY - 20 && game.getMouseManager().getY()<stringY + height)
			{
				if(game.getMouseManager().leftClick) 
				{
//					Save newGame = new Save(game.getSave().User);
//					game.setSave(newGame);
					try {
						Robot r = new Robot();
						r.mouseMove(750, 800);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return true;
				}
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
				{	
					return true;
				}
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
	
	boolean clickedOnBack()
	{
		if(game.getMouseManager().getX()>stringX2 && game.getMouseManager().getX()<stringX2+width)
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
