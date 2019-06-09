package ProjectGame.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ItalicAction;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.save.Save;
import ProjectGame.save.Saver;
import ProjectGame.ui.ClickListener;
import ProjectGame.ui.NewUser;
import ProjectGame.ui.UIButton;
import ProjectGame.ui.UIManager;
import ProjectGame.ui.UIObject;

public class User extends State{

	private ArrayList<String> users;
	private UIManager uiManager;
	private UIButton createUser , deleteUser;
	private final int fontSize = 25,  gap =75 , width = 350, height = 50; 
	private NewUser newUser ;
	private int x = 600 ,y = 100 ,number ;
	private boolean deleting = false;
	public User(Game game) 
	{
		super(game);
		init();
		
	}

	private void init() 
	{
		
		users = new ArrayList<String>();
		uiManager = new UIManager();
		users = Saver.readUsers();
		number = users.size();		
		for (int i = 0 ; i<number ; i++) 
		{
			int j = i;
			uiManager.addObject(new UIButton(x, y+i*gap, width , height,Assets.button, users.get(i) ,fontSize , new ClickListener()
			{
				
				@Override
				public void onClick()
				{
					if(!deleting)
					{
						game.setSave(Saver.load(users.get(j)));
						game.changeState(1);
					}
					else
					{
						Saver.deleteSave(new Save(users.get(j)));
						deleting = false;
						init();
					}
				}
			}));
		}
		createUser = new UIButton(1000, 800, 100, 50,Assets.button,"Create User", 25, new ClickListener() {
			
			@Override
			public void onClick() 
			{
				newUser = new NewUser(game , users);
				
			}
		});
		deleteUser = new UIButton(500, 800, 100, 50,Assets.button,"Delete User", 25, new ClickListener() {
			
			@Override
			public void onClick() 
			{
				boolean deleting = true;
				
			}
		});
		uiManager.addObject(createUser);
		uiManager.addObject(deleteUser);
		game.getMouseManager().setUIManager(uiManager);
	}

	@Override
	public void update() 
	{
		uiManager.update();
		
	}

	@Override
	public void render(Graphics g) 
	{
			g.drawImage(Assets.userBackground,0,0,2000,1000,null);
			uiManager.render(g);
				
	}

	@Override
	public void stateChanged(int status) 
	{
		game.getMouseManager().setUIManager(uiManager);
		game.getMouseManager().allFalse();
		ArrayList<UIObject> objects = uiManager.getObjects();
		for (UIObject uiObject : objects)
		{
			uiObject.setHovering(false);
			newUser = null;
		}
		uiManager = null;
		init();
	}

	
}
