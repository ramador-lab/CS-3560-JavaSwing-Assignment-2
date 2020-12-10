package hw_two_back_end;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ListModel;

import java.sql.Time;
import java.lang.Exception;


//Assignment 3 features- line 62

public class User extends Subject implements SysEntry, Observer{
	
	private long time_frame;
	private Time time_updated = new Time(time_frame);
	private Time time_created = new Time(time_frame);
	private String UniqueID;
	private int message_limit = 500;
	private List <User> Following = new ArrayList<User>();
	private List <String> user_messages = new ArrayList<String>();
	private List <String> News_Feed = new ArrayList<String>();
	
	
	
	
	
	//UserID for User
	public User(String Uniqueid) {
		this.UniqueID = Uniqueid;
		this.time_frame = System.currentTimeMillis();
		this.time_created = new Time (time_frame);
	}
	
	
	@Override
	public String id() {
		return this.UniqueID;
	}

	

	@Override
	public String toString() {
		return this.UniqueID;
	}

	
	
	
	//All the UserIds the User Follows
	public List getFollowing() {
		return this.Following;
	}
	
	
	
	public void setFollowing(User user) {
		this.Following.add(user);
	}
	
	
	// Assignment 3
	public Time getCreation_Time() {
		return time_created;
	}
	
	

	@Override
	public void update(Subject subject, String message) {
		if(subject instanceof User) {
			this.News_Feed.add(((User) subject).id() + ": "+ "\n" + message);
			this.time_frame = System.currentTimeMillis();
			this.time_updated = new Time(time_frame);
			this.News_Feed.set(1, "last update: " + time_updated);
			
			
		}
		else
			throw new RuntimeException("Not User trying to post");
		
	}
	
	
	public Time getUpdated_time() {
		return time_updated;
	}
	
	//User NewsFeed
	public List <String> getNews_Feed() {
		return News_Feed;
	}
	
	
	//User TweetMessages
	public List <String> getUser_Messages(){
		return user_messages;
	}
	
	
	
	//User choose to follow specific User'
	public  void Follow(User user) {
		
		Following.add(user);
		System.out.println("You now follow " + user.id());
		
	}
	


	@Override
	public void accept(TwitterVisitor visitor) {
		visitor.VisitUser(this);		
	}
	
	
	
	//Twitter Posts of User
	
	public void Post (String message) {
		if(message.length() <= message_limit) {
			user_messages.add(message);
			News_Feed.add(this.id() + ":" + "\n" + message);
			notifyObservers(message);
			this.time_frame = System.currentTimeMillis();
			this.time_updated = new Time(time_frame);
			
		}
		else System.out.println("Tweet message is too long");
		
	}

	  
	
	
	
}
