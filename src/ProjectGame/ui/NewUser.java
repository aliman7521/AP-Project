package ProjectGame.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ProjectGame.Game;
import ProjectGame.graphics.Assets;
import ProjectGame.save.Save;
import ProjectGame.save.Saver;

public class NewUser extends JFrame implements ActionListener
{
	private Game game;
	private ArrayList<String> names;
	private JTextField text;
	private JLabel invalid;
	
	public NewUser(Game game , ArrayList<String> names) 
	{
		this.game = game;
		this.names = names;
		setLayout(null);
		invalid = new JLabel("invalid");
		invalid.setBounds(100 ,100,200,50 );
		
		text = new JTextField(30);
		text.addActionListener(this);
		text.setBounds(70, 50, 200, 30);
		setUndecorated(true);
		setBounds(500,300,500,400);
		setResizable(false);
		
		
		add(text);
		setVisible(true);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(Assets.userBackground,0,0,500,400,null);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		String name = text.getText();
		text.setText("");
		
		for (String string : names) {
			if(string.equals(name)) {
				add(invalid);
				 this.repaint();
				return;
			}
		}
		Save save = new Save(name);
		Saver.save(save);
		game.setSave(save);
		game.changeState(1);
		setVisible(false);
			
	}
}
