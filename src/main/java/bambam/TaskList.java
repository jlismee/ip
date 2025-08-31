package bambam;

import java.util.ArrayList;

import bambam.task.Task;

/**
 * Handles the array list of Task objects.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Gets number of tasks in the task list.
     * @return The size of the current task list.
     */
    public int getTaskSize() {
        return taskList.size();
    }

    /**
     * Gets Task object of a specific index.
     * @param index
     * @return The Task object.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public Task getTask(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            return taskList.get(index);
        }
    }

    /**
     * Adds Task object to the task list.
     * @param newTask The new task to be added to the task list.
     */
    public void addTaskToList(Task newTask) {
        taskList.add(newTask);
    }

    /**
     * Deletes Task object from the task list.
     * @param index The task index in the task list.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public void deleteTaskFromList(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            taskList.remove(index);
        }
    }

    /**
     * Marks Task object as done using index.
     * @param index The task index in the task list.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public void markTaskAsDone(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            Task task = getTask(index);
            task.markAsDone();
            System.out.println("    " + task.printTaskString() + "\n");
        }
    }

    /**
     * Marks Task objects as undone using index.
     * @param index The task index in the task list.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public void markTaskAsUndone(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            Task task = getTask(index);
            task.markAsUndone();
            System.out.println("    " + task.printTaskString() + "\n");
        }
    }

    /**
     * Handles the finding of Task objects with a specific keyword.
     * @param keyword The input word from users when finding specific task.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public void findTasks(String keyword) throws BambamException {
        for (int i = 0; i < getTaskSize(); i++) {
            int count = i + 1;
            String taskDescription = getTask(i).getTaskDescription();
            if (taskDescription.contains(keyword)) {
                System.out.println(count + "." + getTask(i).printTaskString());
            }
        }
    }

    /**
     * Prints list of Task objects.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public void printTaskList() throws BambamException {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < getTaskSize(); i++) {
            int count = i + 1;
            System.out.println(count + "." + getTask(i).printTaskString());
        }
    }
}
