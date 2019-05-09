package ProjectGame.save;

public class Save 
{
	public String User;
	public String weapon;
	
	public int gameLevel;
	public int weaponLevel;
	public int HP;
	public int bombs;
	public int score;
	
	public boolean keyInput;
	
	
	public Save(String user) 
	{
		this.User=user;
	}

	public Save(String user, String weapon ,int gameLevel, int weaponLevel, int hP, int bombs, int score, boolean keyInput) {
		User = user;
		this.gameLevel = gameLevel;
		this.weaponLevel = weaponLevel;
		HP = hP;
		this.bombs = bombs;
		this.score = score;
		this.weapon = weapon;
		this.keyInput = keyInput;
	}
	
}	