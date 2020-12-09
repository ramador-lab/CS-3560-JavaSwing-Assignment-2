package TwitterVisitors;

import hw_two_back_end.*;

public class TotalUsersVisitor implements TwitterVisitor {

	private AllUsers sample;
	private int user_total = 0;
	
	@Override
	public void VisitUser(User user) {
		System.out.println("Getting total number of individual Users within the application");
		setUser_total(getUser_total() + 1);
		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		// Does Not Apply to groups only meant for individual users
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Only Individual Users
		
	}

	public int getUser_total() {
		return user_total;
	}

	public void setUser_total(int user_total) {
		this.user_total = user_total;
	}

	
	
	
}
