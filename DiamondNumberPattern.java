import java.util.Scanner;

public class DiamondNumberPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        // Upper half including the middle row
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }

            // Print increasing numbers
            for (int num = 1; num <= i; num++) {
                System.out.print(num);
            }

            // Print decreasing numbers
            for (int num = i - 1; num >= 1; num--) {
                System.out.print(num);
            }

            System.out.println();
        }

        // Lower half (excluding the middle row)
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }

            // Print increasing numbers
            for (int num = 1; num <= i; num++) {
                System.out.print(num);
            }

            // Print decreasing numbers
            for (int num = i - 1; num >= 1; num--) {
                System.out.print(num);
            }

            System.out.println();
        }

        sc.close();
    }
}
