import java.util.*;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of rows: ");
            int rows=sc.nextInt();
            System.out.print("Enter number of columns: ");
            int cols = sc.nextInt();

            int[][] A = new int[rows][cols];
            int[][] B = new int[rows][cols];
            int[][] sum = new int[rows][cols];

            System.out.println("Enter elements for Matrix A:");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    A[i][j] = sc.nextInt();

            System.out.println("Enter elements for Matrix B:");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    B[i][j] = sc.nextInt();

            // Adding both matrices
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    sum[i][j] = A[i][j] + B[i][j];

            System.out.println("Resultant Matrix:");
            for (int[] row : sum) {
                for (int val : row)
                    System.out.print(val + " ");
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}
