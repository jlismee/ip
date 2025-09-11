package bambam.command;

import java.io.IOException;

import bambam.BambamException;
import bambam.Messages;
import bambam.TaskList;
import bambam.TaskStorage;

public class HelpCommand extends Command {

    public HelpCommand() {
        super(false);
    }

    private String getHelpMessage() {
        return "User Guide to Bambam\n"
                + "\n"
                + "Commands you can use: \n"
                + " - list\n"
                + "     Show all tasks\n"
                + " - todo <desc>\n"
                + "     Add a todo task\n"
                + " - deadline <desc> /by <datetime>\n"
                + "     Add a deadline task\n"
                + " - event <desc> /from <datetime> /to <datetime>\n"
                + "     Add an event task\n"
                + " - mark <x>\n"
                + "     Mark task x as done\n"
                + " - unmark <x>\n"
                + "     Mark task x as undone\n"
                + " - delete <x>\n"
                + "     Delete task x\n"
                + " - find <keyword>\n"
                + "     Find task containing keyword\n"
                + " - help\n"
                + "     Obtain User Guide to Bambam\n"
                + "\n"
                + "Do note that for datetime, it should be given in the format of:\n"
                + "     Date Only -> yyyy-MM-dd\n"
                + "                 (eg: 2025-01-01)\n"
                + "     Date + Time -> yyyy-MM-dd HHmm\n"
                + "                 (eg: 2025-01-01 1800)\n";
    }

    @Override
    public void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException {
        messages.printHelpMessage(getHelpMessage());
    }

    @Override
    public String getString() {
        return getHelpMessage();
    }
}
