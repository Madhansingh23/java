import java.util.*;

public class nextHappy {
    static boolean checkHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }

    static int nexHappy(int n) {
        n++;
        while (true) {
            if (checkHappy(n)) return n;
            n++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(nexHappy(n));
    }
}
