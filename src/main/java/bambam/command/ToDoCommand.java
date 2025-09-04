package bambam.command;

import java.io.IOException;

import bambam.BambamException;
import bambam.Messages;
import bambam.TaskList;
import bambam.TaskStorage;
import bambam.task.Task;
import bambam.task.ToDos;

/**
 * Represents the todo command which is a type of Command.
 */
public class ToDoCommand extends Command {
    private Task newToDo;
    private int taskListSize;
    private final String taskDescription;

    public ToDoCommand(String taskDescription) {
        super(false);
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        newToDo = new ToDos(taskDescription);
        taskList.addTaskToList(newToDo);
        taskListSize = taskList.getTaskSize();
        storage.saveTasks(taskList);
    }

    @Override
    public String getString() {
        return "Got it. I've added this task:\n" +
                "    " + newToDo.printTaskString() + "\n" +
                "Now you have " + taskListSize+ " tasks in the list.\n";
    }
}
