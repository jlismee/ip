import java.io.IOException;

public class Bambam {

    // function to facilitate communication between user and the chatbot
    public void communication(Messages messages, TaskStorage storage, TaskList taskList) throws BambamException, IOException {
        messages.printGreetings();
        String input = messages.getInput(); // get input from user

        // if input is not bye, then continue asking for input until input is bye
        while (!input.equals("bye")) {
            String[] commands = input.split(" ", 2); // splitting the input into 2 parts in order to obtain the no. if relevant
            String action = commands[0];
            int taskNumber;// action to be taken

            switch (action) {
                case "list":
                    messages.printTaskList(); // action is list -> print task list
                    break;
                case "mark":
                    taskNumber = Integer.parseInt(commands[1]); // action is mark
                    messages.printTaskDone(taskNumber - 1);
                    storage.saveTask(taskList);
                    break;
                case "unmark":
                    taskNumber = Integer.parseInt(commands[1]);
                    messages.printTaskUndone(taskNumber - 1); // action is unmark
                    storage.saveTask(taskList);
                    break;
                case "todo":
                    if (commands.length < 2) {
                        throw new BambamException("Oopsies, description of todo can't be empty");
                    }
                    String taskDescription = commands[1];
                    Task todo = new ToDos(taskDescription);
                    messages.printAddTask(todo);
                    storage.saveTask(taskList);
                    break;
                case "deadline":
                    if (commands.length < 2) {
                        throw new BambamException("Oopsies, description of deadline can't be empty");
                    }
                    String[] deadlineDetails = commands[1].split(" /by ", 2);
                    if (deadlineDetails.length < 2) {
                        throw new BambamException("Oopsies, time details of deadline can't be empty");
                    }
                    Task deadline = new Deadlines(deadlineDetails[0], deadlineDetails[1]);
                    messages.printAddTask(deadline);
                    storage.saveTask(taskList);
                    break;
                case "event":
                    if (commands.length < 2) {
                        throw new BambamException("Oopsies, description of event can't be empty");
                    }
                    String[] eventDetails = commands[1].split(" /from ", 2);
                    if (eventDetails.length < 2) {
                        throw new BambamException("Oopsies, time details of event can't be empty");
                    }
                    String[] eventTimeDetails = eventDetails[1].split(" /to ", 2);
                    if (eventTimeDetails.length < 2) {
                        throw new BambamException("Oopsies, please provide full details of time of event");
                    }
                    Task event = new Events(eventDetails[0], eventTimeDetails[0], eventTimeDetails[1]);
                    messages.printAddTask(event);
                    storage.saveTask(taskList);
                    break;
                case "delete":
                    taskNumber = Integer.parseInt(commands[1]);
                    messages.printDeleteTask(taskNumber - 1);
                    storage.saveTask(taskList);
                    break;
                default:
                    throw new BambamException("Sorry I don't get what you're saying, please provide me with relevant tasks");
            }
            input = messages.getInput(); // get next input if current input is not bye
        }

        messages.printExit(); // if input is bye, it prints the exit message
    }

    public static void main(String[] args) throws BambamException, IOException {
        Bambam bambam = new Bambam();
        TaskStorage taskStorage = new TaskStorage();
        TaskList taskList = taskStorage.loadTasks();
        Messages messages = new Messages(taskList);
        bambam.communication(messages, taskStorage, taskList);
    }
}
