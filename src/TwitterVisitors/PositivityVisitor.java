package TwitterVisitors;


import hw_two_back_end.*;


public class PositivityVisitor implements TwitterVisitor {

	@Override
	public void VisitUser(User user) {
		System.out.println("Getting Positivity Percentage for User");
		
		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		System.out.println("Getting Positivity Percentage of User Group");
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Only Individually Getting Positive Percentages for all users
		
	}
	

}
