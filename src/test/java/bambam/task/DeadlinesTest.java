package bambam.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlinesTest {
    @Test
    public void printTaskStringTest() {
        Deadlines deadline = new Deadlines("Return Book", "2025-01-01");
        String taskString = deadline.printTaskString();
        assertEquals("[D][ ] Return Book (by: Jan 1 2025)", taskString);
    }
}
