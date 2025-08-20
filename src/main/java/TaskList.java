public class TaskList {
    private Task[] taskList;
    private int taskCounter;

    public TaskList() {
        this.taskList = new Task[100];
        this.taskCounter = 0;
    }

    // function to add task to the task list
    public void addTaskToList(String task) {
        Task newTask = new Task(task);
        taskList[taskCounter] = newTask;
        taskCounter++;
    }

    // function to print list of tasks
    public void printList() {
        System.out.println("Here are the tasks in your list: ");
        for (int i = 0; i < taskCounter; i++) {
            int count = i + 1;
            System.out.println(count + "." + taskList[i].printTaskString());
        }
    }
}
