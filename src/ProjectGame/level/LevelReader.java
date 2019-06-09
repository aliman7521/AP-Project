package ProjectGame.level;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class LevelReader 
{
	private Gson gson;
	private File f;
	private Level currentLevel;
	private int level , wave;
	public LevelReader() 
	{
		gson = new Gson();
		f = new File("/Levels/level.data.txt");
	}
	
	public void nextLevel() 
	{
		
		try 
		{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			for(int i = 0;i<level;i++)
				br.readLine();
			String st = br.readLine();
			currentLevel = gson.fromJson(st, Level.class);
			level++;
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void newLevel(Level level)
	{
		try {
			String json = gson.toJson(level);
			ArrayList<String> levels = new ArrayList<String>();
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.readLine()!=null)
				levels.add(br.readLine());
			
			br.close();
			
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : levels) 
			{
				bw.write(string);
			}
			bw.write(json);
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
