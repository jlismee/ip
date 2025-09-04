package bambam.command;

import java.io.IOException;

import bambam.BambamException;
import bambam.Messages;
import bambam.TaskList;
import bambam.TaskStorage;

/**
 * Represents the find command which is a type of Command.
 */
public class FindCommand extends Command {
    private String taskListString;
    private String keyword;

    public FindCommand(String keyword) {
        super(false);
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        taskListString = taskList.findTasks(keyword);
    }

    @Override
    public String getString() {
        return "Here are the matching tasks in your list:\n" +
                taskListString;

    }
}
