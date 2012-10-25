import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Menu {
	public static final int YES = 1;
	public static final int NO  = 0;
	
	
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

}
