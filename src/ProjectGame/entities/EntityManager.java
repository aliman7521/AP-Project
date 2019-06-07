package ProjectGame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.Bullets.Bomb;
import ProjectGame.Bullets.Bullet;
import ProjectGame.Bullets.EnemyBullet;
import ProjectGame.Bullets.PlayerBullet;
import ProjectGame.Enemy.Enemy;

public class EntityManager 
{
	private Player player;
	private Game game;
	private ArrayList<Enemy> enemies;
	private ArrayList<PlayerBullet>playerBullets;
	private ArrayList<Bullet> bullets;
	private Bomb bomb;
//	private ArrayList<>
	private int time , delay = 10;
	
	public EntityManager(Game game , Player player) 
	{
		 this.game = game;
		 this.player = player;
		 enemies = new ArrayList<Enemy>();
		 playerBullets = new ArrayList<PlayerBullet>();
		 bullets = new ArrayList<Bullet>();
	}
	
	public void update()
	{
		player.update();
		
		shootManager();
		if(player.shoot)
		{
			shoot();
			player.shoot = false;
		}
		if(player.fire)
		{
			fire();
			player.fire = false;
		}
		
		if(bomb!= null)
		{
			bomb.update();
			if(bomb.explode)
			{
				enemies.clear();
				bomb = null;
			}	
		}
		
		for (int i = 0; i < playerBullets.size(); i++) 
		{
			if(playerBullets.get(i).getY()+15<0 || playerBullets.get(i).getX()+7<0) 
			{
				playerBullets.remove(i);
			}else {
			playerBullets.get(i).update();
			}
		}
		
		for (int j = 0; j < enemies.size(); j++) 
		{
			if(enemies.get(j).getHP()<0) 
			{
				enemies.remove(j);
			}else {
				enemies.get(j).update();
			}
		}
		
		if(time>=0)
		{
			time-=1;
		}
	}
	
	

	

	public void render(Graphics g)
	{
		player.render(g);
		if(bomb!=null)
			bomb.render(g);
		for (Entity entity : enemies) 
			entity.render(g);
		
		for (Bullet bullet : playerBullets) 
			bullet.render(g);

	}
	
	private void shootManager() 
	{
		// TODO Auto-generated method stub
		
	}
	private void shoot() 
	{
		if(time <0)
		{
			
			playerBullets.add(new PlayerBullet(player.getX()+13,player.getY()-10,1));
			time = delay;
			player.heat +=playerBullets.get(playerBullets.size()-1).getHeat();
		}
	}
	
	private void fire()
	{
		if(bomb!=null)
			return;
		
		bomb = new Bomb(player.getX() , player.getY());
		player.usedBomb();
	}
	
	
	//getter setter
	public void addEnemy(Enemy e)
	{
		enemies.add(e);
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Enemy> getEnemies() 
	{
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> entities) 
	{
		this.enemies = entities;
	}
}
