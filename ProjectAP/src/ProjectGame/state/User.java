package ProjectGame.state;

import java.awt.Graphics;
import java.io.IOException;

import ProjectGame.Game;
import ProjectGame.save.Save;
import ProjectGame.save.Saver;

public class User extends State{

	public User(Game game) 
	{
		super(game);
	}


	@Override
	public void update() 
	{
		
		
	}

	@Override
	public void render(Graphics g) 
	{
		
		
	}

	public void newUser(String st) 
	{
		Save save = new Save(st);
		try {
			Saver.save(save);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
