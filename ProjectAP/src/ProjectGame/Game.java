package ProjectGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;



import ProjectGame.Display.Display;
import ProjectGame.graphics.Assets;
import ProjectGame.input.KeyManager;
import ProjectGame.state.GameState;
import ProjectGame.state.Menu;
import ProjectGame.state.State;

public class Game implements Runnable
{

	
	private Display display;
	
	private BufferStrategy bs;
	private Graphics g ;
	
	private boolean running = false;
	public Thread thread;
	
	private State gameState;
	private State menuState;
	private KeyManager keyManager;
	
	public Game()
	{
		keyManager = new KeyManager();
	}
	
	
	private void init() 
	{
		// TODO Auto-generated method stub
		display = new Display();
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new Menu(this);
		State.setState(gameState);
	}
	
	private void update()
	{
		keyManager.update();
		
		if(State.getState() != null)
			State.getState().update();
		
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, 2000,2000);
		
		 
		//
		if(State.getState() != null)
			State.getState().render(g);
		
		//
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		
		int fps = 60;
		int ticks = 0; 
		
		double timePerUpdate = 1000000000 / fps;
		double delta = 0 ;
		
		long now;
		long lastTime = System.nanoTime();
		long timer = 0 ;
		 
		
		while (running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate ;
			timer += now -lastTime;
			lastTime = now;
			
			if (delta >= 1) 
			{
				update();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("Updates and Frames : " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}

	
	public synchronized void start()
	{
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		// TODO Auto-generated method stub
		if(!running)
			return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
