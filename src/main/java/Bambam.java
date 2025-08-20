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
            String action = commands[0]; // action to be taken

            if (action.equals("list")) {
                messages.printTaskList(); // action is list -> print task list
            } else if (action.equals("mark")) {
                int taskNumber = Integer.parseInt(commands[1]); // action is mark
                messages.printTaskDone(taskNumber - 1);
            } else if (action.equals("unmark")) {
                int taskNumber = Integer.parseInt(commands[1]);
                messages.printTaskUndone(taskNumber - 1); // action is unmark
            } else {
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
