public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n<=2) 
        return n;
        int one=2,two=1;
        for(int i=3;i<=n;i++) {
            int temp = one + two;
            two=one;
            one=temp;
        }
        return one;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println("Ways to climb "+n+" stairs: "+climbStairs(n));
    }
}
