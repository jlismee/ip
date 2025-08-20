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
            messages.printInputs(input);
            input = messages.getInput();
        }
        messages.printExit(); // if input is bye, it prints the exit message
    }

    public static void main(String[] args) {
        Bambam bambam = new Bambam();
        bambam.communication();
    }
}
