package hw_two_font_end;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import TwitterVisitors.*;


import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.ImageIcon;

import TwitterVisitors.TotalUsersVisitor;
import hw_two_back_end.*;

public class AdminControlPanel extends JFrame implements ActionListener,TreeSelectionListener{
	
			private JButton add_user;
			private JButton add_group;
			private JButton open_user_view;
			private JButton show_user_total;
			private JButton show_message_total;
			private JButton show_group_total;
			private JButton show_positive_percentage;
		
			private JPanel treePanel;
			
			private DefaultTreeModel model;
			
			private UserGroup root_group;
			private DefaultMutableTreeNode root;
			
			private ImageIcon tree_icon;
			private ImageIcon leaf_icon;
			
			private JTextArea user_id;
			private JTextArea group_id;
			private JTree tree;
			private TreeSelectionListener event;
		
	
	AdminControlPanel (){			
			
			//Top Panel Buttons and Text Area
			
			//Text Area for user id
			JLabel user_id_label = new JLabel("USER ID");
			user_id_label.setBounds(25, 20, 150, 20);
	
			
			
			user_id = new JTextArea();
			user_id.setBounds(25, 40, 200, 50);
					
			
			//Text Area for Group id 
			JLabel group_id_label = new JLabel ("GROUP ID");
			group_id_label.setBounds(25, 100, 150, 20);
			
			
			
			group_id = new JTextArea();
			group_id.setBounds(25, 120, 200, 50);
				
			
			root_group = new UserGroup ("ROOT");
			root = new DefaultMutableTreeNode(root_group);
	
			tree = new JTree(root);
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			tree.addTreeSelectionListener(event);
			JScrollPane treeView = new JScrollPane(tree);
	        treeView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        treeView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
			
			tree_icon = createImageIcon("Tree-icon.png");
			
	        if (tree_icon != null) {
	            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	            renderer.setLeafIcon(tree_icon);
	            tree.setCellRenderer(renderer);
	        } else {
	            System.err.println("Leaf icon missing; using default.");
	        }
			
	       model = (DefaultTreeModel)tree.getModel();
			
			//Add User Button
			add_user = new JButton ();
			add_user.setBounds(375, 40, 200, 50);
			add_user.addActionListener(this);
			add_user.setText("ADD USER");
			add_user.setHorizontalTextPosition(JButton.CENTER);
			add_user.setFocusable(false);

			
			
			//Add group button
			add_group = new JButton();
			add_group.setBounds (375, 100, 200, 50);
			add_group.addActionListener(this);
			add_group.setText("ADD GROUP");
			add_group.setHorizontalTextPosition(JButton.CENTER);
			add_group.setFocusable(false);
			
			//Open User View Button 
			open_user_view = new JButton();
			open_user_view.addActionListener(this);
			open_user_view.setText("OPEN USER VIEW");
			open_user_view.setHorizontalTextPosition(JButton.CENTER);
			open_user_view.setBounds(100, 220, 400, 50);
			
			
			
			//Bottom Panel Buttons
			//User Total Button			
			show_user_total = new JButton ();
			show_user_total.addActionListener(this);
			show_user_total.setText("SHOW USER TOTAL");
			show_user_total.setHorizontalTextPosition(JButton.CENTER);
			show_user_total.setBounds(25, 40, 250, 50);
			show_user_total.setFocusable(false);
			
			
			//Message Total
			show_message_total = new JButton();
			show_message_total.addActionListener(this);
			show_message_total.setText("SHOW MESSAGE TOTAL");
			show_message_total.setHorizontalTextPosition(JButton.CENTER);
			show_message_total.setFocusable(false);
			show_message_total.setBounds(25, 150, 250, 50);
			
			//Group Total			
			show_group_total = new JButton();
			show_group_total.addActionListener(this);
			show_group_total.setText("SHOW GROUP TOTAL");
			show_group_total.setHorizontalTextPosition(JButton.CENTER);
			show_group_total.setFocusable(false);
			show_group_total.setBounds(325, 40, 250, 50);
			
			
			//Positive Percentage Button
			show_positive_percentage = new JButton();
			show_positive_percentage.addActionListener(this);
			show_positive_percentage.setText("SHOW POSITIVE PERCENTAGE");
			show_positive_percentage.setHorizontalTextPosition(JButton.CENTER);
			show_positive_percentage.setFocusable(false);
			show_positive_percentage.setBounds(325, 150, 250, 50);
			
			
		
			//JFrame
			//Main UI => Admin Control Panel
					
			Border backline = BorderFactory.createLineBorder(Color.black);
			LayoutManager layout = new FlowLayout();		
		
			treePanel = new JPanel ();
			treePanel.setBounds(0, 0, 400 , 600);
			treePanel.setLayout(layout);
			treePanel.setBorder(backline);
			treePanel.add(treeView);
			treePanel.add(tree);
			treePanel.add(treeView);

			
			JPanel top_panel = new JPanel ();
			top_panel.setBounds(400, 0, 600, 300);
			top_panel.setLayout(null);
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
			top_panel.add(add_user);
			top_panel.add(add_group);
			top_panel.add(open_user_view);
			top_panel.add(user_id);
			top_panel.add(user_id_label);
			top_panel.add(group_id);
			top_panel.add(group_id_label);
			
			
			bottom_panel.add(show_user_total);
			bottom_panel.add(show_message_total);
			bottom_panel.add(show_group_total);
			bottom_panel.add(show_positive_percentage);
			
			
			
			
			
			ImageIcon image = new ImageIcon("calpolynighttwo.jpg"); //Image Icon
			this.setIconImage(image.getImage());
			
		}
	
	

	
	private void clearUserField() {
		user_id.setText(null);
		
	}
	
