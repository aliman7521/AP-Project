package ProjectGame.state;

import java.awt.Graphics;

import ProjectGame.Game;

public abstract class State 
{
	private static State currentState = null ;
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
	
	//
	
	protected Game game;
	
	public State(Game game)
	{
		this.game = game;
		
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	public abstract void stateChanged(int status);

	public void stateChanged() {
		// TODO Auto-generated method stub
		
	}
	
}
