import java.util.Arrays;

public class TurtleGraphics {
	
	private enum penStates {UP, DOWN};
	private penStates state = penStates.UP;
	private enum directions {UP, DOWN, LEFT, RIGHT};
	private directions point = directions.UP;
	private int[][] grid = new int[20][20];
	private int currentRow;
	private int currentColumn;
	
	public void initialize() {
		for (int[] subGrid : grid) {
			Arrays.fill(subGrid, 0);
		}
		currentRow = 10;
		currentColumn = 10;
	}
	
	public void penUp() {
		state = penStates.UP;
		System.out.println("Your pen is UP!");
	}
	
	public void penDown() {
		state = penStates.DOWN;
		System.out.println("Your pen is DOWN!");
	}
	
	public void turnRight() {
		switch(point) {
		case UP:
			point = directions.RIGHT;
			break;
		case DOWN:
			point = directions.LEFT;
			break;
		case LEFT:
			point = directions.UP;
			break;
		case RIGHT:
			point = directions.DOWN;
			break;
		}
	}
	
	public void turnLeft() {
		switch(point) {
		case UP:
			point = directions.LEFT;
			break;
		case DOWN:
			point = directions.RIGHT;
			break;
		case LEFT:
			point = directions.DOWN;
			break;
		case RIGHT:
			point = directions.UP;
			break;
		}
	}
	
	public void moveForward(int distance) {
		try {
			switch(point) {
			
			case UP:
				if (state.equals(penStates.DOWN)) {
					for (int i = currentRow; i >= currentRow - distance; i--) {
						grid[i][currentColumn] = 1;
					}
				}
				currentRow -= distance;
				break;
				
			case DOWN:
				if (state.equals(penStates.DOWN)) {
					for (int i = currentRow; i <= currentRow + distance; i++) {
						grid[i][currentColumn] = 1;
					}
				}
				currentRow += distance;
				break;
			
			case LEFT:
				if (state.equals(penStates.DOWN)) {
					for (int i = currentColumn; i >= currentColumn - distance; i--) {
						grid[currentRow][i] = 1;
					}
				}
				currentColumn -= distance;
				break;
			
			case RIGHT:
				if (state.equals(penStates.DOWN)) {
					for (int i = currentColumn; i <= currentColumn + distance; i++) {
						grid[currentRow][i] = 1;
					}
				}
				currentColumn += distance;
				break;
				
			}  
				
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("You cannot move outside the grid!");
			System.out.println(exception);
		}
	}
	
	
	public void displayArray() {
		 for (int[] a: grid) {
			 for (int i : a) {
				 System.out.print("" + i + " ");
			 }
			 System.out.println();
		 }
	}
	
}
