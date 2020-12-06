package hw_two_font_end;




import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TwitterVisitors.TotalUsersVisitor;
import hw_two_back_end.*;

public class AdminControlPanel extends JFrame implements ActionListener{
	
			JButton add_user;
	
	AdminControlPanel (){
		
		
		
			JLabel add_user_label = new JLabel ();
			add_user_label.setText("ADD USER");
		
			add_user = new JButton ();
			add_user.setBounds(900, 20, 70, 25);
			add_user.addActionListener(this);
			add_user.add(add_user_label);
		
		
			//JFrame
			//Main UI => Admin Control Panel
			
			
			Border backline = BorderFactory.createLineBorder(Color.black);
			LayoutManager layout = new FlowLayout();		
		
		
			//Panel holds tree hierarchy of users and groups
			JPanel treePanel = new JPanel ();
			treePanel.setBounds(0, 0, 400 , 600);
			treePanel.setLayout(layout);
			//treePanel.setBackground(Color.blue);
			treePanel.setBorder(backline);
			
			
			JPanel top_panel = new JPanel ();
			top_panel.setBounds(400, 0, 600, 300);
			top_panel.setLayout(null);
			//top_panel.setBackground(Color.blue);
			top_panel.setBorder(backline);
			
			
			
			JPanel bottom_panel = new JPanel ();
			bottom_panel.setBounds(400, 300, 600, 300);
			bottom_panel.setLayout(null);
			bottom_panel.setBorder(backline);
			
			
			//Admin Frame
			this.setTitle("Admin Control Panel"); //Title of Main UI
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setResizable(false);
			this.setSize(1000,600); //sets x-dimension and y-dimension of frame
			this.setVisible(true);
			
			
			//AddingPanels to Frame
			this.add(treePanel);
			this.add(top_panel);
			this.add(bottom_panel);
			
			
			
			//Buttons of Admin Frame
			this.add(add_user);
			
			
			
			
			
			ImageIcon image = new ImageIcon("calpolynighttwo.jpg"); //Image Icon
			this.setIconImage(image.getImage());
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		User user;

		
	}
	

}
