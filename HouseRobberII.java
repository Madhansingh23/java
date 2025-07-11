public class HouseRobberII {

    // Helper method to calculate rob amount in linear subarray
    private static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

    // Main method for circular robbing
    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int robFirst = robLinear(nums, 0, n - 2);
        int robLast = robLinear(nums, 1, n - 1);

        return Math.max(robFirst, robLast);
    }

    // Test Main
    public static void main(String[] args) {
        int[] houses = {2, 3, 2};  // Example 1 → Output: 3
        System.out.println("Max rob amount (circular): " + rob(houses));

        int[] houses2 = {1, 2, 3, 1};  // Example 2 → Output: 4
        System.out.println("Max rob amount (circular): " + rob(houses2));
    }
}
