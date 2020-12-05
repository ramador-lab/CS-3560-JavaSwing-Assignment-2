package hw_two_font_end;


 import hw_two_back_end.*;
 
 import TwitterVisitors.TotalUsersVisitor;
 

import javax.swing.JFrame;

import java.util.Arrays;

import javax.swing.ImageIcon;



public class Driver {
	
	//JFrame = a GUI window to add components to
	
	
	public static void main (String [] args) {
		
		User u1 = new User("id1");
		UserGroup g1 = new UserGroup ("id2");
		
		
		AllUsers a1 = new AllUsers ();
		a1.setAllUsers(Arrays.asList(new SysEntry[] {u1, g1}));
		
		
		TwitterVisitor checkUserTotal = new TotalUsersVisitor ();
		
		a1.accept(checkUserTotal);
		
		System.out.println("Testing ....");
		
		
		
		//JFrame
		//Main UI => Admin Control Panel
		
		
		//Admin Frame
		JFrame AdminControl = new JFrame();
		AdminControl.setTitle("Admin Control Panel"); //Title of Main UI
		AdminControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminControl.setResizable(false);
		AdminControl.setSize(900,600); //sets x-dimension and y-dimension of frame
		AdminControl.setVisible(true);
		
		
		
		
		ImageIcon image = new ImageIcon("calpolynighttwo.jpg"); //Image Icon
		AdminControl.setIconImage(image.getImage());
		
		
		
	}

}
