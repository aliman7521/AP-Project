package ProjectGame.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ProjectGame.save.Saver;

public class CreateNewUser extends JFrame implements ActionListener
{
	private JPanel pnl;
	private JTextField field;
	private JLabel invalid;
	public CreateNewUser()
	{
		setUndecorated(true);
		setSize(300, 200);
		setLocation(300, 500);
		setBackground(Color.BLACK);
		setResizable(false);
		init();
		setVisible(true);
	}
	
	private void init() {
		pnl = new JPanel();
		field = new JTextField();
		
		field.addActionListener(this);
		
		pnl.add(field);
		add(pnl);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Saver.checkSave(field.getText()))
		{
			this.dispose();
		}
		else
		{
			invalid = new JLabel("invalid Name");
			invalid.setFont(new Font("Arial", Font.BOLD, 24));
			invalid.setBackground(Color.red);
			pnl.add(invalid);
			repaint();
		}
		
	}


}

