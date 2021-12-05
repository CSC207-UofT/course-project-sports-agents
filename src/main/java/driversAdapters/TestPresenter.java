package driversAdapters;

import java.util.ArrayList;

/**
 * Presenter for use in Test Cases
 */
public class TestPresenter implements Presenter {
    private final ArrayList<String> commandsToRun;
    private final ArrayList<String> expectedOut;
    private int curr_in;
    private int curr_out;

    public TestPresenter(ArrayList<String> commands,
                         ArrayList<String> expectedOut) {
        this.commandsToRun = commands;
        this.expectedOut = expectedOut;
        this.curr_in = 0;
        this.curr_out = 0;
    }

    @Override
    public String getInput() {
        String curr_command = commandsToRun.get(curr_in);
        curr_in += 1;
        return curr_command;
    }

    @Override
    public boolean presentOutput(String output) {
        boolean matches = (output.equals(expectedOut.get(curr_out)));
        curr_out += 1;
        return matches;
    }

    @Override
    public void closeOutput() {
    }
}
