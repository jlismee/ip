public class Deadlines extends Task{
    private String deadline;

    public Deadlines(String taskDescription, String deadline) {
        super(taskDescription);
        this.deadline = deadline;
    }

    // function to get Deadlines Task String
    @Override
    public String printTaskString() {
        return "[D]" + super.printTaskString() + " (by: " + deadline + ")";
    }
}
