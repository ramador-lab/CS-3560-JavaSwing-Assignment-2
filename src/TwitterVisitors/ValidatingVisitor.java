package TwitterVisitors;

import java.util.ArrayList;

import hw_two_back_end.AllUsers;
import hw_two_back_end.TwitterVisitor;
import hw_two_back_end.User;
import hw_two_back_end.UserGroup;

public class ValidatingVisitor implements TwitterVisitor {
	
    ArrayList USER_ID = new ArrayList();
    ArrayList GROUP_ID = new ArrayList();
    Boolean valid_user = true;
    Boolean valid_group = true;

	@Override
	public void VisitUser(User user) {
		// TODO Auto-generated method stub
        if (USER_ID.contains(user.id())){
            valid_user = false;
        }
        if (user.id().contains(" ")){
            valid_user = false;
        }
        USER_ID.add(user.id());
		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		// TODO Auto-generated method stub
        if (GROUP_ID.contains(group.id())){
            valid_group = false;
        }
        if (group.id().contains(" ")){
            valid_group = false;
        }
        GROUP_ID.add(group.id());
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Boolean validity_user () { return valid_user;}
	public Boolean validity_group () { return valid_group;}
	

}
