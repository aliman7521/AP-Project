package ProjectGame.level;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Level 
{
	private File file = new File("C:\\Users\\Ali\\eclipse-workspace\\ProjectAP\\resource\\Levels\\level.data.txt");
	public Level() 
	{
		
		loadLevel();
		
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		
	}
	private void loadLevel()
	{
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			System.out.println(br.readLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
