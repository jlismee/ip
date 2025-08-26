import java.io.IOException;

public class ToDoCommand extends Command {
    private final String taskDescription;

    public ToDoCommand(String taskDescription) {
        super(false);
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        Task todo = new ToDos(taskDescription);
        messages.printAddTask(todo);
        storage.saveTask(taskList);
    }
}
