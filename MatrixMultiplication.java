import java.util.*;
import java.util.regex.Matcher;

public class MatrixMultiplication {

    // Method to multiply matrices A and B
    static int[][] multiply(int[][] A, int[][] B, int r1, int c1, int c2) {
        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Method to read a matrix
    static int[][] readMatrix(Scanner sc, int rows, int cols, String name) {
        System.out.println("Enter elements for matrix " + name + " (" + rows + "x" + cols + "):");
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        return matrix;
    }

    // Method to print a matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Matrix A dimensions
            System.out.print("Enter rows and columns of Matrix A: ");
            int r1 = sc.nextInt(), c1 = sc.nextInt();

            // Matrix B dimensions
            System.out.print("Enter rows and columns of Matrix B: ");
            int r2 = sc.nextInt(), c2 = sc.nextInt();

            if (c1 != r2) {
                System.out.println("❌ Cannot multiply matrices: Column of A != Row of B");
                return;
            }

            int[][] A = readMatrix(sc, r1, c1, "A");
            int[][] B = readMatrix(sc, r2, c2, "B");

            int[][] result = multiply(A, B, r1, c1, c2);

            System.out.println("✅ Resultant Matrix (A x B):");
            printMatrix(result);

        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please enter only integers.");
        } finally {
            sc.close();
        }
    }
}
