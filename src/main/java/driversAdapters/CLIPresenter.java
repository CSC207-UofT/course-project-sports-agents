package driversAdapters;

import java.util.Scanner;

/**
 * Presenter for the Command line
 */
public class CLIPresenter implements Presenter {
    public final Scanner inputScanner;

    public CLIPresenter() {
        this.inputScanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return this.inputScanner.nextLine().toLowerCase();
    }

    @Override
    public boolean presentOutput(String output) {
        System.out.println(output);
        return true;
    }

    @Override
    public void closeOutput() {
        this.inputScanner.close();
    }
}
