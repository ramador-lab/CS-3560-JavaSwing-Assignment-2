package hw_two_font_end;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
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
		
		private JTextArea tweet_message;
		private JTextArea user_id;
		
		JLabel user_id_label;
		
		
		private JList list;
		private JList news_feed;
		
		private UserGroup root_group ;
		private User selected_user;
	
	
		UserPanel (User selected, UserGroup group){			
		
		root_group = group;
		selected_user = selected;
		
		Border backline = BorderFactory.createLineBorder(Color.black);
		LayoutManager layout = new FlowLayout();
		
		
		//FOLLOWING LIST LABEL
		JLabel following_list = new JLabel(" FOLLOWING LIST: ");
		following_list.setFont(new Font("Verdana", Font.PLAIN, 14));
		following_list.setBounds(70, 85, 200, 50);
		
		list = new JList(); 
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list .setBounds(70, 140, 850, 150);
		list.setBorder(backline);
		list.setVisibleRowCount(-1);
		list.setVisible(true);
	
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(700, 90));
        listScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
			
			
		//USER ID
		user_id_label = new JLabel(" USER ID: ");
		user_id_label.setFont(new Font("Verdana", Font.PLAIN, 14));
		user_id_label.setBounds(70, 10, 100, 20);
		
		
		user_id = new JTextArea();
		user_id.setBounds(70, 40, 200, 50);
		user_id.setBorder(backline);
		
		
		
		//TWEET MESSAGE TEXT AREA
		JLabel tweet = new JLabel(" TWEET MESSAGE: ");
		tweet.setFont(new Font("Verdana", Font.PLAIN, 14));
		tweet.setBounds(70, 20, 200, 30);
		
		tweet_message = new JTextArea();
		tweet_message.setBorder(backline);
		tweet_message.setBounds(70, 50, 200, 50);
				

		//FOLLOW BUTTON
		follow_user = new JButton ();
		follow_user.setBounds(720, 40, 200, 50);
		follow_user.addActionListener(this);
		follow_user.setText("FOLLOW");
		follow_user.setHorizontalTextPosition(JButton.CENTER);
		follow_user.setFocusable(false);

		post_tweet = new JButton();
		post_tweet.setBounds (720, 50, 200, 50);
		post_tweet.addActionListener(this);
		post_tweet.setText("POST");
		post_tweet.setHorizontalTextPosition(JButton.CENTER);
		post_tweet.setFocusable(false);
			
		//NEWS FEED
		JLabel news_feed_label = new JLabel(" NEWS FEED: ");
		news_feed_label.setFont(new Font("Verdana", Font.PLAIN, 14));
		news_feed_label.setBounds(70, 120, 200, 30);
		
		//NEWS FEED LIST

	
		news_feed = new JList(); 
		news_feed.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		news_feed.setLayoutOrientation(JList.VERTICAL_WRAP);
		news_feed .setBounds(70, 150, 850, 145);
		news_feed.setBorder(backline);
		news_feed.setVisibleRowCount(-1);
		news_feed.setVisible(true);
	
		JScrollPane listScrollerTwo = new JScrollPane(news_feed);
		listScrollerTwo.setPreferredSize(new Dimension(700, 90));
        listScrollerTwo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        listScrollerTwo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
			
		
		//PANELS
		JPanel top_panel = new JPanel ();
		top_panel.setBounds(10, 10, 990, 300);
		top_panel.setLayout(null);
		top_panel.setBorder(backline);
		
		
		
		JPanel bottom_panel = new JPanel ();
		bottom_panel.setBounds(10, 300, 990, 300);
		bottom_panel.setLayout(null);
		bottom_panel.setBorder(backline);
		
		

		this.setTitle(selected_user.id().toUpperCase()); //Title of Main UI
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
		top_panel.add(user_id);
		top_panel.add(following_list);
		top_panel.add(list);
		
		
		//BOTTOM PANEL
		bottom_panel.add(post_tweet);
		bottom_panel.add(tweet_message);
		bottom_panel.add(tweet);
		bottom_panel.add(news_feed);
		bottom_panel.add(news_feed_label);
	
		
	}
	
	
	
	
	private void clearTweetField() {
	tweet_message.setText(null);
	}
	
	
	private void clearUserField() {
		user_id.setText(null);
		
	}
	
	
	
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == follow_user) {
			
			 String follow = user_id.getText();
			 User FollowUser = root_group.look_for_user(follow);
			 
	            if (FollowUser == null || user_id.getText().isBlank() || user_id.getText().isEmpty()){
	            	System.out.println("User not found");
					JOptionPane.showMessageDialog(null,"User not found or there is not an id entered","error", JOptionPane.ERROR_MESSAGE);
	          
	            }
	            else if (FollowUser == selected_user) {
	                
	            	System.out.println("DO NOT FOLLOW YOURSELF");
					JOptionPane.showMessageDialog(null,"DO NOT FOLLOW YOURSELF","error", JOptionPane.ERROR_MESSAGE);
	            }
	            else if (selected_user.getFollowing().contains(FollowUser)){
	            	System.out.println("DO NOT FOLLOW YOURSELF");
					JOptionPane.showMessageDialog(null,"DO NOT FOLLOW YOURSELF","error", JOptionPane.ERROR_MESSAGE);
	            }
	            else {

	            	FollowUser.attach(selected_user);
	                selected_user.setFollowing(FollowUser);
	                
	        		DefaultListModel listModel = new DefaultListModel();
	        		for (int i = 0; i < selected_user.getFollowing().size(); i++)
	        		{
	        		    listModel.addElement(selected_user.getFollowing().get(i));
	        		}
	        		list.setModel(listModel);
	        	
	            }
	         
	            clearUserField();
		}
		
		if(e.getSource() == post_tweet) {
			
			if(tweet_message.getText().isBlank() || tweet_message.getText().isEmpty()) {
            	System.out.println("TWEET MESSAGE BOX EMPTY");
				JOptionPane.showMessageDialog(null,"MESSAGE BOX EMPTY","error", JOptionPane.ERROR_MESSAGE);
			}
			
			String message = tweet_message.getText();
			selected_user.Post(message);
			
        	System.out.println("MESSAGE POSTED");
			JOptionPane.showMessageDialog(null,"TWEET MESSAGE POSTED","Post", JOptionPane.INFORMATION_MESSAGE);
			
			
			DefaultListModel listModelTwo = new DefaultListModel();
			for (int i = 0; i < selected_user.getNews_Feed().size(); i++)
			{
			    listModelTwo.addElement(selected_user.getNews_Feed().get(i));
			    
			}
			news_feed.setModel(listModelTwo);
			
		}

		
	}
	
	
}
