package bambam.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    private LocalDateTime from;
    private LocalDateTime to;
    private static final DateTimeFormatter DATE_TIME_FILE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    public Events(String taskDescription, String from, String to) {
        super(taskDescription);
        this.from = getLocalDateTime(from);
        this.to = getLocalDateTime(to);
    }

    // function to get bambam.task.Events bambam.task.Task String
    @Override
    public String printTaskString() {
        String fromString = printLocalDateTime(from);
        String toString = printLocalDateTime(to);
        return "[E]" + super.printTaskString() + " (from: " + fromString + " to: " + toString + ")";
    }

    // Return bambam.task.Events task string to be saved in the hard disk
    @Override
    public String taskStorageString() {
        String fromString = from.format(DATE_TIME_FILE_FORMAT);
        String toString = to.format(DATE_TIME_FILE_FORMAT);
        return "E | " + super.taskStorageString() + " | " + fromString + " to " + toString;
    }
}
