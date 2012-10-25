
public class Board {
		
	private Field[] positions;  
		
	public Board() {
		positions = new Field[40];
		
		

		// position 0 is start
		positions[0] = new Field();
		positions[1] = new Street( "Mediterranean Avenue", 65, 10, Group.DarkBlue, Main.bank );
		positions[2] = new CommunityChest();
		positions[3] = new Street( "Baltic Avenue", 75, 12, Group.DarkBlue, Main.bank );
		positions[4] = new Tax( Tax.LuxuryTax );
		positions[5] = new Station( "Station South", 225, 50, Group.Stations, Main.bank );
		positions[6] = new Street("Oriental Avenue", 80, 20, Group.LightBlue, Main.bank );
		//chance
		positions[7] = new Field();		
		positions[8] = new Street("Vermont Avenue", 90, 20, Group.LightBlue, Main.bank );
		positions[9] = new Street("Connecticut Avenue", 100, 20, Group.LightBlue, Main.bank );
		positions[10] = new Field();
		//visiting jail
		positions[11]= new Street("St. Charles Place", 120, 32, Group.Purple, Main.bank );
		//electricity
		positions[12] = new Field();
		positions[13]= new Street("States Avenue", 130, 32, Group.Purple, Main.bank );
		positions[14]= new Street("Virginia Avenue", 140, 32, Group.Purple, Main.bank );
		positions[15]= new Station( "Station West", 225, 50, Group.Stations, Main.bank );
		positions[16]= new Street("St. James Place", 150, 45, Group.Orange, Main.bank );
		positions[17]= new CommunityChest();
		positions[18]= new Street("Tennessee Avenue",170, 45, Group.Orange, Main.bank );
		positions[19]= new Street("New York Avenue", 190, 50, Group.Orange, Main.bank );
		//free parking
		positions[20] = new Field();
		positions[21]= new Street("Kentucky Avenue", 200, 55, Group.Red, Main.bank );
		//chance
		positions[22] = new Field();
		positions[23]= new Street("Indiana Avenue", 210, 55, Group.Red, Main.bank );
		positions[24]= new Street("Ilinois Avenue", 220, 60, Group.Red, Main.bank );
		positions[25]= new Station("Station North", 225, 50, Group.Stations, Main.bank );
		positions[26]= new Street("Atlantic Avenue", 240, 65, Group.Yellow, Main.bank );
		positions[27]= new Street("Ventnor Avenue", 250, 65, Group.Yellow, Main.bank );
		//water
		positions[28] = new Field();
		positions[29]= new Street("Marvin Gardens", 260, 70, Group.Yellow, Main.bank );
		//go to jail
		positions[30] = new Field();
		positions[31]= new Street("Pacific Avenue", 280, 75, Group.Green, Main.bank );
		positions[32]= new Street("North Carolin Avenue", 290, 75, Group.Green, Main.bank );
		//community chest
		positions[33] = new Field();
		positions[34]= new Street("Pensylvania Avenue", 300, 80, Group.Green, Main.bank );
		positions[35]= new Station("Station East", 225, 50, Group.Stations, Main.bank );
		//chance
		positions[36] = new Field();
		positions[37]= new Street("Park Place", 365, 95, Group.Blue, Main.bank );
		//luc tax
		positions[38] = new Field();
		positions[39]= new Street("Boardwalk", 425, 100, Group.Blue, Main.bank );
	}
	
	
	public Field getPosition( int location ) {
		return positions[location ];
	}
	
	
	public String toString() {
		String str = "";
		for ( int n = 0; n < 40; n++ ) {
			str += "\n" + n;
			if ( positions[n] != null ) 
				str += "\n" +  positions[n].toString();
		}
		return str;
	}
}
