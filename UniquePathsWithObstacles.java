public class UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If starting cell is an obstacle, return 0
        if (obstacleGrid[0][0] == 1) return 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;  // Obstacle blocks the path
                } else if (j > 0) {
                    dp[j] += dp[j - 1];  // Add left cell value if not first column
                }
            }
        }

        return dp[n - 1];
    }

    // Sample main method for testing
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int result = uniquePathsWithObstacles(grid);
        System.out.println("Number of unique paths (with obstacles): " + result);
    }
}
