public class Task {
    private String[] taskList;
    private int taskCounter;

    public Task() {
        this.taskList = new String[100];
        this.taskCounter = 0;
    }

    // function to add task to the task list
    public void addTaskToList(String task) {
        taskList[taskCounter] = task;
        taskCounter++;
    }

    // function to print list of tasks
    public void printList() {
        for (int i = 0; i < taskCounter; i++) {
            int count = i + 1;
            System.out.println(count + ". " + taskList[i]);
        }
    }
}
