package Wipro_tasks;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Project1 {

    // Arrays to store employee data
    static int[] empNo = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
    static String[] empName = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
    static String[] joinDate = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "01/01/2000", "12/06/2006"};
    static char[] desigCode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
    static String[] department= {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
    static int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
    static int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
    static int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

    public static void main(String[] args) {//checks with args value so directly provide employye id while compliling as: javac Project1.java running as: java Project1 1003
        if (args.length != 1) {
            System.out.println("Usage: java Project1 <EmpID>");
            return;
        }

        int inputEmpId = Integer.parseInt(args[0]);
        boolean found = false;

        for (int i = 0; i < empNo.length; i++) {
            if (empNo[i] == inputEmpId) {
                String designation = "";
                int da = 0;

                // Determine Designation & DA
                switch (desigCode[i]) {
                    case 'e': designation = "Engineer";     da = 20000; break;
                    case 'c': designation = "Consultant";   da = 32000; break;
                    case 'k': designation = "Clerk";        da = 12000; break;
                    case 'r': designation = "Receptionist"; da = 15000; break;
                    case 'm': designation = "Manager";      da = 40000; break;
                    default:  designation = "Unknown";      da = 0;      break;
                }

                int salary = basic[i] + hra[i] + da - it[i];

                System.out.println("Emp No : " + empNo[i]);
                System.out.println("Emp Name : " + empName[i]);
                System.out.println("Department: " + department[i]);
                System.out.println("Designation : " + designation);
                System.out.println("Salary : " + salary);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid: " + inputEmpId);
        }
    }
}
