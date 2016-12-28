import java.util.Scanner;

public class HeartRateCalculator {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// field variables
		boolean control = false;
		String firstName = null, lastName = null, correct = null;
		int year = 0, month = 0, day = 0;
		
		while (!control) {
			// Get input from user
			System.out.println("Please enter your first name:");
			firstName = input.nextLine();
			System.out.println("Please enter your last name:");
			lastName = input.nextLine();
			System.out.println("Please enter your year of birth:");
			year = input.nextInt();
			System.out.println("Please enter your month of birth:");
			month = input.nextInt();
			System.out.println("Please enter your day of birth:");
			day = input.nextInt();
			
			System.out.printf("Your name is %s %s and you are born"
					+ " in %d/%d/%d.\n", firstName, lastName, year, month, day);
			
			// need additional nextline to get rid of previous linebreak from nextInt.
			input.nextLine();

			System.out.println("Is this information correct?");
			correct = input.nextLine();
			if (correct.toLowerCase().equals("yes")) {
				control = true;
			}
		}
		input.close();
		
		// Create instance of HeartRate using user input
		HeartRate heartrate = new HeartRate(firstName, lastName, year, month, day);
		System.out.printf("You are %d years old.\n", heartrate.calculateAge());
		System.out.printf("Your maximum heart rate is %d per minute!\n", heartrate.calculateMaxHeartRate());
		System.out.printf("Your target heart rate is between %d and %d.\n",
				heartrate.calculateMinTarget(), heartrate.calculateMaxTarget());
		
		System.out.println("Thanks for using the Heart Rate Calculator!");
	}
}
