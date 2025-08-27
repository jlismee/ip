package bambam.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    @Test
    public void markAsDoneTest() {
        Task todoTask = new ToDos("Return Book");
        todoTask.markAsDone();
        assertTrue(todoTask.getIsDone());
    }
}
