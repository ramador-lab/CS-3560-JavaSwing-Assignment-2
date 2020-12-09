package TwitterVisitors;

import hw_two_back_end.*;

public class TotalTweetsVisitor implements TwitterVisitor  {
	
	private int total;

	@Override
	public void VisitUser(User user) {
		System.out.println("Getting Total Tweets of User");
		setTotal(getTotal() + user.getUser_Messages().size());
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		//Does Not Apply
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Does Not Apply
		
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
