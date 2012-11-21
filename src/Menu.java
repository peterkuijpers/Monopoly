import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Menu {
	public static final int YES = 1;
	public static final int NO  = 0;
	
	public static final int Illegal = 0;
	public static final int Quit = 1;
	public static final int Overview = 2;
	public static final int Roll = 3;
	
	public static int getYesNoMenu( String string ) {
		boolean correct  = true;
		
		InputStreamReader isr = new InputStreamReader( System.in );
		BufferedReader br = new BufferedReader( isr );
		while (true) {
			System.out.print( string + " ");
			try {
				String result = br.readLine();
				if ( ! result.equals( ""  ) ) {
					char c = result.charAt(0);
					c = Character.toUpperCase(c);
					if ( c == 'Y' ) return YES;
					if ( c == 'N' ) return NO;
				}
				System.out.println("Invalid entry. Try again" );
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	public static void doContinue() {
		InputStreamReader isr = new InputStreamReader( System.in );
		BufferedReader br = new BufferedReader( isr );
			System.out.print( "Press any key to roll the dice ");
			try {
				int a = br.read();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static int getOptionMenu() {
		InputStreamReader isr = new InputStreamReader( System.in );
		BufferedReader br = new BufferedReader( isr );
			System.out.print( "Press Roll, Overview, Quit [ R | O | Q ]");
			try {
				String line = br.readLine();
				if ( line.length() == 0 ) 
					return Roll;
				else {
					char  choice = line.toUpperCase().charAt(0);
					switch (choice) {
					case 'R': 
						return Roll;
					case 'O':
						return Overview;
					case 'Q':
						return Quit;
					default: 
						return Roll;				
					}				
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Illegal;
	}

}
