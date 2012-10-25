
public interface Group {
	public static final int DarkBlue = 1;
	public static final int LightBlue = 2;
	public static final int Purple = 3;
	public static final int Orange = 4;
	public static final int Red = 5;
	public static final int Yellow = 6;
	public static final int Green = 7;
	public static final int Blue = 8;
	public static final int Stations = 9;
	// private final String[] groups = {"DarkBlue", "LightBlue", "Purple", "Orange", "Red", "Yellow", "Green", "Blue" };
	
	public int getGroupCode();
	public void setGroupCode( int groupCode );
}
