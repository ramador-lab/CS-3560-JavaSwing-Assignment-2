package hw_two_back_end;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class User implements SysEntry{

	private String UniqueID;
	private int message_limit = 500;
	private List <User> Followers = new ArrayList<User>();
	private List <User> Following = new ArrayList<User>();
	private List <String> user_messages = new ArrayList<String>();
	private List <String> News_Feed = new ArrayList<String>();
	
	
	
	
	
	//UserID for User
	public User(String Uniqueid) {
		this.UniqueID = Uniqueid;
	}
	
	
	@Override
	public String id() {
		return this.UniqueID;
	}

	

	@Override
	public String toString() {
		return this.UniqueID;
	}

	

	
	
	
	
	
	//All UserIDs of those that follow User
	public List <User> getFollowers() {
		return Followers;
	}
	
	
	public void setFollowers(List <User> followers) {
		this.Followers = followers;
	}
	
	
	
	
	//All the UserIds the User Follows
	public List <User> getFollowing() {
		return Following;
	}
	
	
	
	public void setFollowing(List <User> following) {
		this.Following = following;
	}
	
	
	
	
	
	//All Twitter Messages from User followers NewsFeed
	public List <String> getNews_Feed() {
		return News_Feed;
	}
	
	
	
	public void setNews_Feed(List <String> news_Feed) {
		News_Feed = news_Feed;
	}
	
	
	
	
	
	//User choose to follow specific User'
	public  void Follow(User user) {
		
		Following.add(user);
		System.out.println("You now follow " + user.id());
		
	}
	
	
	public void Post (String message) {
		if(message.length() <= message_limit) {
			user_messages.add(message);
			
		}
		else System.out.println("Tweet message is too long");
		
	}


	





	@Override
	public void accept(TwitterVisitor visitor) {
		// TODO 
		
	}
	  
	
	
	
}
