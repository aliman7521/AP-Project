package ProjectGame.save;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Saver {
	private static File f = new File("C:\\Users\\Ali\\eclipse-workspace\\ProjectAP\\resource\\Save.data\\game.data.txt");

	public static void save(Save save) throws IOException
	{
		ArrayList<String> users = new ArrayList<String>();
		FileReader fr = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fr);
//		StringBuilder sb = new StringBuilder();
		String line , json = null;
		Gson gson = new Gson();
		
		while ((line = bufferedReader.readLine()) != null) 
		{
			json = line;
			Save testSave = gson.fromJson(json, Save.class);
		    if(!testSave.User.equals(save.User))
		    {
		    	users.add(json);
		    }
		}
		
		String st = new Gson().toJson(save);
		
		PrintStream ps = new PrintStream(f);
		ps.println(st);
		for(int i = 0 ; i < users.size();i++)
			ps.println(users.get(i));
		
		

	}

	public static Save load(String user) throws IOException 
	{
		Save newSave = new Save(user);
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String line , json = null;
		Gson gson = new Gson();
		
		while ((line = br.readLine()) != null) 
		{
		    json = line;
		    Save testSave = gson.fromJson(json, Save.class);
		    if(testSave.User.equals(newSave.User))
		    	break;
		}
		
		newSave = gson.fromJson(json, Save.class);
		return newSave;
	}
	
	public static void deleteSave(Save save)
	{
		try {
			ArrayList<String> users = new ArrayList<String>();
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line, json = null;
			Gson gson = new Gson();
			while ((line = br.readLine()) != null) 
			{
				json = line;
				Save testSave = gson.fromJson(json, Save.class);
				if (!testSave.User.equals(save.User))
				{
					users.add(json);
				}
					
			}
			PrintStream ps = new PrintStream(f);
			for(int i = 0 ; i < users.size();i++)
				ps.println(users.get(i));
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
