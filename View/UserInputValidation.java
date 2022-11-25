package View;

import java.util.Scanner;
public class UserInputValidation {

    private UserInputValidation(){}
    public static long longValidation(String name) {
        Scanner input=new Scanner(System.in);
        long value=0;
        boolean condition=true;
        do
        {System.out.println("Enter the "+name);
            if(input.hasNextLong())
            {
                value=input.nextLong();
                if(value<0)
                {
                    System.out.println(name+" must not be negative");
                }
             else {
                    condition = false;
                }
            }
            else
            {
                System.out.println("Enter the valid "+name);
                input.next();
            }
        }while(condition);
        return value;
    }
    public static int intValidation(String name) {
        Scanner input=new Scanner(System.in);
        int value=0;
        boolean condition=true;
        do
        {System.out.println("Enter the "+name);
            if(input.hasNextInt())
            {
                value=input.nextInt();
                if(value<0)
                {
                    System.out.println(name+" must not be negative");
                }
                else {
                    condition = false;
                }
            }
            else
            {
                System.out.println("Enter the valid "+name);
                input.next();
            }
        }while(condition);
        return value;
    }


}

