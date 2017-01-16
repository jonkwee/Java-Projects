
public class KnightTourTest {
	
	public static void main(String[] args) {
		
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				KnightTour tour = new KnightTour(row, column);
				System.out.printf("Current position is (%d, %d)\n", row, column);
				while (tour.getHasMoves()) {
					int[] list = tour.possibleMoves();
					tour.move(list);
				}
				System.out.println(tour.getMoveCounter());
				System.out.println();
			}
		}
	}
}
