package Main;

public class BookRegExp {
		private static String isbn = "^\\d{13}$";
		private static String title = "^[\\w][\\w\\s]{0,19}";
		private static String publisher = "^[\\w][\\w.-]{0,19}$";
		private static String year = "^\\d{0,4}$";
		private static String price = "^[0-9]{0,3}+\\.[0-9]{2}$";
		private static String minQty = "^\\d{4}$";
		private static String review = "\\A[\\w][\\w\\d.\\s*&!?\"\']{0,254}\\Z";
		
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
		
		public static boolean minQty (String q)
		{
			return q.matches(minQty);
		}
		
		public static boolean review (String r)
		{
			return r.matches(review);
		}
		
}
