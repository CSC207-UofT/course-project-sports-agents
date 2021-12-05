package driversAdapters;

public class SportsApp {

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to our sports agent app");
        System.out.println("Currently, the following commands are available:");
        System.out.println("member_manager add_member \"member_name\": adds a new member for your fantasy league");
        System.out.println("member_manager create_match \"match_name\" \"team1_name\" \"team2_name\": create a match");
        System.out.println("member_manager bet \"member_name\" \"match_name\" \"winner_name\": make a bet on a match on the behalf of a player");
        System.out.println("member_manager resolve_match \"match_name\" \"winning_team_name\": end a match, declare one team won, and update members based on bets");
        System.out.println("member_manager member_info \"member_name\": return information on a member");
        System.out.println("get_player_stat \"sport\" \"player_name\" \"seasons\" \"stat\": get available data on a player of your choosing");
        System.out.println("compare_player_stat \"sport\" \"player 1\" \"player 2\" ... \"player n\" \"seasons\" \"stat\": compare any players of your choosing");
        System.out.println("Examples of available players for hockey: Auston Matthews, Brad Marchand, Kirill Kaprizov");
        System.out.println("Examples of available statistics for hockey: Games Played, Assists, Shots, Shooting Percentage");
        System.out.println("Examples of available players for hockey: Whit Merrifield, Jose Abreu, Dansby Swanson");
        System.out.println("Examples of available statistics for hockey: Hits, Home Runs, Runs Batted In, Average");
        System.out.println("Example of a season: 2020-2021");
        System.out.println("Enter 'quit' to exit the program");

        Presenter presenter = new CLIPresenter();
        String input = "";
        DataContainer container = new CSVDataContainer();

        CommandManager manager = new CommandManager();
        while (!input.equals("quit")) {
            input = presenter.getInput();
            try {
                String output = manager.execute(input, container);
                presenter.presentOutput(output);
            }
            catch (Exception e) {
                presenter.presentOutput(e.getMessage());
            }
        }
        presenter.closeOutput();
    }
}
