public class NQueensSingleSolution {

    private int[][] board;
    private int size;

    public NQueensSingleSolution(int n) {
        size = n;
        board = new int[size][size];
    }

    public boolean solve() {
        return solve(0);
    }

    private boolean solve(int col) {
        if (col >= size) {
            return true; // all queens have been placed
        }
        for (int row = 0; row < size; row++) {
            if (isSafe(row, col)) {
                board[row][col] = 1; // place queen at (row, col)
                if (solve(col + 1)) {
                    return true;
                }
                board[row][col] = 0; // backtrack
            }
        }
        return false; // no solution found
    }

    private boolean isSafe(int row, int col) {
        // check if there is a queen in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // check if there is a queen in the upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // check if there is a queen in the lower diagonal
        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        NQueensSingleSolution problem = new NQueensSingleSolution(n);
        if (problem.solve()) {
            problem.display();
        } else {
            System.out.println("No solution found for n = " + n);
        }
    }
}
