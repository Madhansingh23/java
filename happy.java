import java.util.*;

class happy {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            int s = 0;
            while (n > 0) {
                int digit = n % 10;
                s += digit * digit;
                n /= 10;
            }
            n = s;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        happy obj = new happy();
        if (obj.isHappy(n))
            System.out.println("Happy Number");
        else
            System.out.println("Not a Happy Number");
    }
}
