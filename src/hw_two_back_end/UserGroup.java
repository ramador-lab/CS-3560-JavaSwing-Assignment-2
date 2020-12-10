package hw_two_back_end;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class UserGroup implements SysEntry {

	private String UniqueID;	

	private List <SysEntry> Member_Groups = new ArrayList <SysEntry> (); 

	private long time_frame;
	private Time time_created = new Time(time_frame);
	
	
	
	//Set and Get UserID for User
	public UserGroup(String id) {
		this.UniqueID = id;
		this.time_frame = System.currentTimeMillis();
		this.time_created = new Time (time_frame);
	}
	
	
	
	// Assignment 3
	public Time getCreation_Time() {
		return time_created;
	}
	
	

	
    public User look_for_user(String id){
        for (SysEntry member : Member_Groups) {
            if (member instanceof User) {
                if (member.id().equals(id)){
                    return (User) member;
                }
            }
            else if (member instanceof UserGroup) {
                if (((UserGroup) member).findID(id)) {
                    return ((UserGroup) member).look_for_user(id);
                }
            }
        }
        return null;
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
