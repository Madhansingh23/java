import java.util.*;

/**
 * NQueens solver using classic backtracking.
 * Reads n from stdin, then:
 *  - Finds all valid ways to place n queens on an n×n board
 *  - Prints each solution (rows with “Q” or “.”)
 *  - Finally prints the total count of distinct solutions
 */
public class NQueens {

    // Number of valid solutions found
    private int solutionCount = 0;

    // board[row][col] == true if there's a queen in that cell
    private boolean[][] board;

    // To mark if a column is already under attack
    private boolean[] cols;

    // To mark diagonals: row + col and row - col + (n-1)
    private boolean[] diag1, diag2;

    /**
     * Starts the solving process and displays all boards and counts.
     */
    public void solve(int n) {
        board = new boolean[n][n];
        cols   = new boolean[n];
        diag1  = new boolean[2 * n - 1];
        diag2  = new boolean[2 * n - 1];

        backtrack(0, n);

        System.out.printf("\nTotal number of solutions for n = %d: %d%n", n, solutionCount);
    }

    /**
     * Recursive helper: attempt to place a queen at row 'r'
     */
    private void backtrack(int r, int n) {
        if (r == n) {
            printBoard(n);
            solutionCount++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = r + c;
            int d2 = r - c + (n - 1);
            if (cols[c] || diag1[d1] || diag2[d2]) {
                continue;  // under attack
            }

            // Place queen
            board[r][c] = true;
            cols[c]     = true;
            diag1[d1]   = true;
            diag2[d2]   = true;

            backtrack(r + 1, n);

            // Remove queen (backtrack)
            board[r][c] = false;
            cols[c]     = false;
            diag1[d1]   = false;
            diag2[d2]   = false;
        }
    }

    /**
     * Prints the current board with 'Q' for queens and '.' for empty cells
     */
    private void printBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Main: reads integer n, solves and prints all solutions
     */
    public static void main(String[] args) {
        System.out.print("Enter n: ");
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input: integer expected.");
            sc.close();
            return;
        }

        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Please enter a positive integer (n ≥ 1).");
            sc.close();
            return;
        }

        new NQueens().solve(n);
        sc.close();
    }
}
