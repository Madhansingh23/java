import java.util.*;

public class ClimbCustomSteps {
    public static int countWays(int n, int[] steps) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int step : steps) {
                if (i - step >= 0) dp[i] += dp[i - step];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] steps = {1, 3, 5};
        System.out.println("Ways to climb with steps " + Arrays.toString(steps) + ": " + countWays(n, steps));
    }
}
