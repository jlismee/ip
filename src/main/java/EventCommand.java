import java.io.IOException;

public class EventCommand extends Command{
    private final String taskDescription;

    public EventCommand(String taskDescription) {
        super(false);
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
       String[] eventDetails = taskDescription.split(" /from ", 2);
        if (eventDetails.length < 2) {
            throw new BambamException("Oopsies, time details of event can't be empty");
        }
        String[] eventTimeDetails = eventDetails[1].split(" /to ", 2);
        if (eventTimeDetails.length < 2) {
            throw new BambamException("Oopsies, please provide full details of time of event");
        }
        Task event = new Events(eventDetails[0], eventTimeDetails[0], eventTimeDetails[1]);
        messages.printAddTask(event);
        storage.saveTask(taskList);
    }
}
