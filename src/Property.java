
public class Property extends Field  implements Group{
	private int purchasePrice;
	private int rentValue;
	private Player owner;
	private String name;
	
	private int groupCode;
	
	public Property() {
		
	}
	public void setName( String name)  {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPurchasePrice( int price ) {
		purchasePrice = price;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setOwner( Player owner ) {
		this.owner = owner;
	}
	
	public Player getOwner( ) {
		return owner;
	}
	public void setRentValue( int value ) {
		rentValue = value;
	}
	
	public int getRentValue() {
		return rentValue;
	}
	
	public int getGroupCode() {
		return groupCode;
	}
	
	public void setGroupCode( int groupCode ) {
		this.groupCode = groupCode;
	}
	
	public String toString() {
		String strf;
		strf = String.format("%20s %10s %7s %10s %5s %6s %6s" , "Name", "Price", "Group", "Owner", "Rent", "Houses", "Hotels");
		strf  += String.format("\n%20s %10d %7s %10s %5d %6d %6d", name, purchasePrice, groupCode, owner.getName(), rentValue, 0, 0 );
		
		return strf;
				
	}
	
	public String shortString() {
		String strf;
//		strf = String.format("\n%20s %10s %7s %10s %5s %6s %6s" , "Name", "Price", "Group", "Owner", "Rent", "Houses", "Hotels");
		strf = String.format("%20s %10d %7s %10s %5d %6d %6d", name, purchasePrice, groupCode, owner.getName(), rentValue, 0, 0 );
		
		return strf;
		
	}
}
