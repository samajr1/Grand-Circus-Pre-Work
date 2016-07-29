package PreWork;

import java.util.Scanner;

public class NumberReverse {

	public static void main(String[] args) {
		System.out.println("Please enter the whole number you'd like to reverse.");
		Scanner in = new Scanner(System.in); // assigns user input to 'in'
		runTheNumbers(in); // calls the method and applies the user's input variable
	}

	public static void runTheNumbers(Scanner input) {
		long reverse = 0; // long is used over int to allow the input of larger numbers

		if (input.hasNextLong()) { // Checks if user input meets the requirements of long type

			long n = input.nextLong(); /* Sets user input equal to n. input must be
									 	* a whole number, long is used instead of
									 	* int to allow for larger numbers
									 	*/
			while (n != 0) {
				reverse = reverse * 10;
				reverse = reverse + n % 10;
				n = n / 10;
			}
			System.out.println("The reverse of your entered whole number is " + reverse);

		} else {
			System.out.println("Your entry was either too large or not a whole number. Try again.");
			input.next();
			runTheNumbers(input); 	/* If user input does not meet requirements
									 * of long type then they will be given this
									 * error and another request for input
									 */
		}
	}
}
