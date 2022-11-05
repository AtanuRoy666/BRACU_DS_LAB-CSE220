package Homework1;

import java.util.Scanner;
public class TestStudent{

    public static void main(String[]args){

        // creating an object of StudentOps
        // size of the Student array sent in parameter
        StudentOps stOps = new StudentOps(2);
        Scanner k = new Scanner(System.in);


        while(true){
            System.out.println("Press 1 to add a new student");
            System.out.println("Press 2 to delete a student");
            System.out.println("Press 3 to edit a student's info");
            System.out.println("Press 4 to exit");

            // taking input from the user
            int input = k.nextInt();
            // an additional nextLine() is used for a specific reason
            // go to this link to find out https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
            k.nextLine();

            // operations on Student objects depends on the user input
            if(input == 1){
                stOps.addStudent();
            }else if(input == 2){
                stOps.deleteStudent();
            }else if(input == 3){
                stOps.editStudent();
            }else if(input == 4){
                break;
            }else{
                System.out.println("Wrong input");
            }
        }
    }
}



