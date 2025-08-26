import java.io.IOException;

public abstract class Command {
    private boolean isExit;

    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    // Returns current status of isExit
    public boolean getIsExit() {
        return isExit;
    }

    public abstract void execute(TaskStorage storage, Messages messages, TaskList taskList)
            throws BambamException, IOException;
}
