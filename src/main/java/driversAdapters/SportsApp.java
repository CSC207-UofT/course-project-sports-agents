package driversAdapters;

public class SportsApp {

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to our sports agent app");
        System.out.println("Get started by typing the \"get_available_commands\" to see which commands are available");
        System.out.println("Please note that due to unforeseen circumstances the \"get_team_stat\" command is only available for hockey");

        System.out.println("Enter 'quit' to exit the program");

        Presenter presenter = new CLIPresenter();
        DataContainer container = new CSVDataContainer();

        CommandManager manager = new CommandManager();
        String input = presenter.getInput();
        while (!input.equals("quit")) {
            try {
                String output = manager.execute(input, container);
                presenter.presentOutput(output);
            }
            catch (Exception e) {
                presenter.presentOutput(e.getMessage());
            }
            input = presenter.getInput();
        }
        presenter.closeOutput();
    }
}
