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

    // function mark task as done using index
    public void markTaskAsDone(int index) {
        if (index > taskCounter) {
            System.out.println("Invalid Task Number");
        } else {
            taskList[index].markAsDone();
            System.out.println(" " + taskList[index].printTaskString() + "\n");
        }
    }

    // function mark task as undone using index
    public void markTaskAsUndone(int index) {
        if (index > taskCounter) {
            System.out.println("Invalid Task Number");
        } else {
            taskList[index].markAsUndone();
            System.out.println(" " + taskList[index].printTaskString() + "\n");
        }
    }

    // function to print individual task status
    public void printTaskStatus(int index) {
        taskList[index].printTaskString();
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
