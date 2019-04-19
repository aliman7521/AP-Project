package ProjectGame.save;

public class Save 
{
	public String User;
	public int gameLevel;
	public int weaponLevel;
	public int HP;
	public int bombs;
	public int score;
	public String weapon;
	
	public Save(String user) 
	{
		this.User=user;
	}

	public Save(String user, int gameLevel, int weaponLevel, int hP, int bombs, int score, String weapon) {
		User = user;
		this.gameLevel = gameLevel;
		this.weaponLevel = weaponLevel;
		HP = hP;
		this.bombs = bombs;
		this.score = score;
		this.weapon = weapon;
	}
	
}	