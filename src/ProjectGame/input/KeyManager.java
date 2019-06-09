package ProjectGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	public boolean [] keys;
	public boolean up , down , right , left , escape , enter;
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
		escape = keys[KeyEvent.VK_ESCAPE];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		try {
			keys[e.getKeyCode()] = true;
		} catch (Exception e1) 
		{
//			System.out.println("!!" + e.getKeyCode() + "!!");
		}
		
//		System.out.println(e.getKeyChar() + " Pressed!");
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		try {
			keys[e.getKeyCode()] = false;
		} catch (ArrayIndexOutOfBoundsException e1) {
			
		}
		
	}


	public void allFalse() {
		space = false;
		escape = false;		
	}
	

}
