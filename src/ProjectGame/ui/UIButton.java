package ProjectGame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject{
	
	private BufferedImage[] images;
	private ClickListener clicker;
	private String text;
	private int size;

	public UIButton(float x, float y, int width, int height , BufferedImage[] images , String text, int size ,ClickListener listener )
	{
		super(x, y, width, height);
		this.images = images; 
		clicker = listener;
		this.text = text;
		this.size = size;
	}

	public void onClick() 
	{
		clicker.onClick();
	}

	@Override
	public void update() {}

	@Override
	public void render(Graphics g) 
	{
		g.setFont(new Font("Arial" , Font.BOLD , size));
		if (hovering)
		{
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
			g.setColor(Color.GREEN);
			g.drawString(text , bounds.x+((width-text.length()*size)/2) , bounds.y+((height+size)/2));
		}
		else
		{
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
			g.setColor(Color.white);
			g.drawString(text ,bounds.x+((width-text.length()*(size-10))/2) , bounds.y+((height+30)/2));
		}
		
	}
}
