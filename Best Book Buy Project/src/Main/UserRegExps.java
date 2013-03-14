package Main;

public class UserRegExps {
	private static String UserName = "^\\w[\\w.]{0,11}$";
	private static String Name = "^\\w[\\w.]{0,19}$";
	private static String PIN = "^\\d{4}$";
	private static String StreetAdd = "^[\\w\\d][\\w\\d\\s]{0,29}$";
	private static String ZIP = "^\\d{5}$";
	private static String State = "";
	private static String City = "^\\w[\\w\\s]{0,14}$";
	
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
}
