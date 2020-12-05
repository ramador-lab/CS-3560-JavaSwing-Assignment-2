package TwitterVisitors;

import hw_two_back_end.*;

public class TotalTweetsVisitor implements TwitterVisitor  {

	@Override
	public void VisitUser(User user) {
		System.out.println("Getting Total Tweets of User");
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		System.out.println("Getting Total Tweets of Group");
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Does Not Apply
		
	}

}
