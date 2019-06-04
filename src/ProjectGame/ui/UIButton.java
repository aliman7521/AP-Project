package ProjectGame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject{
	
	private BufferedImage[] images;
	private ClickListener clicker;
	private String text;

	public UIButton(float x, float y, int width, int height , BufferedImage[] images , ClickListener listener , String st) {
		super(x, y, width, height);
		this.images = images; 
		listener = clicker;
		text = st;
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
		g.setFont(new Font("Arial" , Font.BOLD , 30));
		if (hovering)
		{
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
			g.setColor(Color.BLUE);
			g.drawString(text , bounds.x+((width-30)/2) , bounds.y+((height-30)/2));
		}
		else
		{
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
			g.setColor(Color.white);
			g.drawString(text , bounds.x+((width-30)/2) , bounds.y+((height-30)/2));
		}
		
	}
}
