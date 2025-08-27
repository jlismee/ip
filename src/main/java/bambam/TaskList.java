package bambam;

import bambam.task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    // function to get number of tasks
    public int getTaskSize() {
        return taskList.size();
    }

    // function to get task of a specific index
    public Task getTask(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            return taskList.get(index);
        }
    }

    // function to add task to the task list
    public void addTaskToList(Task newTask) {
        taskList.add(newTask);
    }

    // function to delete task from task list
    public void deleteTaskFromList(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            taskList.remove(index);
        }
    }

    // function mark task as done using index
    public void markTaskAsDone(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            Task task = getTask(index);
            task.markAsDone();
            System.out.println("    " + task.printTaskString() + "\n");
        }
    }

    // function mark task as undone using index
    public void markTaskAsUndone(int index) throws BambamException {
        if (index >= getTaskSize()) {
            throw new BambamException("Oopsies, this is a invalid bambam.task.Task Number");
        } else {
            Task task = getTask(index);
            task.markAsUndone();
            System.out.println("    " + task.printTaskString() + "\n");
        }
    }

    // function to print individual task status
    public void printTaskStatus(int index) throws BambamException {
        getTask(index).printTaskString();
    }

    // function to print list of tasks
    public void printTaskList() throws BambamException {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < getTaskSize(); i++) {
            int count = i + 1;
            System.out.println(count + "." + getTask(i).printTaskString());
        }
    }
}
