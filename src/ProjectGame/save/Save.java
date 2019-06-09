package ProjectGame.save;

public class Save 
{
	public String User;
	public int  weapon = 1 , gameLevel = 1 , weaponLevel=1 , HP=5 , maxHeat = 240, bombs = 3 ,score = 0;
	
	public boolean keyInput;
	
	
	public Save(String user) 
	{
		this.User=user;
	}

	public Save(String user, int weapon ,int gameLevel, int weaponLevel, int hP, int bombs, int maxHeat , int score, boolean keyInput) 
	{
		User = user;
		this.gameLevel = gameLevel;
		this.weaponLevel = weaponLevel;
		HP = hP;
		this.bombs = bombs;
		this.score = score;
		this.weapon = weapon;
		this.keyInput = keyInput;
		this.maxHeat = maxHeat;
	}
	
}	