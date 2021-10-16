package SportsApp;

import java.util.Scanner;

public class SportsApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Hi! Welcome to our sports agent app");
        System.out.println("Currently, the following commands are available:");
        System.out.println("member_manager add_member <member_name>: adds a new member for your fantasy league");
        System.out.println("member_manager create_match <match_name> <team1_name> <team2_name>: create a match");
        System.out.println("member_manager bet <member_name> <match_name> <winner_name>: make a bet on a match on the behalf of a player");
        System.out.println("stats_player <player_name> <stat> <seasons>: get available data on a player of your choosing");
        System.out.println("stats_team <team_name>: get available data on a team of your choosing");
        System.out.println("Enter 'quit' to exit the program");
        // TODO: figure out how you want the arguments to be written, i.e. with "" or not
        // TODO: add the commands for the comparer

        Scanner inputScanner = new Scanner(System.in);
        String input = "";

        // TODO: Implement a catch statement
        commandManager manager = new commandManager();
        while (!input.equals("quit")) {
            input = inputScanner.nextLine();
            System.out.println(manager.execute(input));
        }
    }
}
