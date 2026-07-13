import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Make this a thread-safe Singleton.
 * Requirements:
 *  - Private constructor
 *  - Static getInstance() that returns the same instance every time
 *  - Must be safe if two threads call getInstance() at the same time
 *  - Holds app settings in a Map<String,String>
 */
public class Singleton {

    // TODO: hold the single instance here (think about 'volatile')
    private static Singleton instance;

    private final Map<String, String> settings;

    private Singleton() {
        settings = new HashMap<>();
        settings.put("env", "dev");
    }

    public static Singleton getInstance() {
        // TODO: implement double-checked locking
        // if (instance == null) {
        //     synchronized (Singleton.class) {
        //         if (instance == null) {
        //             instance = new Singleton();
        //         }
        //     }
        // }
        return instance; // currently broken on purpose — fix me
    }

    public String get(String key) {
        return settings.get(key);
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }
}
