package hw_two_back_end;

public class DefaultMutableTreeNode implements SysEntry {
	private SysEntry User_type;
	
	public DefaultMutableTreeNode (SysEntry treeOption) {this.User_type = treeOption;}
	

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
