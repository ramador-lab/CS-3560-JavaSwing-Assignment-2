package TwitterVisitors;

import hw_two_back_end.*;

public class TotalUsersVisitor implements TwitterVisitor {

	private AllUsers sample;
	
	@Override
	public void VisitUser(User user) {
		System.out.println("Getting total number of individual Users within the application");

		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		// Does Not Apply to groups only meant for individual users
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Only Individual Users
		
	}

	
	
	
}
