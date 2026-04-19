package Level1;

public class App {
    public static void main(String[] args) {
        System.out.println("---- SINGLETON PATTERN ----");

        Undo undo = Undo.getInstance();
        undo.addCommand("mkdir folder");
        undo.addCommand("cd folder");

        // Output: mkdir folder, cd folder
        System.out.println("- The last command: ");
        undo.showCommandHistory();

        System.out.println("- Command removed: " + undo.undoCommand());

        // Output: mkdir folder
        System.out.print("- The last command: ");
        undo.showCommandHistory();

    }
}
