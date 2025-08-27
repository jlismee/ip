package bambam.command;

import bambam.BambamException;
import bambam.Messages;
import bambam.TaskList;
import bambam.TaskStorage;
import bambam.task.Task;
import bambam.task.ToDos;

import java.io.IOException;

/**
 * Represents the todo command which is a type of Command.
 */
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
        storage.saveTasks(taskList);
    }
}
