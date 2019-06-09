package ProjectGame.state;

import java.awt.Graphics;


import ProjectGame.Game;
import ProjectGame.entities.EntityManager;
import ProjectGame.entities.Player;
import ProjectGame.graphics.Assets;
import ProjectGame.level.Level;

public class GameState extends State
{
	private EntityManager entityManager;
	
	
	public GameState(Game game) 
	{
		super(game);
		entityManager = new EntityManager(game,new Player(game, 500, 380));
		
	}

	@Override
	public void update() 
	{
		entityManager.update();
		
		if(game.getKeyManager().escape)
			game.changeState(3);
		
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.gameBackground, 0,0,2000,1500,null);
		entityManager.render(g);
		
	}
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	@Override
	public void stateChanged(int status) 
	{
		game.getMouseManager().setUIManager(null);
		game.getMouseManager().allFalse();	
		if(status !=3)
		{
			entityManager.getPlayer().setSave(game.getSave());
		}
	}

	
	
}
