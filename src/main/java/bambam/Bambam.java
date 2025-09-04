package bambam;

import java.io.IOException;

import bambam.command.Command;

/**
 * Handles the main entry point of Bambam chatbot.
 */
public class Bambam {

    private String commandType;
    private TaskStorage storage;
    private TaskList taskList;
    private Messages messages;

    public Bambam() throws IOException, BambamException {
        storage = new TaskStorage();
        taskList = storage.loadTasks();
        messages = new Messages(taskList);
    }

    /**
     * Facilitates communication between user and the chatbot.
     * @throws BambamException If there is an error related to the passing of input or the chatbot.
     * @throws IOException If an input or output operation fails.
     */
    public void communication() throws BambamException, IOException {
        messages.printGreetings();
        Parser parser = new Parser();
        boolean isExit = false;

        while (!isExit) {
            String input = messages.getInput();
            try {
                Command command = parser.parse(input);
                command.execute(storage, messages, taskList);
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
        bambam.communication();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        Parser p = new Parser();
        try {
            Command c = p.parse(input);
            c.execute(storage, messages, taskList);
            commandType = c.getClass().getSimpleName();
            return c.getString();
        } catch (BambamException e) {
            return "Error: " + e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getCommandType() {
        return commandType;
    }
}
