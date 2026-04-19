package Level1;

import java.util.ArrayList;

public class Undo {
    private static Undo instance;
    private final ArrayList<String> commandHistory = new ArrayList<>();

    private Undo() {}

    public static Undo getInstance(){
        if(instance == null){
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command){
        commandHistory.add(command);
    }

    public String undoCommand(){
        return commandHistory.removeLast();
    }

    public void showCommandHistory(){
        commandHistory.forEach(System.out::println);
    }
}
