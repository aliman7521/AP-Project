package ProjectGame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ProjectGame.ui.UIManager;


public class MouseManager implements MouseMotionListener , MouseListener
{

	public int x=0, y=0;
	
//	public boolean clicked; 
	public boolean leftClick;
	public boolean middleClick;
	public boolean rightClick;
	private UIManager uiManager;
	
	public void update()
	{
//		System.out.println(clicked);
	}
	
	public void setUIManager (UIManager uimanager)
	{
		this.uiManager = uimanager;
	}
	
	public void removeUIManager()
	{
		uiManager = null;
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
		x = e.getXOnScreen();
		y = e.getYOnScreen();
//		System.out.println("Dragged");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		x = e.getXOnScreen();
		y = e.getYOnScreen();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
//		leftClick = false;
//		RightClick = false;
//		middleClick = false;
//		clicked = false;
//		System.out.print(x);
//		System.out.print(" + ");
//		System.out.println(y);
	}
	@Override
	public void mouseClicked(MouseEvent e) { }

	
	@Override
	public void mousePressed(MouseEvent e) 
	{
//		x = e.getXOnScreen();
//		y = e.getYOnScreen();	
//		clicked = true;
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftClick = true;
		}else 
		if (e.getButton() == MouseEvent.BUTTON2)
		{
			middleClick = true;
		}else
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			rightClick = true;
		}
		
//		System.out.println("Mouse Pressed!");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		 leftClick = false;
		middleClick = false;
		rightClick = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}


	public void allFalse() {
		rightClick = false;
		leftClick = false;
		middleClick = false;// TODO Auto-generated method stub
		
	}
	
	

}
