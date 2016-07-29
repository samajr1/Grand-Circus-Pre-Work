package PreWork;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DiffDates {

	
	static void diffBetween () {
		try{
			System.out.println("Please enter the first date you'd like to compare. (MM/DD/YYYY)");
			Scanner inputDate1 = new Scanner(System.in);
			String date1 = inputDate1.next();

			System.out.println("Please enter the second date you'd like to compare. (MM/DD/YYYY)");
			Scanner inputDate2 = new Scanner(System.in);
			String date2 = inputDate2.next();

			DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate d1 = LocalDate.parse(date1, format);
			LocalDate d2 = LocalDate.parse(date2, format);

			if (d1.isBefore(d2)) {
				Period p = Period.between(d1, d2);
				long p2 = ChronoUnit.DAYS.between(d1, d2);
				System.out.println("The difference between dates is: " + p.getYears() + " years, " + p.getMonths()
						+ " months, and " + p.getDays() + " days. (" + p2 + " days total)");
			} else {
				Period p = Period.between(d2, d1);
				long p2 = ChronoUnit.DAYS.between(d2, d1);
				System.out.println("The difference between dates is: " + p.getYears() + " years, " + p.getMonths()
						+ " months, and " + p.getDays() + " days. (" + p2 + " days total)");
				inputDate1.close(); // scanners are closed to prevent resource leaks
				inputDate2.close();
			}
			}catch (DateTimeParseException dt){
				System.out.println("One or more of your entries were not of the form (MM/DD/YYYY)");
				System.out.println("");
				diffBetween();
			}
		
	}

	public static void main(String[] args) {

		diffBetween();

	}

}
