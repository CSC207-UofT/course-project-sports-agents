package commands;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AvailableCommandsTest {

    @Test
    public void testAvailableCommands() throws Exception {
        String expected = "These are the available commands and their arguments in our app: \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "Keyword                                                                                                            Description \n" +
                          "\n" +
                          "Usage\n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "get_available_commands                                                                    get a list of all available commands \n" +
                          "\n" +
                          "Usage: get_available_commands \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "get_players_list                                                      get a list of available players for a sport and a season \n" +
                          "\n" +
                          "Usage: get_players_list --sport [sport] --season [season] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "get_sports                                                                           get a list of all of the sports available \n" +
                          "\n" +
                          "Usage: get_sports \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "get_stats                                                                 get a list of all of the stats available for a sport \n" +
                          "\n" +
                          "Usage: get_stats --sport [sport] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "search                                                                     search for a player with a similar name in the data \n" +
                          "\n" +
                          "Usage: search --player [incomplete player name] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "get_player_stat                                                                       get a given statistic for a given player \n" +
                          "\n" +
                          "Usage: get_player_stat --sport [sport] --player-name [player name] --season [season] --stat [stat] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "compare_player_stat                                                           compare two or more players based on a statistic \n" +
                          "\n" +
                          "Usage: compare_player_stat --sport [sport] --player-names [player 1] [player 2] ... --season [season] --stat [stat] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "predict_player_stat                                                   predict a player's performance based on past performance \n" +
                          "\n" +
                          "Usage: predict_player_stat --sport [sport] --player-name [player name] --seasons [season 1] [season 2] ... --stat [stat] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "get_team_stat                                                                           get a given statistic for a given team \n" +
                          "\n" +
                          "Usage: get_team_stat --sport [sport] --team-name [team name] --season [season] --stat [stat] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "add_member                                                                                 add a member to your fantasy league \n" +
                          "\n" +
                          "Usage: add_member --member-name [member name] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "create_match                                                                             create a match in your fantasy league \n" +
                          "\n" +
                          "Usage: create_match --match-name [match name] --team-1-name [team 1 name] --team-2-name [team 2 name] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "bet                                                                  bet on the outcome of a given match on behalf of a member \n" +
                          "\n" +
                          "Usage: bet --member-name [member name] --match-name [match name] --winner-name [winning team name] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "resolve_match                                                                   resolve a match based on the real-life outcome \n" +
                          "\n" +
                          "Usage: resolve_match --match-name [match name] --winner-name [winning team name] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "member_info                                                              get information about a member in your fantasy league \n" +
                          "\n" +
                          "Usage: member_info --member-name [member name] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "save                                                                                    save your fantasy league for later use \n" +
                          "\n" +
                          "Usage: save --path [file to save to] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n" +
                          "load                                                                        load the previous iteration of your fantasy league \n" +
                          "\n" +
                          "Usage: load --path [file to load from] \n" +
                          "-----------------------------------------------------------------------------------------------------------------------------\n";

        AvailableCommands availableCommands = new AvailableCommands();
        ArrayList<String> getAvailableCommands = new ArrayList<>();
        getAvailableCommands.add("get_available_commands");
        DataContainer dataContainer = new CSVDataContainer();
        assertEquals(expected,
                availableCommands.execute(getAvailableCommands, dataContainer));
    }

}