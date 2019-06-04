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

public class User extends State{

	private ArrayList<String> users = new ArrayList<String>();;
	private int number , buttonY = 100;
	private final int buttonX = 600 , gap =75 , width = 350, height = 50;
	
	
	public User(Game game) 
	{
		super(game);
		Init();
		
	}


	@Override
	public void update() 
	{
		
		
		if(clickedOnCreateUser())
			newUser();
		
		if(clickedOnUser()) 
		{
			
		}
			
		
		buttonY = 100;
	}


	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.userBackground , 0 , 0 , 2000 , 1000,null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial" , Font.BOLD , 30));
		for (int i = 0; i < users.size(); i++) 
		{
			g.drawImage(Assets.button, buttonX, buttonY, width, height, null);
			g.drawString(users.get(i) , buttonX+25,buttonY+30);
			buttonY+=gap;
		}
		
		
		
		
	}

	public void Init() 
	{
		users = Saver.readUsers();
		number = users.size();
	}
	
	private void newUser() {
		// TODO Auto-generated method stub
		
	}


	private boolean clickedOnCreateUser() {
		
		return false;
	}
	
	private boolean clickedOnUser() 
	{
		if(game.getMouseManager().leftClick && mouseOnButton(game.getMouseManager().getX() , game.getMouseManager().getY()))
		{
			int y= game.getMouseManager().getY()-100;
			System.out.println(y/125);
			game.setSave(Saver.load(users.get(y/125)));
			game.changeState(1);

			return true;
		}
		return false;
	}


	private boolean mouseOnButton(int mouseX, int mouseY) 
	{
		if(mouseX>= 600 && mouseX <=950)
			if(mouseY>=100 && mouseY <= 1075)
			return true;
		
		return false;
	}

	

	
}
