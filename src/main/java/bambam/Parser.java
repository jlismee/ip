package bambam;

import bambam.command.*;

public class Parser {

    public Command parse(String fullCommand) throws BambamException {
        String[] commands = fullCommand.split(" ", 2);
        String action = commands[0];
        int taskNumber; // action to be taken

        switch (action) {
        case "list":
            return new ListCommand();
        case "mark":
            if (commands.length < 2) {
                throw new BambamException("Oopsies, please provide the task number " +
                        "to be marked as done");
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
                throw new BambamException("Oopsies, please provide the task number " +
                        "to mark as undone");
            }
            taskNumber = Integer.parseInt(commands[1]);
            return new DeleteCommand(taskNumber);
        case "bye":
            return new ByeCommand();
        default:
            throw new BambamException("Sorry I don't get what you're saying, " +
                    "please provide me with relevant tasks");
        }
    }
}
