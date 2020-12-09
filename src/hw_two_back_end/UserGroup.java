package hw_two_back_end;

import java.util.ArrayList;
import java.util.List;

public class UserGroup implements SysEntry {

	private String UniqueID;	

	private List <SysEntry> Member_Groups = new ArrayList <SysEntry> (); 

	
	
	
	
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
	
	
	

	public void addMember (SysEntry newBreakfastClubMember ) {
		this.Member_Groups.add(newBreakfastClubMember);
	}
	
	

	//Other Group added as a group member
	public List <SysEntry> getMemeber_Groups() {
		return Member_Groups;
	}




	@Override
	public void accept(TwitterVisitor visitor) {
		visitor.VisitUserGroup(this);
		for(SysEntry group_member : Member_Groups) {
			if ( group_member instanceof User || group_member instanceof UserGroup) {
				group_member.accept(visitor);
			}
			else {
				System.out.println("Visitor was not accepted try again or check inputs");
			}
		}
		
	}
	
	
	public Boolean findID(String id_input) {
		for(SysEntry element : Member_Groups) {
			if(element instanceof User) {
				continue;
			}
			
			else if(element instanceof UserGroup) {
				if(element.id().equals(id_input)) {
					return true;
				}
			
				else {
					if(((UserGroup) element).findID(id_input)){
						
						return true;
					}
				}
			}
		}
		
		return false;
	}

	

	
}
