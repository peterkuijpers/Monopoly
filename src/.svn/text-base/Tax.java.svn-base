
public class Tax extends Field {
	public final static int IncomeTax = 1;
	public final static int LuxuryTax = 2;
	
	private final static int INCOME_TAX_AMOUNT = 200;
	private final static int LUXURY_TAX_AMOUNT = 200;
	
	
	private int taxType; 
	private int amount;
	public Tax() {
		
	}

	public Tax( int type ) {
		this.taxType = type;
		if ( taxType == IncomeTax)	
			amount = INCOME_TAX_AMOUNT;
		else if ( taxType == LuxuryTax )
			amount = LUXURY_TAX_AMOUNT;
	}
	
	public String getName() {
		return "TAX";
	}
	
	public String toString() {
		return "Tax: " + taxType + ", Amount: " + amount;
	}
}
