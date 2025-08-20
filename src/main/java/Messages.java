import java.util.Scanner;

public class Messages {
    public String CHATBOT_NAME = "Bambam"; // chatbot name is constant
    Scanner scanner = new Scanner(System.in); // Scanner for inputs from users

    // function to print greetings to users
    public void printGreetings() {
        System.out.println("Hello! I'm " + CHATBOT_NAME + "\n" +
                "What can I do for you?\n");
    }

    // function to print exit message
    public void printExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    // function to get input from users
    public String getInput() {
        return scanner.nextLine();
    }

    // function to print inputs from users
    public void printInputs(String input) {
        System.out.println(input + "\n");
    }
}
