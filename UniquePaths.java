public class UniquePaths {
    // Function to calculate unique paths using DP (space optimized)
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        // Initialize first row with 1s
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Iterate over remaining rows
        for (int i = 1; i < m; i++) {
            // Update current row based on previous row (same dp array reused)
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // Main method to test the function
    public static void main(String[] args) {
        int m = 3, n = 7;
        int result = uniquePaths(m, n);
        System.out.println("Number of unique paths for " + m + "x" + n + " grid: " + result);
    }
}
