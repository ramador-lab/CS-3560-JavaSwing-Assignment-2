package TwitterVisitors;

import java.sql.Time;

import hw_two_back_end.AllUsers;
import hw_two_back_end.TwitterVisitor;
import hw_two_back_end.User;
import hw_two_back_end.UserGroup;

public class UpdatingVisitor implements TwitterVisitor {
	
    String LastUser = "No one";
    long time_frame = 0;
    Time RecentTime = new Time (time_frame);

	@Override
	public void VisitUser(User user) {
		// TODO Auto-generated method stub
        if (user.getUpdated_time().after(RecentTime) ){
            RecentTime = user.getUpdated_time();
            LastUser = user.id();
        }
		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// TODO Auto-generated method stub
		
		
	}
	
    public String getLastUser() {
        return LastUser;
    }

}
