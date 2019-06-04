package ProjectGame.level;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import ProjectGame.Enemy.Enemy;

public class Level 
{
	private File file;
	private ArrayList<Enemy> enemies;
	private int  lvl;
	
	public Level(String path) 
	{
		file = new File(path);
		enemies = new ArrayList<Enemy>();
	}
	

	public void update()
	{
		if(enemies.isEmpty()) 
		{
			loadLevel(lvl);
		}
	}
	
	public void render(Graphics g)
	{
		
	}
	
	private void loadLevel(int level)
	{
		String st = "";
		Gson gson = new Gson();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			for(int i = 1 ; i < level ; i++)
			{
				st = br.readLine();
			}
			st = br.readLine();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
