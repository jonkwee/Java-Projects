// For improvement: When encountering a tie in accessibility, look ahead a few steps to see which move will be better to take.


// Wernsdorf's Rule Version
public class KnightTour {
	
	// grid with accessibility heuristics
	private int[][] grid = {{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},
			{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},
			{4,6,8,8,8,8,6,4},{3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2}};
	
	private int currentRow;
	private int currentColumn;
	private int moveCounter = 0;
	private boolean hasMoves = true;
	
	public KnightTour(int row, int column) {
		currentRow = row;
		currentColumn = column;
		grid[currentRow][currentColumn] = 0;
	}
	
	public boolean checkOutOfGrid(int row, int column, int rowMove, int columnMove) {
		try {
			// if temp is a possible location in grid, then return true.
			@SuppressWarnings("unused")
			int temp = grid[row + rowMove][column + columnMove];
			return true;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println(exception);
			return false;
		}
	}
	
	public int[] possibleMoves() {
		int[] moveList = new int[8];
		// check each possible move. If possible then put a accessibility number in the corresponding location in moveList, else
		// put a 0.
		
		// move 0 is 2 up and 1 right, move 1 is 2 right and 1 up ... clockwise direction.
		for(int i = 1; i <= 8; i++) {
			switch(i){
			case 1:
				try {
					moveList[0] = (grid[currentRow - 2][currentColumn + 1] != 0) && (checkOutOfGrid(currentRow, currentColumn, -2, 1))
							? grid[currentRow - 2][currentColumn + 1] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 1: " + exception);
					break;
				}
			case 2:
				try {
					moveList[1] = (grid[currentRow - 1][currentColumn + 2] != 0) && (checkOutOfGrid(currentRow, currentColumn, -1, 2))
							? grid[currentRow - 1][currentColumn + 2] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 2: " + exception);
					break;
				}
			case 3:
				try {
					moveList[2] = (grid[currentRow + 1][currentColumn + 2] != 0) && (checkOutOfGrid(currentRow, currentColumn, 1, 2))
							? grid[currentRow + 1][currentColumn + 2] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 3: " + exception);
				}
			case 4:
				try {
					moveList[3] = (grid[currentRow + 2][currentColumn + 1] != 0) && (checkOutOfGrid(currentRow, currentColumn, 2, 1))
							? grid[currentRow + 2][currentColumn + 1] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 4: " + exception);
				}
			case 5:
				try {
					moveList[4] = (grid[currentRow + 2][currentColumn - 1] != 0) && (checkOutOfGrid(currentRow, currentColumn, 2, -1))
							? grid[currentRow + 2][currentColumn - 1] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 5: " + exception);
				}
			case 6:
				try {
					moveList[5] = (grid[currentRow + 1][currentColumn - 2] != 0) && (checkOutOfGrid(currentRow, currentColumn, 1, -2))
							? grid[currentRow + 1][currentColumn - 2] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 6: " + exception);
				}
			case 7:
				try {
					moveList[6] = (grid[currentRow - 1][currentColumn - 2] != 0) && (checkOutOfGrid(currentRow, currentColumn, -1, -2))
							? grid[currentRow - 1][currentColumn - 2] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 7: " + exception);
				}
			case 8:
				try {
					moveList[7] = (grid[currentRow - 2][currentColumn - 1] != 0) && (checkOutOfGrid(currentRow, currentColumn, -2, -1))
							? grid[currentRow - 2][currentColumn - 1] : 0;
							break;
				} catch (ArrayIndexOutOfBoundsException exception) {
					//System.out.println("Case 8: " + exception);
				}
			}
		}
		
		// Ex. If movelist[0] == 0, then move 0 is not doable. If movelist[0] != 0, then move 0 is doable.
		return moveList;
	}
	
	public int getMinIndex(int[] moveList) {
		int min = 10; // since no number should be greater than 8
		int minIndex = 8; // moveList's max index is 7
		for (int i = 0; i < moveList.length; i++) {
			if ((moveList[i] < min) && (moveList[i] != 0)) {
				min = moveList[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public void move(int[] moveList) {
		int index = getMinIndex(moveList);
		if (index == 8) {
			hasMoves = false;
			return;
		}
		
		switch(index) {
		case 0:
			currentRow -= 2;
			currentColumn += 1;
			break;
		case 1:
			currentRow -= 1;
			currentColumn += 2;
			break;
		case 2:
			currentRow += 1;
			currentColumn += 2;
			break;
		case 3:
			currentRow += 2;
			currentColumn += 1;
			break;
		case 4:
			currentRow += 2;
			currentColumn -= 1;
			break;
		case 5:
			currentRow += 1;
			currentColumn -= 2;
			break;
		case 6:
			currentRow -= 1;
			currentColumn -= 2;
			break;
		case 7:
			currentRow -= 2;
			currentColumn -= 1;
			break;
		}
		
		// mark the position as moved so that this position won't be accessible.
		grid[currentRow][currentColumn] = 0;
		moveCounter++;
		
	}
	
	public String getMoveCounter() {
		return "" + moveCounter + " moves are made!";
	}
	
	public boolean getHasMoves(){
		return hasMoves;
	}
	
	public int getCurrentRow() {
		return currentRow;
	}
	
	public int getCurrentColumn(){
		return currentColumn;
	}
	
	public void printGrid() {
		for (int[] l : grid) {
			for (int i : l) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}
