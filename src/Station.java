
public class Station extends Property implements Group {
	private int colorCode;
	public Station() {
		
	}
	public Station( String name, int value,int rentValue, int group, Player owner ) {
		setName( name );
		setPurchasePrice( value );
		setRentValue( rentValue );
		setGroupName( group );
		setOwner( owner );
	}
	
	public void setGroupName( int group ) {
		this.colorCode = group;
	}
	public int getGroupName() {
		return colorCode;
	}
	/*
	public String toString() {
		String str = "";
		str = super.toString();
		str += "\nGroup code: " + colorCode;
		return str;
	}
	*/
}
