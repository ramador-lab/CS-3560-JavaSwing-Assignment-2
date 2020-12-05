package TwitterVisitors;

import hw_two_back_end.*;

public class TotalGroupsVisitor implements TwitterVisitor {

	@Override
	public void VisitUser(User user) {
		// Does Not Apply to individual User
		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		 System.out.println("Getting total number of Groups within the Application");
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Does Not Apply
		
	}

}
