public class DatabaseConnection {
    private boolean isConnected = false;

    public void connect() {
        isConnected = true;
        System.out.println("Database Connected.");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Database Disconnected.");
    }

    public boolean isConnected() {
        return isConnected;
    }
}
