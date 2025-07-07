import java.util.Scanner;

public class PyramidPattern_NumberLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            // Print numbers 1 to i
            for (int num = 1; num <= i; num++) {
                System.out.print(num);
            }

            // Print characters A to (A + i - 1)
            for (int ch = 0; ch < i - 1; ch++) {
                System.out.print((char)('A' + ch));
            }

            System.out.println();
        }

        sc.close();
    }
}
