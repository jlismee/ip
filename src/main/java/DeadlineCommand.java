import java.io.IOException;

public class DeadlineCommand extends Command {
    private final String taskDescription;

    public DeadlineCommand(String taskDescription) {
        super(false);
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        String[] deadlineDetails = taskDescription.split(" /by ", 2);
        if (deadlineDetails.length < 2) {
            throw new BambamException("Oopsies, time details of deadline can't be empty");
        }
        Task deadline = new Deadlines(deadlineDetails[0], deadlineDetails[1]);
        messages.printAddTask(deadline);
        storage.saveTask(taskList);
    }
}
