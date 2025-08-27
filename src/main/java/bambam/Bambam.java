package bambam;

import bambam.command.Command;

import java.io.IOException;

public class Bambam {

    // function to facilitate communication between user and the chatbot
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

    public static void main(String[] args) throws BambamException, IOException {
        Bambam bambam = new Bambam();
        TaskStorage taskStorage = new TaskStorage();
        TaskList taskList = taskStorage.loadTasks();
        Messages messages = new Messages(taskList);
        bambam.communication(messages, taskStorage, taskList);
    }
}
