package bambam;

import java.util.Scanner;

import bambam.task.Task;

/**
 * Handles the printing of messages when interacting with users.
 */
public class Messages {
    public String CHATBOT_NAME = "bambam.Bambam"; // chatbot name is constant
    Scanner scanner = new Scanner(System.in); // Scanner for inputs from users
    private TaskList taskList;

    public Messages(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Prints greetings to users.
     */
    public void printGreetings() {
        System.out.println("Hello! I'm " + CHATBOT_NAME + "\n" +
                "What can I do for you?\n");
    }

    /**
     * Prints exit message to users.
     */
    public void printExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Gets input from users.
     * @return
     */
    public String getInput() {
        return scanner.nextLine();
    }

    /**
     * Prints details when adding Task object.
     * @param newTask
     */
    public void printAddTask(Task newTask) {
        taskList.addTaskToList(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("    " + newTask.printTaskString());
        System.out.println("Now you have " + taskList.getTaskSize() + " tasks in the list.\n");
    }

    /**
     * Prints details when deleting Task object.
     * @param index
     * @throws BambamException
     */
    public void printDeleteTask(int index) throws BambamException {
        Task task = taskList.getTask(index);
        taskList.deleteTaskFromList(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println("    " + task.printTaskString());
        System.out.println("Now you have " + taskList.getTaskSize() + " tasks in the list.\n");
    }

    /**
     * Prints list of Task objects.
     * @throws BambamException
     */
    public void printTaskList() throws BambamException {
        taskList.printTaskList();
        System.out.println();
    }

    /**
     * Prints action of marking Task object as done.
     * @param index
     * @throws BambamException
     */
    public void printTaskDone(int index) throws BambamException {
        System.out.println("Nice! I've marked this task as done:");
        taskList.markTaskAsDone(index);
    }

    /**
     * Prints action of marking Task object as undone.
     * @param index
     * @throws BambamException
     */
    public void printTaskUndone(int index) throws BambamException{
        System.out.println("OK, I've marked this task as not done yet:");
        taskList.markTaskAsUndone(index);
    }

    /**
     * Prints error message.
     * @param error
     */
    public void printErrorMessage(String error) {
        System.out.println("bambam.BambamException: " + error);
    }
}
