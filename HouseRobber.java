public class HouseRobber {

    // Function to calculate maximum rob amount
    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int current = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};  // Example input
        int maxAmount = rob(houses);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }
}
