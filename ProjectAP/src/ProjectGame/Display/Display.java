package ProjectGame.Display;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display 
{
	private JFrame frame ;
	private Canvas canvas;
	private JPanel panel;
	
	
	public Display() 
	{
		frame = new JFrame();
		canvas = new Canvas();
		
		canvas.setFocusable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(false);
		frame.add(canvas);
		frame.setResizable(true);
//		frame.setSize(width,length);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public Canvas getCanvas() 
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
}
