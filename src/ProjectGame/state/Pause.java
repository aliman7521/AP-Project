package ProjectGame.state;

import java.awt.Graphics;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.ui.ClickListener;
import ProjectGame.ui.UIButton;
import ProjectGame.ui.UIManager;

public class Pause extends State
{
	
	private Game game;
	private UIManager uiManager;
	private UIButton continueGame , toMainMenu;
	private final int fontSize = 20 ,width = 200 , height = 50 , gap = 70;
	private int x = 1000, y = 300; 
	
	public Pause(Game game) 
	{
		
		super(game);
		this.game = game;
		init();
		uiManager = new UIManager();
		uiManager.addObject(continueGame);
		uiManager.addObject(toMainMenu);
	}

	private void init() 
	{
		continueGame = new UIButton(x, y, width, height, Assets.button,"Continue",fontSize,new ClickListener() {
			
			@Override
			public void onClick() 
			{
				game.changeState(2);	
				
			}
		});
		
		toMainMenu = new UIButton(x, y+gap, width, height, Assets.button,"exit", fontSize,new ClickListener() {
			
			@Override
			public void onClick() 
			{
				game.changeState(1);	
				
			}
		});
	} 

	



	@Override
	public void update() 
	{
		uiManager.update();
		if(game.getKeyManager().escape)
			game.changeState(2);
	}

	@Override
	public void render(Graphics g) 
	{
		game.getGameState().render(g);
		uiManager.render(g);
	}
	
	@Override
	public void stateChanged(int status) 
	{
		if(uiManager!=null)
		{
		    game.getMouseManager().setUIManager(uiManager);
		}
		
		game.getMouseManager().allFalse();		
		game.getKeyManager().allFalse();

		
	}
//	
//	private int x = 1000, y1 = 250;
//	private int gapY = 50;
//	private int y2 = y1 + gapY;
//	private int y3 = y2 + gapY;
//	private int width = 120 , height = 30;
//	private int x1 = x-20 ;
//	private UIManager uiManager;
//	public Pause(Game game) 
//	{
//		super(game);
//		
//	}
//
//	@Override
//	public void update() 
//	{
//		if(clickedOnContinue())
//			game.changeState(2);
//		
//		if(clickedOntoMainMenu())
//			game.changeState(1);
//		
////		if(escapeTyped())
////			game.changeState(2);
//		
//		if(clickedOnExitGame()) 
//		{
//			
//		}
//	}
//
//	
//
//	private boolean escapeTyped() {
//		if(game.getKeyManager().escape)
//		{
//			return true;
//		}
//		return false;
//	}
//
//	private boolean clickedOnExitGame() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void render(Graphics g) 
//	{
//		game.getGameState().render(g);
//		g.drawString("Continue Game", x, y1);
//		g.drawRect(x1, y1-20, width, height);
//		
//		g.drawString("To Main Menu",x+15, y2);
//		g.drawRect(x1, y2-20, width, height);
//		
////		g.drawString("Exit Game", x, y3);
////		g.drawRect(x1, y3-20, width, height);
//				
//		
//	}
//	
//	private boolean clickedOnContinue() {
//		if(game.getMouseManager().getX()>x1 && game.getMouseManager().getX()<x1+width)
//		{
//			if(game.getMouseManager().getY()>y1 - 20 && game.getMouseManager().getY()<y1 + height)
//			{
//				if(game.getMouseManager().leftClick)
//					return true;
//			}
//		}
//		return false;
//	}
//	
//	private boolean clickedOntoMainMenu() {
//		if(game.getMouseManager().getX()>x1 && game.getMouseManager().getX()<x1+width)
//		{
//			if(game.getMouseManager().getY()>y2 - 20 && game.getMouseManager().getY()<y2 + height)
//			{
//				if(game.getMouseManager().leftClick)
//					return true;
//			}
//		}
//		return false;
//	}
//
//	

}
