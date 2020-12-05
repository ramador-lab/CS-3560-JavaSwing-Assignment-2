package hw_two_back_end;


//Composite Pattern
/*
 * IF THERE IS A HIERARCHY
 * IF THE COMPOSITE (GROUP) CAN HAVE A LIST OF SYSENTRIES
 * 
 * */

public interface SysEntry {
	public void accept(TwitterVisitor visitor);
	
	public String toString();
	
	public String id();
}
