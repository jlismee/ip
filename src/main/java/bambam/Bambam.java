package bambam;

import java.io.IOException;

import bambam.command.Command;

/**
 * Handles the main entry point of Bambam chatbot.
 */
public class Bambam {

    /**
     * Facilitates communication between user and the chatbot.
     * @param messages The UI interaction between the user and the chatbot.
     * @param storage The Storage that saves and loads Task objects.
     * @param taskList The current list of Task objects.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     * @throws IOException If an input or output operation fails.
     */
    public void communication(Messages messages, TaskStorage storage, TaskList taskList) throws BambamException, IOException {
        messages.printGreetings();
        Parser parser = new Parser();
        boolean isExit = false;

        while (!isExit) {
            String input = messages.getInput();
            try {
                Command command = parser.parse(input);
                command.execute(storage,messages,taskList);
                isExit = command.getIsExit();
            } catch (BambamException e) {
                messages.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * Handles the main method of the Bambam chatbot.
     * @param args The argument of Command-line
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     * @throws IOException If an input or output operation fails.
     */
    public static void main(String[] args) throws BambamException, IOException {
        Bambam bambam = new Bambam();
        TaskStorage taskStorage = new TaskStorage();
        TaskList taskList = taskStorage.loadTasks();
        Messages messages = new Messages(taskList);
        bambam.communication(messages, taskStorage, taskList);
    }
}
