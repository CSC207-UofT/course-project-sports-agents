package drivers_adapters;

public interface Presenter {

    String getInput();

    void presentOutput(String output);

    void closeOutput();

}
