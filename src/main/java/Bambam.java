public class Bambam {
    private Messages messages;

    public Bambam() {
        this.messages = new Messages();
    }

    // function to facilitate communication between user and the chatbot
    public void communication() {
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
                    break;
                case "unmark":
                    taskNumber = Integer.parseInt(commands[1]);
                    messages.printTaskUndone(taskNumber - 1); // action is unmark
                    break;
                case "todo":
                    String taskDescription = commands[1];
                    messages.printAddTask(new ToDos(taskDescription));
                    break;
                case "deadline":
                    String[] deadlineDetails = commands[1].split(" /by ", 2);
                    messages.printAddTask(new Deadlines(deadlineDetails[0], deadlineDetails[1]));
                    break;
                case "event":
                    String[] eventDetails = commands[1].split(" /from ", 2);
                    String[] eventTimeDetails = eventDetails[1].split(" /to ", 2);
                    messages.printAddTask(new Events(eventDetails[0], eventTimeDetails[0], eventTimeDetails[1]));
                    break;
                default:
                    messages.printInputs(input); // other input(task to be added)
            }
            input = messages.getInput(); // get next input if current input is not bye
        }

        messages.printExit(); // if input is bye, it prints the exit message
    }

    public static void main(String[] args) {
        Bambam bambam = new Bambam();
        bambam.communication();
    }
}
