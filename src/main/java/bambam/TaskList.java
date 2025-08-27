package bambam;

import bambam.task.Task;

import java.util.ArrayList;

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
     * @return
     */
    public int getTaskSize() {
        return taskList.size();
    }

    /**
     * Gets Task object of a specific index.
     * @param index
     * @return
     * @throws BambamException
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
     * @param newTask
     */
    public void addTaskToList(Task newTask) {
        taskList.add(newTask);
    }

    /**
     * Deletes Task object from the task list.
     * @param index
     * @throws BambamException
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
     * @param index
     * @throws BambamException
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
     * @param index
     * @throws BambamException
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
     * Prints list of Task objects.
     * @throws BambamException
     */
    public void printList() throws BambamException {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < getTaskSize(); i++) {
            int count = i + 1;
            System.out.println(count + "." + getTask(i).printTaskString());
        }
    }
}
