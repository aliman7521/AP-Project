package ProjectGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	public boolean [] keys;
	public boolean up , down , right , left ;
	public static boolean space;
	
	public KeyManager() 
	{
		keys = new boolean[256];
		
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_A];
		space =keys[KeyEvent.VK_SPACE];
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{

		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		keys[e.getKeyCode()] = true;
//		System.out.println(e.getKeyChar() + " Pressed!");
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
		
	}
	

}
