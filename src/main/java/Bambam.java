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
            if (input.equals("list")) {
                messages.printTaskList(); // input is list -> print task list
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
