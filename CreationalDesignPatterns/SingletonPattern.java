import java.util.*;

class Singleton {
    // The private static instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Initialize any attributes here
    }

    // Public method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from the Singleton!");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        // Get the only object available
        Singleton singleton = Singleton.getInstance();

        // Show the message
        singleton.showMessage();
    }
}
