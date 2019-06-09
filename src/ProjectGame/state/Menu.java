package ProjectGame.state;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.save.Save;
import ProjectGame.save.Saver;
import ProjectGame.ui.ClickListener;
import ProjectGame.ui.UIButton;
import ProjectGame.ui.UIManager;
import ProjectGame.ui.UIObject;

public class Menu extends State
{
	private UIButton newGame,loadGame,exitGame, back;
	private UIManager uiManager;
	private final int fontSize = 30, gap = 200, width = 300 , height = 50 ;
	private int x = 700, y = 100  ;
	public Menu(Game game) 
	{
		super(game);
		uiManager = new UIManager();
		init();
		uiManager.addObject(newGame);
		uiManager.addObject(loadGame);
		uiManager.addObject(exitGame);
		uiManager.addObject(back);
		
	}

	private void init() {
		newGame = new UIButton(x, y, width, height,Assets.button, "New Game" , fontSize ,new ClickListener() 
		{
			
			@Override
			public void onClick() 
			{
				String save = game.getSave().User;
				Saver.deleteSave(game.getSave());
				Saver.save(new Save(save));
				try {
					Robot r = new Robot();
					r.mouseMove(850, 750);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				game.changeState(2);
				
			}
		});		
		loadGame = new UIButton(x, y+gap, width, height,Assets.button, "Load Game", fontSize , new ClickListener() 
		{
			
			@Override
			public void onClick() 
			{
				try {
					Robot r = new Robot();
					r.mouseMove(850, 750);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				game.changeState(2);
			}
		});	
		
		exitGame = new UIButton(x, y + 2*gap, width, height,Assets.button, "Exit Game" , fontSize, new ClickListener() 
		{
			
			@Override
			public void onClick() 
			{
				System.exit(1);
				
			}
		});		
		
		back = new UIButton(30, 800, 150, 50,Assets.button, "Back" , 20, new ClickListener() 
		{
			
			@Override
			public void onClick() 
			{
				game.changeState(0);
			}
		});		
	}

	@Override
	public void update() 
	{
		uiManager.update();
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.userBackground, 0 , 0 ,2000 , 1000,null);
		uiManager.render(g);
		newGame.render(g);
	}

	@Override
	public void stateChanged(int status) {
		game.getMouseManager().setUIManager(uiManager);
		game.getMouseManager().allFalse();
		ArrayList<UIObject> objects = uiManager.getObjects();
		for (UIObject uiObject : objects)
		{
			uiObject.setHovering(false);
		}
		
	}
	
	
}
