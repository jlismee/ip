import java.util.Scanner;

public class Messages {
    public String CHATBOT_NAME = "Bambam"; // chatbot name is constant
    Scanner scanner = new Scanner(System.in); // Scanner for inputs from users
    private Task tasks;

    public Messages() {
        this.tasks = new Task();
    }

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
        tasks.addTaskToList(input);
        System.out.println("added: " + input + "\n");
    }

    // function to print list of tasks
    public void printTaskList() {
        tasks.printList();
        System.out.println();
    }
}
