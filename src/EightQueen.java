import java.util.LinkedList;

public class EightQueen {
    private final LinkedList<int[]> queensOnBoard = new LinkedList<>();
    private final LinkedList<LinkedList<int[]>> possiblePositions = new LinkedList<>();

    public EightQueen() {
        solve(0);
    }

    public boolean solve(int x) {
        if (x == 8) {
            possiblePositions.add(new LinkedList<>(queensOnBoard));
        }
        for (int i = 0; i < 8; i++) {
            if (!isThreatened(x, i)) {
                queensOnBoard.add(new int[]{x, i});
                if (solve(x + 1))
                    return true;
                queensOnBoard.removeLast();
            }
        }
        return false;
    }

    private boolean isThreatened(int x, int y) {
        for (int[] position : queensOnBoard) {
            int queen_x = position[0];
            int queen_y = position[1];
            if (queen_y == y || queen_x + queen_y == x + y || queen_x - queen_y == x - y) {
                return true;
            }
        }
        return false;
    }

    public void printPositions() {
        System.out.println("Possible positions for the eight queen problem: ");
        for (int i = 0; i < possiblePositions.size(); i++) {
            System.out.printf("%02d: ", i + 1);
            for (int[] positions : possiblePositions.get(i)) {
                System.out.printf("(%d, %c) ", positions[0] + 1, (char) positions[1] + 97);
            }
            System.out.println();
        }
    }
}
