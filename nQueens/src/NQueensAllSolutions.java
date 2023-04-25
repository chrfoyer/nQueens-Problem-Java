import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensAllSolutions {

    private int[][] board;
    private int size;
    private List<int[][]> solutions;

    public NQueensAllSolutions(int n) {
        size = n;
        board = new int[size][size];
        solutions = new ArrayList<>();
    }

    public List<int[][]> solve() {
        solve(0);
        return solutions;
    }

    private void solve(int col) {
        if (col >= size) {
            int[][] solution = new int[size][size];
            for (int i = 0; i < size; i++) {
                solution[i] = Arrays.copyOf(board[i], size);
            }
            solutions.add(solution);
        } else {
            for (int row = 0; row < size; row++) {
                if (isSafe(row, col)) {
                    board[row][col] = 1; // place queen at (row, col)
                    solve(col + 1);
                    board[row][col] = 0; // backtrack
                }
            }
        }
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

    public static void main(String[] args) {
        int n = 4;
        NQueensAllSolutions problem = new NQueensAllSolutions(n);
        List<int[][]> solutions = problem.solve();
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i+1) + ":");
            int[][] solution = solutions.get(i);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(solution[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Number of solutions: " + solutions.size());
    }
}
