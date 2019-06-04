package ProjectGame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import ProjectGame.Game;
import ProjectGame.Bullets.PlayerBullet;

public class EntityManager 
{
	private Game game;
	private Player player;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	private static float playerX , playerY;
	private static int playerHeat;
	private static ArrayList<PlayerBullet> bullets;
	private static int time;
	private final static int delay = 10;
	
	public EntityManager(Game game) 
	{
		this.game = game;
		player = new Player(this.game, 500, 300);
//		entities = new ArrayList<Entity>();
		bullets = new ArrayList<PlayerBullet>();
		addEntity(player);
	}
	
	public void update(){
		for(int i = 0 ; i<entities.size();i++)
		{
			entities.get(i).update();
		}
		playerX = player.getX();
		playerY = player.getY();
//		System.out.println(playerX);
		player.heat = playerHeat;
		if(time>=0)
		{
			time-=1;
		}
	}
	
	public void render(Graphics g){
		for(int i = 0 ; i<entities.size();i++)
		{
			entities.get(i).render(g);
		}
//		player.render(g);
		
//		System.out.println("isRendering!");
		
		for (int counter = 0; counter<bullets.size() ; counter++) 
		{
			if(bullets.get(counter).getY()<0 || bullets.get(counter).getX()<0) 
			{
				bullets.remove(counter);
			}else {
			bullets.get(counter).render(g);
			}
			
		}
	}
	
	public static void shoot() 
	{
		if(time <0)
		{
			bullets.add(new PlayerBullet(playerX+30,playerY));
			time = delay;
			playerHeat +=20;
		}
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	//GETTERS SETTERS

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
