package ProjectGame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import ProjectGame.Game;
import ProjectGame.Enemy.Enemy;
import ProjectGame.entities.Bullets.Bomb;
import ProjectGame.entities.Bullets.Bullet;
import ProjectGame.entities.Bullets.EnemyBullet;
import ProjectGame.entities.Bullets.PlayerBullet;
import ProjectGame.entities.Bullets.Shooter;
import ProjectGame.entities.icon.Coin;
import ProjectGame.entities.icon.Cooldown;
import ProjectGame.entities.icon.LevelUp;
import ProjectGame.entities.icon.PowerUp;
import ProjectGame.entities.icon.Weapon;

public class EntityManager 
{
	private Player player;
	private Game game;
	private ArrayList<Enemy> enemies;
	private ArrayList<PlayerBullet>playerBullets;
	private ArrayList<EnemyBullet> bullets;
	private ArrayList<PowerUp> powerUps;
	private Shooter shooter;
	private Bomb bomb;
	private int time , delay = 12 ;//, bugSaver = 10;
	
	public EntityManager(Game game , Player player) 
	{
		 this.game = game;
		 this.player = player;
		 enemies = new ArrayList<Enemy>();
		 playerBullets = new ArrayList<PlayerBullet>();
		 bullets = new ArrayList<EnemyBullet>();
		 powerUps = new ArrayList<PowerUp>();
		 shooter = new Shooter();
	}
	
	public void update()
	{
		player.update();
		
		shootManager();
		
		
		if(bomb!= null)
		{
			bomb.update();
			if(bomb.explode)
			{
				enemies.clear();
				bomb = null;
			}	
		}
//		bullet checking
		for (int i = 0; i < playerBullets.size(); i++) 
		{
			boolean isRemoved = false;
			if(playerBullets.get(i).getY()+15<0 || playerBullets.get(i).getX()+7<0) 
			{
				playerBullets.remove(i);
				isRemoved = true;
			}else {
			playerBullets.get(i).update();
			}
			
			bulletCheck(isRemoved, i);
			
		}
//		enemy checking
		for (int i = 0 ; i< enemies.size();i++) 
		{
			Enemy enemy = enemies.get(i);
			enemy.update();
			if(enemy.fired())
				bullets.add(new EnemyBullet(enemy.getX() , enemy.getY(), enemy.getLevel()));
			
			if(enemy.bounds.contains(player.bounds))
			{
				player.crash();
				enemies.remove(i);
			}
		}
		
		for(int i = 0 ; i<bullets.size();i++)
		{
			EnemyBullet bullet = bullets.get(i);
			if(player.bounds.contains(bullet.bounds))
			{
				bullets.remove(i);
				player.crash();
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

		for (PowerUp powerUp : powerUps) 
			powerUp.render(g);
		
		for (Enemy enemy : enemies) 
			enemy.render(g);
		
	}
	
	private void shootManager() 
	{
		if(player.shoot && time<0)
		{
			System.out.println("Success");
//			if(bugSaver ==60)
//			{
				System.out.println("Created");
				shooter.shoot(player.getX()+13,player.getY(),player.getWeaponType(), player.getLevel());
				playerBullets = shooter.getBullet(playerBullets);
				time = delay;
				player.shoot = false;
				game.getMouseManager().leftClick = false;
				player.heat +=playerBullets.get(playerBullets.size()-1).getHeat();
//			}else if (bugSaver >0)
//				bugSaver-=1;
//			else 
//				bugSaver = 60;
		}
		if(player.fire)
		{
			fire();
			player.fire = false;
		}
	}
	
	private void bulletCheck(boolean isRemoved ,int i)
	{
		if(isRemoved)
			return;
		for (int j = 0; j < enemies.size(); j++) 
		{
			
			if(enemyHit(i,j))
			{
				Enemy enemy = enemies.get(j);
				enemy.getDamage(playerBullets.get(i).getDamage());
				playerBullets.remove(i);
				if(enemy.getHP()<0) 
				{
					enemies.remove(j);
					if(Math.random()<0.06)
						powerUps.add(new Coin(enemy.getX(), enemy.getY()));
					if(Math.random()<0.03)
						powerUps.add(new Cooldown(enemy.getX(), enemy.getY()));
					if(Math.random()<0.03)
						powerUps.add(new LevelUp(enemy.getX(), enemy.getY()));
					if(Math.random()<0.03)
						powerUps.add(new Weapon(enemy.getX(), enemy.getY()));
				}
				
				return;
			}
		}
		for(int j =0 ; j<powerUps.size();j++)
		{
			if(playerBullets.get(i).bounds.contains(powerUps.get(j).bounds))
			{
				playerBullets.remove(i);
				powerUps.remove(j);
				return;
			}
		}
	}
	
	
	private void fire()
	{
		if(bomb!=null)
			return;
		
		bomb = new Bomb(player.getX() , player.getY());
		player.usedBomb();
	}
	//conditions
	
	private boolean enemyHit(int i , int j)
	{
		if(enemies.get(j).bounds.contains(playerBullets.get(i).bounds))
			return true;
		
		else
			return false;
		
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

	public void setEnemies(ArrayList<Enemy> enemies) 
	{
		this.enemies = enemies;
	}
}
