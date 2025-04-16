import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

final class Messages {
    private final HashMap<String, String> map = new HashMap<>();
    private static initialized = false;

    private Messages() {

    }

    public static void initialize() {
        if (initialized) {
            return;
        }

        initialized = true;
        String[][] messages = {
            {"app-list-options", "1. Set\n2. Append\n3. Delete\n0. Back\n"},
            {"app-list-set-prompt-listname", "Name of list to set:"},
            {"app-list-set-prompt-data", "Enter data to set (ctrl + d (Linux) or ctrl + z (Windows) to stop):"},
            {"app-list-error-doesnotexist", "List {} does not exist\n"},
            {"app-error-invalidoption", "Error: \'{}\' is not a valid option"}
        };
        
        for (String[] kv : messages) {
            map.put(kv[0], kv[1]);
        }
    }

    public static String get(String name) {
        return map.get(name);
    }

    public static String get(String... args) {
        List<String> parts = Arrays.asList(args);
        return map.get(String.join("-", parts.toArray(new String[0])));
    }
}