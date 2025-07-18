import java.util.*;

public class ClimbStairsWithJumps {
    public static int countWays(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return count(0, arr, dp);
    }

    private static int count(int i, int[] arr, int[] dp) {
        if (i == arr.length) return 1;
        if (i > arr.length) return 0;
        if (dp[i] != -1) return dp[i];

        int ways = 0;
        for (int j = 1; j <= arr[i] && i + j <= arr.length; j++) {
            ways += count(i + j, arr, dp);
        }
        return dp[i] = ways;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 1, 2};  // can jump up to arr[i] steps from each i
        System.out.println("Total ways: " + countWays(arr));
    }
}
