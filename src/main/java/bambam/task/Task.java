package bambam.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String taskDescription;
    private boolean isDone;
    private static final DateTimeFormatter DATE_TIME_INPUT_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter DATE_INPUT_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM d yyyy HHmm");
    private static final DateTimeFormatter DATE_OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM d yyyy");

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    // Returns dates and times in LocalDateTime
    public LocalDateTime getLocalDateTime(String dateTime) {
        String[] dateTimeDetails = dateTime.split(" ", 2);
        if (dateTimeDetails.length == 2) {
            return LocalDateTime.parse(dateTime, DATE_TIME_INPUT_FORMATTER);
        } else {
            LocalDate deadlineDate = LocalDate.parse(dateTime, DATE_INPUT_FORMATTER);
            return deadlineDate.atStartOfDay();
        }
    }

    // Returns LocalDateTime as Strings
    public String printLocalDateTime(LocalDateTime dateTime) {
        if (dateTime.toLocalTime().equals(LocalTime.MIDNIGHT)) {
            return dateTime.format(DATE_OUTPUT_FORMAT);
        } else {
            return dateTime.format(DATE_TIME_OUTPUT_FORMAT);
        }
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

    // Return string of the task to be saved in the hard disk
    public String taskStorageString() {
        return (isDone ? "Done" : "Not Done") + " | " + taskDescription;
    }

}
