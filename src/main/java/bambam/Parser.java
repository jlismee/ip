package bambam;

import bambam.command.ByeCommand;
import bambam.command.Command;
import bambam.command.DeadlineCommand;
import bambam.command.DeleteCommand;
import bambam.command.EventCommand;
import bambam.command.FindCommand;
import bambam.command.HelpCommand;
import bambam.command.ListCommand;
import bambam.command.MarkCommand;
import bambam.command.ToDoCommand;
import bambam.command.UnmarkCommand;

/**
 * Parses user input into executable commands.
 */
public class Parser {

    /**
     * Converts a fullCommand string into a Command object.
     * @param fullCommand The input string from users.
     * @return The Command object to execute.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     */
    public Command parse(String fullCommand) throws BambamException {
        assert (fullCommand != null && !fullCommand.isEmpty()) :
                "Input command must not be null or empty";

        String[] commands = fullCommand.split(" ", 2);

        String action = commands[0];
        int taskNumber; // action to be taken

        switch (action) {
        case "list":
            return new ListCommand();
        case "mark":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, please provide the task number to mark as done");
            }
            taskNumber = Integer.parseInt(commands[1]);
            return new MarkCommand(taskNumber);
        case "unmark":
            taskNumber = Integer.parseInt(commands[1]);
            return new UnmarkCommand(taskNumber);
        case "todo":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, description of todo can't be empty");
            }
            return new ToDoCommand(commands[1]);
        case "deadline":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, description of deadline can't be empty");
            }
            return new DeadlineCommand(commands[1]);
        case "event":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, description of event can't be empty");
            }
            return new EventCommand(commands[1]);
        case "delete":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, please provide the task number to mark as undone");
            }
            taskNumber = Integer.parseInt(commands[1]);
            return new DeleteCommand(taskNumber);
        case "find":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, please provide a valid keyword");
            }
            return new FindCommand(commands[1]);
        case "help":
            return new HelpCommand();
        case "bye":
            return new ByeCommand();
        default:
            throw new BambamException("Sorry I don't get what you're saying, " +
                    "please provide me with relevant tasks");
        }
    }
}
