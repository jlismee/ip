package bambam.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Task object with its description and isDone status.
 */
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

    /**
     * Returns dates and times of Task objects in LocalDateTime.
     * @param dateTime The string of date and time provided by users.
     * @return The date and time provided by users in string in LocalDateTime.
     */
    public LocalDateTime getLocalDateTime(String dateTime) {
        String[] dateTimeDetails = dateTime.split(" ", 2);
        if (dateTimeDetails.length == 2) {
            return LocalDateTime.parse(dateTime, DATE_TIME_INPUT_FORMATTER);
        } else {
            LocalDate deadlineDate = LocalDate.parse(dateTime, DATE_INPUT_FORMATTER);
            return deadlineDate.atStartOfDay();
        }
    }

    /**
     * Returns dates and times of Task objects in LocalDateTime as Strings.
     * @param dateTime
     * @return The string of date and time in LocalDateTime.
     */
    public String printLocalDateTime(LocalDateTime dateTime) {
        if (dateTime.toLocalTime().equals(LocalTime.MIDNIGHT)) {
            return dateTime.format(DATE_OUTPUT_FORMAT);
        } else {
            return dateTime.format(DATE_TIME_OUTPUT_FORMAT);
        }
    }

    /**
     * Returns String to print depending on whether the Task object is done.
     * @return The string of done or undone.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns isDone boolean.
     * @return The isDone boolean.
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Returns taskDescription string.
     * @return The string of the task description.
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Returns the Task String to be printed.
     * @return The string of a task to be printed in the list.
     */
    public String printTaskString() {
        return "[" + getStatusIcon() + "] " + taskDescription;
    }

    /**
     * Handles the marking of Task object as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Handles the marking of Task object as undone.
     */
    public void markAsUndone() {
        isDone = false;
    }

    /**
     * Returns the string of the Task object ot be saved in the hard disk.
     * @return The string of a task to be stored in the task storage.
     */
    public String taskStorageString() {
        return (isDone ? "Done" : "Not Done") + " | " + taskDescription;
    }

}
