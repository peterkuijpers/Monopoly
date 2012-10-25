
public class BoardPlayer extends Player {
	
	private static final int START_MONEY = 1500;
	private static final int SALARY = 200;
	private int position;
	
	public BoardPlayer() {
		setMoney( START_MONEY );
		this.position  = 0;
	}
	
	public void setPosition( int pos ) {
		this.position = pos;
	}
	public int getPosition() {
		return this.position;
	}
	/* return true if double dice -> have another turn
	 * 
	 */
	public boolean doTurn() {
		int step1,step2;
	
		step1 = rollDice();
		step2 = rollDice();
		System.out.println( "dice: " + step1 + " - " + step2 );
		updatePosition ( step1 + step2 );
		
		if ( step1 == step2 )
			return true;
		else
			return false;
	}
	/* return true if result of each of the two dice is equal (have another turn)
	 */
	private int rollDice(  ) {
		
		return  (int)( Math.random() * 6 ) + 1;
	}
	private void updatePosition( int steps) {
		position += steps;
		if (position > 39 ) {
			// gone on or over start, receive $200
			System.out.println( "Received salary of " + BoardPlayer.SALARY );
			this.addMoney( BoardPlayer.SALARY );
		}
		position = position - 40 * ( position / 40 );
	}
	
	public String toString() {
		String str;
		str = super.toString();
		str += "\nPosition: " + position;
		return str;
	}
}
