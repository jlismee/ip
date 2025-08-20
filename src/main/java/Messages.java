import java.util.Scanner;

public class Messages {
    public String CHATBOT_NAME = "Bambam"; // chatbot name is constant
    Scanner scanner = new Scanner(System.in); // Scanner for inputs from users
    private TaskList taskList;

    public Messages() {
        this.taskList = new TaskList();
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

    // function to print details when adding task
    public void printAddTask(Task newTask) {
        taskList.addTaskToList(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + newTask.printTaskString());
        System.out.println("Now you have " + taskList.getTaskCounter() + " tasks in the list.\n");
    }

    // function to print inputs from users
    public void printInputs(String input) {
        taskList.addTaskToList(new Task(input));
        System.out.println("added: " + input + "\n");
    }

    // function to print list of tasks
    public void printTaskList() {
        taskList.printList();
        System.out.println();
    }

    // function to print action of mark task as done
    public void printTaskDone(int index) {
        System.out.println("Nice! I've marked this task as done:");
        taskList.markTaskAsDone(index);
    }

    // function to print action of mark task as undone
    public void printTaskUndone(int index) {
        System.out.println("OK, I've marked this task as not done yet:");
        taskList.markTaskAsUndone(index);
    }
}
