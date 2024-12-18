//Programmer Name: Austin
//GitHub Username: welkins1

//wildcard import 
import java.util.*;

public class EzPass {

    //This method generates a random integer between 0 & int a - 1 using Math.random()
    public static int randomInt(int a) {
        a = (int) (Math.random() * a);
        return a;
    }
    
//This method generates a random integer between two numbers using Math.random() 
    public static int randomIntBetween(int a, int b) {
        int number = (int) (Math.random() * (b - a + 1) + a);

        return number;
    }
    
//This method prints each index of an array using a for each loop 
    public static void printArray(char[] array) {
        for (char i : array) {
            System.out.print(i);
        }
    }

    /*
    This method is used for getting the size of the password while also 
     verifying the size is between 6 and 30. It also gives the user the option
    of inputting q to quit the program. 
    */
    public static int inputCheck() {
        Scanner input = new Scanner(System.in);
        String size;
        boolean inputValid = false;
        
        //loops until inputValid is true
        while (!inputValid) {
            System.out.print("\nPlease enter a password length between 6 and 30 or q to quit: ");
            size = input.next(); // Get the next input token

            // check if the user entered "q" (case insensitive)
            if (size.equalsIgnoreCase("q")) {
                System.exit(0); // Exit the program
            }

            // check if the input is a valid integer
            try {
                int number = Integer.parseInt(size);

                // Validate the number range
                if (number > 5 && number < 31) {
                    inputValid = true; // Input is valid, exit the loop
                    return number; // Returns the valid number
                } else {
                    System.out.println("\nInvalid input!");
                }
            } catch (NumberFormatException e) {
                // Handles non-integer input (not "q")
                System.out.println("\nInvalid input!");
            }
        }

        return 0; //Not used, but required for compilation
    }


       /*
    This method is similar to inputCheck(), but serves as input for later 
    conditional statements and allows the user to enter q to quit the program
    */
    

    public static String inputCheck2() {
        Scanner input = new Scanner(System.in);

        String addBlank = null;
        
        boolean InputValid = false;
        
        //Loops until inputValid is true
        while (!InputValid) {

            if (input.hasNext()) { //Checks if input exists 
                addBlank = input.next(); 
                
                if (addBlank.equalsIgnoreCase("q"))
                    System.exit(0); //Exits program

                if (addBlank.equalsIgnoreCase("N") || addBlank.equalsIgnoreCase("Y")) {
                    InputValid = true;
                } else {

                    System.out.print("\nPlease type Y or N or type q to quit: ");

                }

            }

        }
        return addBlank.toUpperCase(); //Returns Y or N to be used later
    }

    public static void main(String[] args) {

        //I used patorjk.com to generate the ASCII art below
        System.out.println("""                  
                           
    ███████╗███████╗    ██████╗  █████╗ ███████╗███████╗    
    ██╔════╝╚══███╔╝    ██╔══██╗██╔══██╗██╔════╝██╔════╝    
    █████╗    ███╔╝     ██████╔╝███████║███████╗███████╗    
    ██╔══╝   ███╔╝      ██╔═══╝ ██╔══██║╚════██║╚════██║    
    ███████╗███████╗    ██║     ██║  ██║███████║███████║    
    ╚══════╝╚══════╝    ╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝    
                           
                           """);
       
        //This string contains all the possible characters a password can have
        String GetChars
                = //0-25 - chartAt index for uppercase letters
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + //26-51 - charAt index for lowercase letters
                "abcdefghijklmnopqrstuvwxyz"
                + //52-61 - charAt index for numbers
                "0123456789"
                + //62-71 - charAt index for special characters 
                "!@#$%^&*()";

        
        System.out.println("Welcome to Ez Pass! The easy password generator!");

       
        boolean GenerateAnother = true; 
        //used for looping program to generate another password 
        while (GenerateAnother) {
            
            //size's value is based on call to inputCheck()
        int size = inputCheck();
        
        //The password is printed as an array
        char password[] = new char[size];
        
        System.out.print("\nDo you want letters in your password? Y/N ");
        
        //value of AddLetters is Y or N or Q based on call to inputCheck2()
        String AddLetters = inputCheck2();

        
        if (AddLetters.equals("Y")) {
            //for loop fills password[] with random uppercase and lowercase chars
           
            for (int i = 0; i < size; i++) {
                password[i] = GetChars.charAt((randomIntBetween(0, 51)));
                                   //randomization expression 
            }
        }

        System.out.print("\nDo you want numbers in your password? Y/N ");

        //value of AddNumbers is Y or N or Q based on call to inputCheck2()
        String AddNumbers = inputCheck2();

        if (AddNumbers.equals("Y") 
                && AddLetters.equals("N")) { //fills entire password array with numbers
            for (int i = 0; i < size; i++) {
                password[i]
                        = GetChars.charAt((randomIntBetween(52, 61)));
            }
        }

        if (AddNumbers.equals("Y")) {
            for (int i = 0;
                    i < randomIntBetween(2, 5); //randomizes the index
                    i++) {
                password[randomIntBetween(0, size - 1)]
                        = GetChars.charAt((randomIntBetween(52, 61)));
            }                             //fills indexes with random numbers
        }

        System.out.print("\nDo you want special characters in your password? Y/N ");

        //value of AddSpecialChars is Y or N or Q based on call to inputCheck2()
        String AddSpecialChars = inputCheck2();

        if (AddNumbers.equals("N")
                && AddLetters.equals("N") 
                && AddSpecialChars.equals("Y")) { //fills entire password array with special characters
            for (int i = 0; i < size; i++) {
                password[i]
                        = GetChars.charAt((randomIntBetween(62, 71)));
            }
        }

        if (AddSpecialChars.equals("Y")) {
            for (int i = 0;
                    i < randomIntBetween(2, 5); //randomizes the index
                    i++) {
                password[randomIntBetween(0, size - 1)]
                        = GetChars.charAt((randomIntBetween(62, 71)));
            }                                //fills indexes with random special chars
        }

        //Simulates a generation of the password 
        
        System.out.print("\nGenerating Password"); 

        for (int i = 0; i < 5; i++) {

                //The try-catch is required to use Thread.sleep
                try {
                    //Loading time in miliseconds
                    Thread.sleep(500);
                    //printed to the console based on i < 5
                    System.out.print(".");

                } catch (InterruptedException error) {

                }

            }
            
        System.out.print("\n\nYour password is: ");
        
        printArray(password); //prints password array by calling printArray()
        System.out.print("\n\nWould you like to generate another password? Y/N ");
        
        //value of AddLetters is Y or N or Q based on call to inputCheck2()
        String GeneratePassLoop = inputCheck2();
        
        //conditional statement determines if program loops based on user input
        if (GeneratePassLoop.equalsIgnoreCase("N")) {
            System.out.println("\nThank you for using EZ Pass :)");
            GenerateAnother = false; //terminates program loop 
            
        }
        
         }
        

    }
}
