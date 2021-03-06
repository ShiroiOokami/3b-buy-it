package Main;

/**
 * Regular expression to validate the user's information.
 * 
 * Also contains methods to check if a String is valid.
 * 
 * @version 2014-04-11
 *
 */
public class UserRegExps {
	private static String UserName = "^[A-Za-z]{1,11}$";
	private static String Name = "^[A-Z][A-Za-z.]{0,19}$";
	private static String PIN = "^\\d{4}$";
	private static String StreetAdd = "^[\\w][\\w\\s\\.]{0,29}$";
	private static String ZIP = "^\\d{5}$";
	private static String City = "^[A-Z][A-Za-z\\s]{0,14}$";
	private static String CardNum = "^\\d{16}$";
	private static String ValidDate = "^\\d{2,4}[-/]\\d{1,2}[-/]\\d{1,2}$";
	private static String ValidPhone = "^\\d{10}$";
	
	public static boolean username(String u)
	{
		return u.matches(UserName);
	}
	
	public static boolean name(String n)
	{
		return n.matches(Name);
	}
	
	public static boolean PIN(String p)
	{
		return p.matches(PIN);
	}
	
	public static boolean streetAdd(String s)
	{
		return s.matches(StreetAdd);
	}
	
	public static boolean ZIP(String z)
	{
		return z.matches(ZIP);
	}
	
	public static boolean city(String c)
	{
		return c.matches(City);
	}
	
	public static boolean cardnum(String c)
	{
		return c.matches(CardNum);
	}
	
	public static boolean date(String c)
	{
		return c.matches(ValidDate);
	}
	
	public static boolean phone(String s)
	{
		return s.matches(ValidPhone);
	}
}
