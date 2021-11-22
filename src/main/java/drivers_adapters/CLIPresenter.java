package drivers_adapters;

import java.util.Scanner;

public class CLIPresenter implements Presenter {
    public Scanner inputScanner;

    public CLIPresenter() {
        this.inputScanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return this.inputScanner.nextLine();
    }

    @Override
    public void presentOutput(String output) {
        System.out.println(output);
    }

    @Override
    public void closeOutput() {
        this.inputScanner.close();
    }
}
