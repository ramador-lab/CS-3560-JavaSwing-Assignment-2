package TwitterVisitors;


import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import hw_two_back_end.*;


public class PositivityVisitor implements TwitterVisitor {
	
	private List<String> positive_data_base= new ArrayList<String>(Arrays.asList("awesome", "gucci", "nice", "cool", "fire", "unique"));
    private double positive = 0;
    private double total = 0;
    private double positive_percent = 0;
   

	@Override
	public void VisitUser(User user) {
		System.out.println("Getting Positivity Percentage for User");
		
		for (String iterate : user.getUser_Messages()) {
			total++;
			
			for(String element : positive_data_base) {
				if(iterate.toLowerCase().contains(element.toLowerCase())) {positive++;};
				break;
			}
			
			
		}
		
		
	}

	@Override
	public void VisitUserGroup(UserGroup group) {
		System.out.println("Getting Positivity Percentage of User Group");
		
	}

	@Override
	public void VisitAllUsers(AllUsers all) {
		// Only Individually Getting Positive Percentages for all users
		
	}
	
	
	

	public double getPositive_percent() {
        if (total ==0) {
            return positive_percent;
        }
        setPositive_percent((positive/total)*100.0);
		return positive_percent;
	}

	public void setPositive_percent(double positive_percent) {
		this.positive_percent = positive_percent;
	}
	

}
