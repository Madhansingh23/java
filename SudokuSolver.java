import java.util.*;

public class SudokuSolver {

    public static final int SIZE = 9;  // size of a standard Sudoku

    private int[][] board = new int[SIZE][SIZE];
    private boolean[][] rowUsed = new boolean[SIZE][SIZE + 1];
    private boolean[][] colUsed = new boolean[SIZE][SIZE + 1];
    private boolean[][] boxUsed = new boolean[SIZE][SIZE + 1];

    public SudokuSolver(int[][] initial) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int v = initial[r][c];
                board[r][c] = v;
                if (v != 0) {
                    rowUsed[r][v] = true;
                    colUsed[c][v] = true;
                    boxUsed[(r / 3) * 3 + c / 3][v] = true;
                }
            }
        }
    }

    public boolean solve() {
        // Find the first empty cell
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 0) {
                    int box = (r / 3) * 3 + c / 3;
                    // Try candidates 1–9
                    for (int v = 1; v <= SIZE; v++) {
                        if (!rowUsed[r][v] && !colUsed[c][v] && !boxUsed[box][v]) {
                            board[r][c] = v;
                            rowUsed[r][v] = colUsed[c][v] = boxUsed[box][v] = true;

                            if (solve()) {
                                return true;
                            }

                            // Undo (back‑track)
                            board[r][c] = 0;
                            rowUsed[r][v] = colUsed[c][v] = boxUsed[box][v] = false;
                        }
                    }

                    return false;  // no valid number for this cell
                }
            }
        }
        return true;  // no empty cells → solved
    }

    private void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r][c]);
                System.out.print(c == 8 ? "\n" : " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[SIZE][SIZE];

        System.out.println("Enter 9 lines of 9 digits (use 0 or . for blanks):");
        for (int r = 0; r < SIZE; r++) {
            String line = sc.nextLine().trim();
            line = line.replaceAll("[^0-9]", "");
            if (line.length() < SIZE) {
                System.err.println("Invalid input on row " + (r + 1));
                return;
            }
            for (int c = 0; c < SIZE; c++) {
                grid[r][c] = line.charAt(c) - '0';
            }
        }

        SudokuSolver solver = new SudokuSolver(grid);

        if (solver.solve()) {
            System.out.println("Solved puzzle:");
            solver.printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
