package Level1;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class UndoTest {

    @Test
    void test() {
        // Open terminal 1
        Undo terminal1 = Undo.getInstance();

        // Open terminal 2
        Undo terminal2 = Undo.getInstance();

        // Add command to terminal 1
        terminal1.addCommand("command A");

        // Remove last command in terminal 2
        terminal2.showCommandHistory();
        String deletedCommand = terminal2.undoCommand();

        // Terminal 2 removes command from terminal 1
        Assertions.assertEquals("command A", deletedCommand);
    }

    @Test
    void testShowHistory() {
        Undo undo = Undo.getInstance();
        undo.addCommand("ls");
        undo.showCommandHistory();
    }
}
