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
	
	private ArrayList<Enemy> enemies;
	private Wave[] waves;
	private int  lvl;
	
	public Level() 
	{
		enemies = new ArrayList<Enemy>();
		waves = new Wave[4];
	}
	

	public void setWaves(Wave[] waves)
	{
		this.waves = waves;
	}
	
	
	
}
