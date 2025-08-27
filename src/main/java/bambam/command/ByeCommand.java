package bambam.command;

import bambam.*;

import java.io.IOException;

/**
 * Represents the bye command which is a type of Command.
 */
public class ByeCommand extends Command {

    public ByeCommand() {
        super(true);
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        messages.printExit();
    }
}
