import java.io.IOException;

public class DeleteCommand extends Command{
    private final int  taskNumber;

    public DeleteCommand(int taskNumber) {
        super(false);
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        messages.printDeleteTask(taskNumber - 1);
        storage.saveTask(taskList);
    }
}
