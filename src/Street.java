
public class Street extends Property  {
	private int colorCode;
	
	public Street() {
	}
	public Street( String name, int purchasePrice, int rentValue,  int group, Player owner ) {
		setName( name );
		setPurchasePrice( purchasePrice );
		setRentValue( rentValue );
		setGroupCode( group );
		setOwner( owner );
	}
	
	/**
	public String toString() {
		String str = "";
		str = super.toString();
		str += "\nColor code: " + colorCode;
		return str;
	}
	**/
}
