import java.util.Scanner;

public class SportsApp {

    public static void main(String[] args) {
        System.out.println("Hi! Welcome to our sports agent app");
        System.out.println("Current, the following commands are available:");
        System.out.println("add_member <member_name>: adds a new member for your fantasy league");
        System.out.println("bet <member_name> <match_name> <winner_name>: make a bet on a match on the behalf of a player");
        System.out.println("stats_player <player_name>: get available data on a player of your choosing");
        System.out.println("stats_team <team_name>: get available data on a team of your choosing");
        System.out.println("Enter 'quit' to exit the program");
        // TODO: figure out how you want the arguments to be written, i.e. with "" or not
        // TODO: add the commands for the comparer
        // TODO: change the CRC cards
        // TODO: clarify that the members are users

        Scanner inputScanner = new Scanner(System.in);
        String input = "";
//        commandManager = new CommandManager();
        // TODO: Implement a catch statement
        while (!input.equals("quit")) {
            input = inputScanner.nextLine();

        }
    }
}
