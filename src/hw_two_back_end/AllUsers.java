package hw_two_back_end;


import java.util.List;


//List that Contain all users both individual and groups 
public class AllUsers implements SysEntry  {
	
	private List <SysEntry> elements;

	public List <SysEntry> getAllUsers() {
		return elements;
	}

	public void setAllUsers(List <SysEntry> allUsers) {
		this.elements = allUsers;
	}

	@Override
	public void accept(TwitterVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}




	

}