	private void clearGroupField() {
		group_id.setText(null);
		
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
	

	

	//Action for Add User group
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == add_user) {
			
			DefaultMutableTreeNode selected = new DefaultMutableTreeNode();
			selected=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			//SysEntry nodeInfo = selected.getUserObject(); 
		
			
			if (selected == null || user_id.getText().isBlank() || user_id.getText().isEmpty()) {
				System.out.println("Add selection to a group");
				JOptionPane.showMessageDialog(null,"YOU HAVE NOT CHOSEN A GROUP TO ADD NEW USER TO OR ID IS EMPTY","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			else if (selected.getUserObject() instanceof User) {
				
				System.out.println("User has been chosen prompt for group selection");
				JOptionPane.showMessageDialog(null,"WARNING.","ADD TO A GROUP",JOptionPane.ERROR_MESSAGE);
			}
			else if (selected.getUserObject() instanceof UserGroup) {
				System.out.println("Group has been selected");
				String id_input = user_id.getText();
				
				if(root_group.findID(id_input) == true) {
					System.out.println("Prompt user is already a member of the group");
					JOptionPane.showMessageDialog(null,"USER IS ALREADY A MEMBER","Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					User sample = new User(id_input);
					DefaultMutableTreeNode temp = new DefaultMutableTreeNode(sample);
					((UserGroup) selected.getUserObject()).addMember(sample);
					selected.add(new DefaultMutableTreeNode(sample));
					model.reload(selected);
				}
			}
			

			
			clearUserField();
			
		}
		if(e.getSource() == add_group) {
			
			DefaultMutableTreeNode selected = new DefaultMutableTreeNode();
			selected=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		
			
			if (selected == null ) {
				System.out.println("Add selection to a group");
				
				JOptionPane.showMessageDialog(null,"YOU HAVE NOT CHOSEN A GROUP TO ADD NEW USER TO OR IS EMPTY","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			else if (selected.getUserObject() instanceof User) {
				
				System.out.println("User has been chosen prompt for group selection");
				JOptionPane.showMessageDialog(null,"ADD TO A GROUP NOT ANOTHER USER","Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (selected.getUserObject() instanceof UserGroup) {
				System.out.println("Group has been selected");
				String id_input = group_id.getText();
				
				if(root_group.findID(id_input)) {
					System.out.println("Prompt group is already a member of the group");
					JOptionPane.showMessageDialog(null,"GROUP IS ALREADY A MEMBER","Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					UserGroup sample = new UserGroup(id_input);
					DefaultMutableTreeNode temp = new DefaultMutableTreeNode(sample);
					((UserGroup) selected.getUserObject()).addMember(sample);
					selected.add(new DefaultMutableTreeNode(sample));
					model.reload(selected);

				}
			}
			
			clearGroupField();
			
		}
		
		
		if(e.getSource() == open_user_view) {
			
			DefaultMutableTreeNode selected = new DefaultMutableTreeNode();
			selected=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            if (selected == null){
            	System.out.println("Ask User to select user to open user view");
				
				JOptionPane.showMessageDialog(null,"SELECT USER TO OPEN USER VIEW","Error",JOptionPane.ERROR_MESSAGE);
				return;
            }
            else if (selected.getUserObject() instanceof UserGroup){
				System.out.println("Ask User to select user to open user view");
				
				JOptionPane.showMessageDialog(null,"SELECT USER TO OPEN USER VIEW","Error",JOptionPane.ERROR_MESSAGE);
				return;
            }
            else if (selected.getUserObject() instanceof User){
                User user_for_user_panel = (User) selected.getUserObject();
                new UserPanel(user_for_user_panel, root_group);
            }
            else {
            	
            	System.out.println("Ask User to select user to open user view");
				
				JOptionPane.showMessageDialog(null,"SELECT USER TO OPEN USER VIEW","Error",JOptionPane.ERROR_MESSAGE);
				return;
             
            }


		}
		
		if(e.getSource() == show_user_total) {
            TotalUsersVisitor total = new TotalUsersVisitor();
            root_group.accept(total);
            JOptionPane.showMessageDialog(null,"There are " + total.getUser_total() + " users in total.", "Total Users on Application", JOptionPane.INFORMATION_MESSAGE);

		}
		
		if(e.getSource() == show_message_total) {
		      TotalTweetsVisitor visitor = new TotalTweetsVisitor();
	            root_group.accept(visitor);
	            JOptionPane.showMessageDialog(null,"There are " + visitor.getTotal() + " messages.", "Total Messages", JOptionPane.INFORMATION_MESSAGE);

		}
		
		if(e.getSource() == show_group_total) {
			
		      	TotalGroupsVisitor visitor = new TotalGroupsVisitor();
	            root_group.accept(visitor);
	            JOptionPane.showMessageDialog(null,"There are " + visitor.getTotal() + " groups.", "Total Groups", JOptionPane.INFORMATION_MESSAGE);
			

		}
		
		
		if(e.getSource() == show_positive_percentage) {
		      	PositivityVisitor visitor = new PositivityVisitor();
	            root_group.accept(visitor);
	            JOptionPane.showMessageDialog(null,"The positivity percentage is " + visitor.getPositive_percent() + " in messages.", "Positivity Percentage", JOptionPane.INFORMATION_MESSAGE);

		}
			
			
	

	}




	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
