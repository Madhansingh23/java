import java.util.*;

public class HouseRobberIIWithTrace {

    // Helper to compute max rob and path from linear subarray
    private static Result robLinear(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 0) return new Result(0, new ArrayList<>());
        if (n == 1) return new Result(nums[start], new ArrayList<>(List.of(start)));

        int[] dp = new int[n];
        List<Integer>[] path = new ArrayList[n];

        dp[0] = nums[start];
        path[0] = new ArrayList<>(List.of(start));

        if (nums[start + 1] > nums[start]) {
            dp[1] = nums[start + 1];
            path[1] = new ArrayList<>(List.of(start + 1));
        } else {
            dp[1] = nums[start];
            path[1] = new ArrayList<>(path[0]);
        }

        for (int i = 2; i < n; i++) {
            if (dp[i - 1] > dp[i - 2] + nums[start + i]) {
                dp[i] = dp[i - 1];
                path[i] = new ArrayList<>(path[i - 1]);
            } else {
                dp[i] = dp[i - 2] + nums[start + i];
                path[i] = new ArrayList<>(path[i - 2]);
                path[i].add(start + i);
            }
        }

        return new Result(dp[n - 1], path[n - 1]);
    }

    // Result structure
    static class Result {
        int amount;
        List<Integer> houses;

        Result(int amount, List<Integer> houses) {
            this.amount = amount;
            this.houses = houses;
        }
    }

    // Main function for circular version
    public static Result rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return new Result(0, new ArrayList<>());
        if (n == 1) return new Result(nums[0], List.of(0));

        Result case1 = robLinear(nums, 0, n - 2); // Exclude last
        Result case2 = robLinear(nums, 1, n - 1); // Exclude first

        return (case1.amount >= case2.amount) ? case1 : case2;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] houses = {2, 3, 2};  // Example 1
        Result res1 = rob(houses);
        System.out.println("Max amount: " + res1.amount);
        System.out.println("Houses robbed: " + res1.houses);

        int[] houses2 = {1, 2, 3, 1};  // Example 2
        Result res2 = rob(houses2);
        System.out.println("Max amount: " + res2.amount);
        System.out.println("Houses robbed: " + res2.houses);

        int[] houses3 = {1, 3, 1, 3, 100};  // Example 3
        Result res3 = rob(houses3);
        System.out.println("Max amount: " + res3.amount);
        System.out.println("Houses robbed: " + res3.houses);
    }
}
