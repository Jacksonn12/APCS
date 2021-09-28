import java.util.Scanner;

/**
 * SimpleIOMath program
 * @version 09/24/2021
 * @author Jackson Niedel
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favnumber;

    /**
     * Parameterized constructor for the smallest prime number of the user's age
     * @param num An int value supplied for smallestPrime
     * @return
     */
    private int smallestPrime(int num){
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++) {
            if(num % i == 0)
                return i;
        }
        return num;
    }

    /**
     * Method promptUser asks the user their name, age, and favorite number
     */
    public void promptUser(){
        Scanner input = new Scanner(System.in);
        System.out.println ("Question 1: What is your name?");
        name= input.nextLine();
        System.out.println("Question 2: How old are you?");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number?");
        favnumber = input.nextInt();
    }

    /**
     * Method printInfo prints the user's name, age, age+1, the first prime factor of age, favorite number, and favorite number squared
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday you will turn " + (age +1));
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number is: " + favnumber);
        System.out.println("Your favorite number squared is: " + (favnumber*favnumber));
    }

    /**
     * Main entry point for class SimpleIOMath
     * @param args main line arguments if needed
     */
    public static void main (String[] args) {
        System.out.println ("* Sit yourself down, take a seat. *");
        System.out.println ("* All you gotta do is repeat after me *");
        SimpleIOMath pro = new SimpleIOMath();
        pro.promptUser();
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        pro.printInfo();
        System.out.println("* end of program *");
    }
}

