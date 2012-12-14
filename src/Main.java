import java.util.ArrayList;
import java.util.*;


public class Main {

	private static Board board;

	public static Player bank;
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new HumanPlayer("Peter");
		bank = new Bank("Bank");

		MachinePlayer p1 = new MachinePlayer( "MP1" );
		board = new Board();
		System.out.println( board.toString() );
		System.out.println( "Player 1: \n" + player1.toString() );
		System.out.println( "Bank: \n" + bank.toString() );
		System.out.println( "Machine player 1: \n" + p1.toString() );

		ArrayList<Player> players = new ArrayList<Player>();
		players.add( player1 );
		players.add( p1 );

		System.out.println("\n**************");
		System.out.println("Game starts now....");
		for ( int n = 1; n < 100 ; n++ ) {
			boolean result;

			for ( Player player: players ) {
				System.out.println();				
				System.out.println( "Player: " +  player.getName() + ", Money: " + player.getMoneyStatus()  );
				do {
					result = true;
					int option = Menu.getOptionMenu();
					if (option  == Menu.Roll) {
						result = ((BoardPlayer)player).doTurn();
						//System.out.println( "Player 1: \n" + player1.toString() );
						int position = ((BoardPlayer)player).getPosition();
						System.out.println( "Position: " + position  );
						System.out.println( board.getPosition(position).toString() );
						propertyOwnership( player, position );
					}
					else if (option == Menu.Overview ) {
						printOverview( player );
					}
					else if (option == Menu.Quit ) {
						result = false;
					}

				} while (result == true );
			}
		}

	}

	private static void propertyOwnership( Player player, int location ) {
		// get property 
		Field  field = board.getPosition(location);
		Property prop;
		if (field instanceof Property )  {
			prop = (Property)field;	
		} else
			return;

		Player owner = prop.getOwner();
		if ( owner != null) {
			if ( owner.equals( bank ) ) {
				//do you want to buy it?
				//only ask human players
				if ( player instanceof HumanPlayer ) {
					boolean questioning = true;
					while ( questioning ) {
						int result = Menu.getYesNoOverviewMenu( player.toString()  + ", do you want to buy this property? [Y | N | O ]" );
						if ( result == Menu.YES ) {
							questioning = false;
							if ( buyProperty(location, player ) ) {
								System.out.println("You bought yourself a property");
								updateRent( player );
							} else 
								System.out.println("You were not successfull in purchasing the property. Do you have enough money to purchase it?");
						} else if ( result == Menu.Overview ) {
							printOverview( player );
						} else
							questioning = false;
					}
				}
				if ( player instanceof MachinePlayer ) {
					if ( buyProperty( location, player )) {
						System.out.println("Machine player bought the property");
						updateRent( player );
					}
				}
			} else if ( ! owner.equals( player ) )  { 
				payRent( player, prop );
				System.out.println( "Pay the rent: " + prop.getRentValue() + ", to the owner: " + owner.getName()   );
			} else {
				System.out.println( player.getName() + ", you already own this property");
			}
		}
	}


	private static boolean payRent( Player me,  Property prop) {
		int rentValue = prop.getRentValue();
		Player payTo = prop.getOwner();
		me.substractMoney(rentValue);
		payTo.addMoney(rentValue);
		return true;
	}
	// buy property at position from player for amount
	//
	private static boolean buyProperty( int position, Player player ) {
		Field  field = board.getPosition(position);
		Property prop;
		if (field instanceof Property )  {
			prop = (Property)field;
			int propPrice = prop.getPurchasePrice();
			if ( isAffordable(player, propPrice )) {
				Player owner = prop.getOwner();
				player.substractMoney(propPrice);
				owner.addMoney(propPrice);
				prop.setOwner( player );
				return true;
			} else return false;
		} else
			return false;
	}

	private static Player getLocationOwner( int location ) {
		Field  field = board.getPosition(location);
		if (field instanceof Property )  {
			return ((Property)field).getOwner();	
		} else
			return null;
	}

	/**
	 * can you affort to spent this amount of money (do you have it)
	 * @param player
	 * @param amount
	 * @return
	 */
	private static boolean isAffordable( Player player, int amount ) {
		int playerMoney  = player.getMoneyStatus();
		if (playerMoney >= amount )
			return true;
		else
			return false;

	}

	private static void printOverview( Player player ) {
		ArrayList<Property> results = board.getPropertiesForPlayer(player);	

		if ( ! results.isEmpty() ) {
			Collections.sort( results, new GroupComparator() );

			System.out.println( String.format("%20s %10s %7s %10s %5s %6s %6s" , "Name", "Price", "Group", "Owner", "Rent", "Houses", "Hotels") );
			for( Field result : results ) {
				System.out.println( result.shortString() );
			}
		} else
			System.out.println( "\t" + player.getName() + ", doesnt own any properties");
	}
	
	private static void updateRent( Player player ) {
		updateStationRent( player );
	}
	
	private static void updateStationRent( Player player ) {
		ArrayList<Property> results = board.getPropertiesForPlayer(player);	
		int stationCnt = 0;
		if ( ! results.isEmpty() ) {
			for ( Property prop : results ) {
				if ( prop instanceof Station ) {
					stationCnt++;
				}
			}
			
			for ( Property prop : results ) {
				if ( prop instanceof Station ) {
					Station station = (Station)prop;
					int rent = station.getRentValue();
					station.setRentValue( rent * stationCnt );
				}
			}
		}
		
	}
}
