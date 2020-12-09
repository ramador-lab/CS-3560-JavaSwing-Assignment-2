package hw_two_font_end;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import hw_two_back_end.*;
import TwitterVisitors.*;

public class UserPanel extends JFrame implements ActionListener,TreeSelectionListener{
	
		private JButton follow_user;
		private JButton post_tweet;

		
		private UserGroup root_group;
		
		private ImageIcon tree_icon;
		private ImageIcon leaf_icon;
		
		private JTextArea user_id;
		private JTextArea group_id;
		private JTree tree;
		private TreeSelectionListener event;
	
	
		UserPanel (User selected_user, UserGroup group){			
		
		
		Border backline = BorderFactory.createLineBorder(Color.black);
		LayoutManager layout = new FlowLayout();	
			
			
			
		JLabel user_id_label = new JLabel(" USER ID: " + selected_user.id());
		user_id_label.setFont(new Font("Verdana", Font.PLAIN, 14));
		user_id_label.setBorder(backline);
		user_id_label.setBounds(70, 20, 200, 50);
	
		
		
		user_id = new JTextArea();
		user_id.setBounds(25, 40, 200, 50);
				
		JLabel group_id_label = new JLabel ("GROUP ID");
		group_id_label.setBounds(25, 100, 150, 20);
		
		
		
		group_id = new JTextArea();
		group_id.setBounds(25, 120, 200, 50);
			
		
		root_group = new UserGroup ("ROOT");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(root_group);
	
		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(event);
		JScrollPane treeView = new JScrollPane(tree);
		
		tree_icon = createImageIcon("Tree-icon.png");
		
	    if (tree_icon != null) {
	        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	        renderer.setLeafIcon(tree_icon);
	        tree.setCellRenderer(renderer);
	    } else {
	        System.err.println("Leaf icon missing; using default.");
	    }
		

		follow_user = new JButton ();
		follow_user.setBounds(720, 20, 200, 50);
		follow_user.addActionListener(this);
		follow_user.setText("FOLLOW");
		follow_user.setHorizontalTextPosition(JButton.CENTER);
		follow_user.setFocusable(false);

		post_tweet = new JButton();
		post_tweet.setBounds (375, 100, 200, 50);
		post_tweet.addActionListener(this);
		post_tweet.setText("POST");
		post_tweet.setHorizontalTextPosition(JButton.CENTER);
		post_tweet.setFocusable(false);
			
		
		JPanel top_panel = new JPanel ();
		top_panel.setBounds(10, 10, 990, 300);
		top_panel.setLayout(null);
		top_panel.setBorder(backline);
		
		
		
		JPanel bottom_panel = new JPanel ();
		bottom_panel.setBounds(10, 300, 990, 300);
		bottom_panel.setLayout(null);
		bottom_panel.setBorder(backline);
		
		

		this.setTitle("USER PANEL"); //Title of Main UI
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(1030,650); //sets x-dimension and y-dimension of frame
		this.setVisible(true);
	
		
		

		this.add(top_panel);
		this.add(bottom_panel);
		
		
		
		//TOP PANEL
		top_panel.add(follow_user);
		top_panel.add(user_id_label);
		
		
		//BOTTOM PANEL
		bottom_panel.add(post_tweet);
	
		
		
		
		
		ImageIcon image = new ImageIcon("calpolynighttwo.jpg"); //Image Icon
		this.setIconImage(image.getImage());
		
	}
	
	
	
	
	private void clearUserField() {
	user_id.setText(null);
	
	}
	
	
	
	protected static ImageIcon createImageIcon(String path) {
	java.net.URL imgURL = AdminControlPanel.class.getResource(path);
	if (imgURL != null) {
	    return new ImageIcon(imgURL);
	} else {
	    System.err.println("Couldn't find file: " + path);
	    return null;
	}
	}
	
	
	
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
