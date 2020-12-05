package hw_two_back_end;

import java.util.List;

public class UserGroup implements SysEntry {

	private String UniqueID;	
	private List <User> Individual_Users;
	private List <UserGroup> Memeber_Groups; 

	
	
	
	
	//Set and Get UserID for User
	public UserGroup(String id) {
		this.UniqueID = id;
	}
	
	
	
	@Override
	public String id() {
		
		return this.UniqueID;
	}
	
	
	
	@Override
	public String toString() {
		return this.UniqueID;
	}
	
	
	
	
	
	
	//Individual User Members inside of Group
	public List <User> getIndividual_Users() {
		return Individual_Users;
	}



	public void setIndividual_Users(List <User> individual_Users) {
		Individual_Users = individual_Users;
	}
	
	



	//Other Group added as a group member
	public List <UserGroup> getMemeber_Groups() {
		return Memeber_Groups;
	}



	public void setMemeber_Groups(List <UserGroup> memeber_Groups) {
		Memeber_Groups = memeber_Groups;
	}



	@Override
	public void accept(TwitterVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	

	
}
