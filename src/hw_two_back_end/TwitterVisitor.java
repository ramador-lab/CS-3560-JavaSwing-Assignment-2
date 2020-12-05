package hw_two_back_end;

public interface TwitterVisitor {
	
	
	void VisitUser(User user);
	void VisitUserGroup (UserGroup group);
	void VisitAllUsers(AllUsers all);
	
}
