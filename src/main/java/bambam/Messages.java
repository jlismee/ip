package bambam;

import bambam.task.Task;

import java.util.Scanner;

public class Messages {
    public String CHATBOT_NAME = "bambam.Bambam"; // chatbot name is constant
    Scanner scanner = new Scanner(System.in); // Scanner for inputs from users
    private TaskList taskList;

    public Messages(TaskList taskList) {
        this.taskList = taskList;
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
        System.out.println("    " + newTask.printTaskString());
        System.out.println("Now you have " + taskList.getTaskSize() + " tasks in the list.\n");
    }

    // function to print details when deleting task
    public void printDeleteTask(int index) throws BambamException {
        Task task = taskList.getTask(index);
        taskList.deleteTaskFromList(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println("    " + task.printTaskString());
        System.out.println("Now you have " + taskList.getTaskSize() + " tasks in the list.\n");
    }

    // function to print list of tasks
    public void printTaskList() throws BambamException {
        taskList.printTaskList();
        System.out.println();
    }

    // function to print action of mark task as done
    public void printTaskDone(int index) throws BambamException {
        System.out.println("Nice! I've marked this task as done:");
        taskList.markTaskAsDone(index);
    }

    // function to print action of mark task as undone
    public void printTaskUndone(int index) throws BambamException{
        System.out.println("OK, I've marked this task as not done yet:");
        taskList.markTaskAsUndone(index);
    }

    // Prints error message
    public void printErrorMessage(String error) {
        System.out.println("bambam.BambamException: " + error);
    }
}
