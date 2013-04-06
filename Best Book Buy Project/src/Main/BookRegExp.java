package Main;

public class BookRegExp {
		private static String isbn = "^\\d{13}$";
		private static String title = "^[\\w][\\w\\s]{0,19}";
		private static String publisher = "^[\\w\\d][\\w\\s.-]{0,19}$";
		private static String year = "^\\d{4}$";
		private static String price = "^[0-9]{0,3}+\\.[0-9]{2}$";
		private static String qty = "^\\d{1,4}$";
		private static String review = "\\A[\\w][\\w\\d.\\s*&!?\"\']{0,254}\\Z";
		private static String author = "[A-Z][a-z]+( [A-Z][a-z]+)?";
		
		public static boolean isbn (String i)
		{
			return i.matches(isbn);
		}
		
		public static boolean title (String t)
		{
			return t.matches(title);
		}
		
		public static boolean publisher (String p)
		{
			return p.matches(publisher);
		}
		
		public static boolean year (String y)
		{
			return y.matches(year);
		}
		
		public static boolean price (String p)
		{
			return p.matches(price);
		}
		
		public static boolean qty (String q)
		{
			return q.matches(qty);
		}
		
		public static boolean review (String r)
		{
			return r.matches(review);
		}
		
		public static boolean author (String a)
		{
			return a.matches(author);
		}
		
}
