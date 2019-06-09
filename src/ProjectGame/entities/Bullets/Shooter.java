package ProjectGame.entities.Bullets;

import java.util.ArrayList;

public class Shooter 
{
	private ArrayList<PlayerBullet> bullet;
	private final int gap = 5;
	public Shooter() 
	{
		bullet = new ArrayList<PlayerBullet>();
	}
	
	public void shoot(float x , float y ,int type,int level)
	{
		int angle = 0;
		switch(level)
		{
		case 1:
			bullet.add(new PlayerBullet(x, y, type, angle));
			break;
		case 2:
			bullet.add(new PlayerBullet(x-gap, y, type, angle));
			bullet.add(new PlayerBullet(x+gap, y, type, angle));
			break;
		case 3:
			angle = 10;
			bullet.add(new PlayerBullet(x-gap, y, type, angle));
			bullet.add(new PlayerBullet(x, y, type, angle-10));
			bullet.add(new PlayerBullet(x+gap, y, type, -angle));
			break;
		case 4:
			angle = 15;
			bullet.add(new PlayerBullet(x+2*gap, y, type, angle));
			bullet.add(new PlayerBullet(x-gap, y, type, 0));
			bullet.add(new PlayerBullet(x+gap, y, type, 0));
			bullet.add(new PlayerBullet(x+2*gap, y, type, -angle));
		}
	}
	
	public ArrayList<PlayerBullet> getBullet(ArrayList<PlayerBullet> newBullets)
	{
		for (PlayerBullet playerBullet : bullet)
		{
			newBullets.add(playerBullet);
		}
		for (int i = 0 ; i<bullet.size();i++) 
		{
			bullet.remove(i);
		}
		
		return newBullets;
	}
}
