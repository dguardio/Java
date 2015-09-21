import java.util.Scanner;
public class FigureInWords{

	private static final String[] lowNames = {
	   "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	private static final String[] tensNames = {
	   "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private static final String[] specNames = {
	   "thousand", "million", "billion"};


	// Thank you Christian d'Heureuse, Inventec Informatik AG, Switzerland
	public static String wordConverter (int n) {
	   if (n < 0) {
	      return "Negative " + wordConverter(-n);
	      }
	   if (n <= 999) {
	      return convert999(n);
	      }
	   String s = null;
	   int t = 0;
	   while (n > 0) {
	      if (n % 1000 != 0) {
	         String s2 = convert999(n % 1000);
	         if (t > 0) {
	            s2 = s2 + " " + specNames[t-1]; }
	         if (s == null) {
	            s = s2; }
	          else {
	            s = s2 + ", " + s; }}
	      n /= 1000;
	      t++; }
	   return s; }

	// Range extends between 0 & 999
	private static String convert999 (int n) {
	   String s1 = lowNames[n / 100] + " hundred";
	   String s2 = convert99(n % 100);
	   if (n <= 99) {
	      return s2; 
	  	}
	    else if (n % 100 == 0) {
	      return s1;
	       }
	    else {
	      return s1 + " and " + s2; }}

	// Range extends from 0 to 99.
	private static String convert99 (int n) {
	   if (n < 20) {
	      return lowNames[n]; }
	   String s = tensNames[n / 10];
	   if (n % 10 == 0) {
	      return s; }
	   return s + "-" + lowNames[n % 10]; }

	 public static void startConverter(){
	 	String end = "";
		try{
			System.out.print("Enter a number value or enter done to quit ");
			Scanner in = new Scanner(System.in);

			
			end = in.nextLine();
			int num = Integer.parseInt(end);
			System.out.println(wordConverter(num));
		}
		catch (Exception e){
			if (end.equalsIgnoreCase("done")){
				System.out.println("Thank you for using our service");
				System.exit(0);
			}
			else{
				System.out.println("You have entered an invalid value, try again!");
			}
		}
	startConverter();
	 }

	public static void main(String[] args) {
		startConverter();
	}
}