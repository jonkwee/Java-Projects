import java.util.Scanner;

public class TurtleGraphicsTest {
	public static void main(String[] args) {
		TurtleGraphics turtle = new TurtleGraphics();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Turtle Graphics! The instructions of using this program is as follows:\n"
				+ "Enter 1 to bring your pen up.\nEnter 2 to bring your pen down.\nEnter 3 to turn right.\n"
				+ "Enter 4 to turn left.\nEnter 5 to move forward.\n"
				+ "Enter 6 to display the grid.\nEnter 7 to clear grid.\nEnter 9 to quit.");
		
		
		while (input.hasNext()) {
			switch(input.nextInt()) {
			case 1:
				turtle.penUp();
				break;
			case 2:
				turtle.penDown();
				break;
			case 3:
				turtle.turnRight();
				break;
			case 4:
				turtle.turnLeft();
				break;
			case 5:
				System.out.println("How many spaces do you want to move?");
				int distance = input.nextInt();
				turtle.moveForward(distance);
				break;
			case 6:
				turtle.displayArray();
				break;
			case 7:
				turtle.initialize();
				break;
			case 9:
				System.out.println("Thanks for using the Turtle Graphics");
				input.close();
				break;
			}
		}
		
	}
}
