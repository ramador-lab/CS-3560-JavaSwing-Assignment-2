package hw_two_back_end;




//Incorporation of the Observer Pattern


import java.util.List;
import java.util.ArrayList;



public abstract class Subject {
	
	private List <Observer> observers = new ArrayList<Observer> ();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	
	public void detach (Observer observer) {
		observers.remove(observer);
	}
	
	
	
	public void notifyObservers(String message_post) {
		for(Observer observer : observers) {
			observer.update(this, message_post);
		}
	}
	
}
