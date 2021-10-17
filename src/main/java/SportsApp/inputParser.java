package SportsApp;

import java.util.ArrayList;
import java.util.List;

public class inputParser {

    private final String keyword;
    private final ArrayList<String> arguments = new ArrayList<String>();

    public inputParser(String input) {
        String[] parts = input.split(" ", 2);
        keyword = parts[0];
        String rest = parts[1];
        int curr_index = 0;
        while (curr_index < rest.length()) {
            char curr_character = rest.charAt(curr_index);
            if (curr_character == '"') {
                int sub_index = curr_index + 1;
                boolean found = false;
                while (!found) {
                    char sub_character = rest.charAt(sub_index);
                    if (sub_character == '"') {
                        found = true;
                        arguments.add(rest.substring(curr_index, sub_index + 1));
                        curr_index = sub_index + 2;
                    }
                    else {
                        sub_index++;
                    }
                }

            } else {
                curr_index++;
            }
        }
        trimArguments();
    }

    private void trimArguments() {
        for (int i = 0; i < arguments.size(); i++) {
            String argument = arguments.get(i);
            arguments.set(i, argument.substring(1 , argument.length() - 1));
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }
}
