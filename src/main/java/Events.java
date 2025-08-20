public class Events extends Task{
    private String from;
    private String to;

    public Events(String taskDescription, String from, String to) {
        super(taskDescription);
        this.from = from;
        this.to = to;
    }

    // function to get Events Task String
    @Override
    public String printTaskString() {
        return "[E] " + super.printTaskString() + " (from: " + from + " to: " + to + ")";
    }
}
