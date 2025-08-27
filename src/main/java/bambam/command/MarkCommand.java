package bambam.command;

import bambam.BambamException;
import bambam.Messages;
import bambam.TaskList;
import bambam.TaskStorage;

import java.io.IOException;

/**
 * Represents the mark command which is a type of Command.
 */
public class MarkCommand extends Command {
    private final int taskNumber;

    public MarkCommand(int taskNumber) {
        super(false);
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        messages.printTaskDone(taskNumber - 1);
        storage.saveTask(taskList);
    }
}
