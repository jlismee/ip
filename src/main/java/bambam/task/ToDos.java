package bambam.task;

public class ToDos extends Task {

    public ToDos(String taskDescription) {
        super(taskDescription);
    }

    // function to get bambam.task.ToDos bambam.task.Task String
    @Override
    public String printTaskString() {
        return "[T]" + super.printTaskString();
    }

    // Return bambam.task.ToDos task string to be saved in the hard disk
    @Override
    public String taskStorageString() {
        return "T | " + super.taskStorageString();
    }
}

