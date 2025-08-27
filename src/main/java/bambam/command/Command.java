package bambam.command;

import bambam.BambamException;
import bambam.Messages;
import bambam.TaskList;
import bambam.TaskStorage;

import java.io.IOException;

/**
 * Represents the commands given by users.
 */
public abstract class Command {
    private boolean isExit;

    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    /**
     * Returns the current status of isExit.
     * @return
     */
    public boolean getIsExit() {
        return isExit;
    }

    /**
     * Handles the execution of commands.
     * @param storage
     * @param messages
     * @param taskList
     * @throws BambamException
     * @throws IOException
     */
    public abstract void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException;
}
