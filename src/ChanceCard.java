
public class ChanceCard {
	private int id;
	private String description;

	public ChanceCard() {
		
	}
	public ChanceCard( int id, String description ) {
		this.id = id;
		this.description = description;
	}

	public String toString() {
		String str = "id: " + id;
		str += ", description: " + description;
		return str;
	}
}
