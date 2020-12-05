package hw_two_back_end;


//Admin Panel follows Singleton Pattern

public class AdminPanel {

	private static AdminPanel pointer;
	
	public static AdminPanel getInstance () {
		if (AdminPanel.pointer == null) {
			pointer = new AdminPanel();
		}
		
		return pointer;
		
	}
	
	
}
