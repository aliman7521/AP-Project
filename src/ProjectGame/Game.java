package ProjectGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import ProjectGame.Display.Display;
import ProjectGame.graphics.Assets;

import ProjectGame.input.KeyManager;
import ProjectGame.input.MouseManager;
import ProjectGame.save.Save;
import ProjectGame.state.GameState;
import ProjectGame.state.Menu;
import ProjectGame.state.Pause;
import ProjectGame.state.Settings;
import ProjectGame.state.State;
import ProjectGame.state.User;

public class Game implements Runnable {

	private Display display;

	private BufferStrategy bs;
	private Graphics g;

	private boolean running = false;
	public Thread thread;
	
	private State userState;
	private State menuState;
	private State gameState;
	private State pauseState;
	private State settingState;
	private int status;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;

	public boolean keyInput = false;
	public int level ;
	public String user;

	private Save save;
	
	public Game() 
	{
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		// TODO Auto-generated method stub
		display = new Display();
		display.getFrame().addKeyListener(keyManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);

		Assets.init();
		
		userState = new User(this);
		menuState = new Menu(this);
		gameState = new GameState(this);
		pauseState = new Pause(this);
		settingState = new Settings(this);
		
		State.setState(userState);
	}

	private void update() 
	{
		
		keyManager.update();
		mouseManager.update();
		

		if (State.getState() != null)
			State.getState().update();


	}

	private void render() {
		
		
			bs = display.getCanvas().getBufferStrategy();
			if (bs == null) 
			{
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();

			g.clearRect(0, 0, 2000, 2000);

			//
			if (State.getState() != null)
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
		double delta = 0;

		long now;
		long lastTime = System.nanoTime();
		long timer = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Updates and Frames : " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public boolean mouseInput() 
	{
		return true;
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		// TODO Auto-generated method stub
		if (!running)
			return;

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeState(int code) 
	{
		switch (code) 
		{
		case 0:
			State.setState(userState);
			status = code;
			stateChanged();
			break;
		case 1:
			State.setState(menuState);
			status = code;
			stateChanged();
			break;
		case 2:
			State.setState(gameState);
			status = code;
			stateChanged();
			break;
		case 3:
			State.setState(pauseState);
			status = code;
			stateChanged();
			break;
		case 4:
			State.setState(settingState);
			status = code;
			stateChanged();
			break;
		}
	}
	public void stateChanged()
	{
		State.getState().render(g);
		for(int i = 0 ; i <100000000 ; i++)
		{
			boolean b = true;
			b = false;
		}
		
	}
	
	public State getGameState()
	{
		return gameState;
	}
	public void setSave(Save save)
	{
		this.save=save;
	}
	public Save getSave()
	{
		return save;
	}
}

