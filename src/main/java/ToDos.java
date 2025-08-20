public class ToDos extends Task {

    public ToDos(String taskDescription) {
        super(taskDescription);
    }

    // function to get ToDos Task String
    @Override
    public String printTaskString() {
        return "[T]" + super.printTaskString();
    }
}

