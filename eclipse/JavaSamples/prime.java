import java.io.*;
import java.util.*;

public class prime {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int n=sc.nextInt();
		int c=0;
		for(int i=2;i*i<=n;i++)
		{
			if(n%i==0)
			{	c++;
			break;
			}
		}
		if(c>0)
			System.out.println("Not prime");
		else
			System.out.println("Prime");
		
	}
}
