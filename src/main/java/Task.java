public class Task {
    private String taskDescription;
    private boolean isDone;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    // function to obtain the string to print depending on whether the task is completed
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    // function to print task
    public String printTaskString() {
        return "[" + getStatusIcon() + "] " + taskDescription;
    }

    // function to mark task as done
    public void markAsDone() {
        isDone = true;
    }

    // function to mark task as undone
    public void markAsUndone() {
        isDone = false;
    }

}
