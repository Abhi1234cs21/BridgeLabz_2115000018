class TextState {
    String text;
    TextState prev;
    TextState next;

    public TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {
    private TextState currentState;
    private int maxHistorySize;
    private int historySize;

    public TextEditor(int maxHistorySize) {
        this.currentState = null;
        this.maxHistorySize = maxHistorySize;
        this.historySize = 0;
    }

    public void typeText(String text) {
        TextState newState = new TextState(text);
        if (currentState == null) {
            currentState = newState;
        } else {
            if (historySize == maxHistorySize) {
                removeOldestState();
            }
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
            historySize++;
        }
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        }
    }

    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.text);
        } else {
            System.out.println("No text state available.");
        }
    }

    private void removeOldestState() {
        TextState temp = currentState;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        if (temp.next != null) {
            temp.next.prev = null;
            currentState = temp.next;
            historySize--;
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(3);

        editor.typeText("First Text");
        editor.displayCurrentState();

        editor.typeText("Second Text");
        editor.displayCurrentState();

        editor.typeText("Third Text");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.typeText("Fourth Text");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();
    }
}
