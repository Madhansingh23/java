import java.util.*;
import java.io.*;

public class GenerateOddorEven {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to generate odd or even numbers up to that number:");
        int n = sc.nextInt();
        for(int i=0;i<n;i++) 
        {
            if (i % 2 == 0) 
            { 
                System.out.println(i + " is even");
            } 
            else 
            {
                System.out.println(i + " is odd");
            }
        }
    }
}
