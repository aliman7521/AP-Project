package ProjectGame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseMotionListener , MouseListener
{

	public int x=0, y=0;
	public boolean clicked; 
	
	public void update()
	{
		
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
		System.out.println("Dragged");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
//		System.out.print(x);
//		System.out.print(" + ");
//		System.out.println(y);
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		x = e.getXOnScreen();
		y = e.getYOnScreen();
		clicked = true;
//		System.out.println("mouse Clicked!");
	}

	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getXOnScreen();
		y = e.getYOnScreen();	
//		System.out.println("Mouse Pressed!");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getXOnScreen();
		y = e.getYOnScreen();		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}
