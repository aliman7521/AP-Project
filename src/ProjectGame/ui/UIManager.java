package ProjectGame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager 
{
	private ArrayList<UIObject> objects;
	public UIManager() 
	{
		objects = new ArrayList<>();
	}
	
	public void update()
	{
		for (UIObject uiObject : objects) 
		{
			uiObject.update();
		}
	}
	
	public void render(Graphics g)
	{
		for (UIObject uiObject : objects)
		{
			uiObject.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e)
	{
		for (UIObject uiObject : objects) 
		{
			uiObject.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e)
	{
		for (UIObject uiObject : objects) {
			uiObject.onMouseRelease(e);
		}
	}
	
	public void addObject(UIObject object)
	{
		objects.add(object);
	}
	
	public ArrayList<UIObject> getObjects()
	{
		return objects;
	}
}
