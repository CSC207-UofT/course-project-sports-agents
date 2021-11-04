package commands;

import player.PlayerList;
import player.Player;

import java.util.List;
import java.util.Set;

/**
 * An abstract class for comparing two or more players based on a specific statistic.
 * Each sport has a subclass handling that sport's statistic.
 */
public abstract class PlayerStatComparer implements Command {
    protected PlayerList<?> playerList;
    protected final Set<String> allowedStatsToCompare;

    public PlayerStatComparer(PlayerList playerList,
                              Set<String> allowedStatsToCompare) {
        this.playerList = playerList;
        this.allowedStatsToCompare = allowedStatsToCompare;
    }

    /**
     * @param statistic a statistic name, to check if it can be compared
     * @throws Exception if the statistic cannot be compared
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToCompare.contains(statistic)) {
            throw new Exception("Cannot compare Statistic " + statistic + "!");
        }
    }

    /**
     * Format the comparisons for display on the console
     * @param players the Players, sorted from best to worst stat
     * @param statValues the values corresponding to each Player
     * @return the formatted output to displayed
     */
    protected <T extends Player> String formatCompare(List<T> players,
                                                      List<String> statValues) {
        StringBuilder output = new StringBuilder("From best to worst:\n");
        // Precondition: players.size() == statValues.size()
        for (int i = 0; i != players.size(); i += 1) {
            Player player = players.get(i);
            output.append(player.getName());
            output.append(": ");
            output.append(statValues.get(0));
            output.append("\n");
        }
        return output.toString();
    }



    /*
    public PlayerStatComparer() {}
     *
     * @param arguments is a list of strings where ["player name 1", "player name2", ..., "stat", "season"]
     * @return the comparison between 2 or more player names based on the given stat in the given season.
     * @throws Exception when one or more player names is not found or the demanded stat is invalid.
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        List<String> playerNames = arguments.subList(0, arguments.size() - 2);
        String stat = arguments.get(arguments.size() - 2);
        String demandedSeason = arguments.get(arguments.size() - 1);

        // Throw exception for a list of statistics that are invalid for comparison
        List<String> invalidStats = Arrays.asList( "name", "season", "team", "skater shoots","position");
        if (invalidStats.contains(stat)){
            throw new Exception("Invalid statistic for comparison!");
        }

        PlayerList p = new PlayerList();
        HashMap<String, List<HockeyPlayer>> playerMap = p.getPlayerMap();
        List<HockeyPlayer> listDemandedPlayers = new ArrayList<>();

        for (String season: playerMap.keySet()){ // loop through the season and add demanded player.Player object to the list of
                                                    // demanded players.
            if (season.equals(demandedSeason)){
                for (HockeyPlayer playerInfo: playerMap.get(season)){
                    if (playerNames.contains(playerInfo.name)){
                        listDemandedPlayers.add(playerInfo);
                    }

                }
            }
        }

        // throw exception if one or more players were not found.
        if (listDemandedPlayers.size() < playerNames.size()) {
            throw new Exception("One or more players not found!");}

        StringBuilder compareToReturn = new StringBuilder("From min to max:\n");
        List<Integer> listDemandedStats = new ArrayList<>();

        for (HockeyPlayer player: listDemandedPlayers) {
            listDemandedStats.add(Integer.valueOf(player.getStat(stat)));
        }
        Collections.sort(listDemandedStats);
        listDemandedPlayers.sort(new GetStatsComparator(stat));
        for(int j = 0; j < listDemandedPlayers.size(); ++j) {
            compareToReturn.append(listDemandedPlayers.get(j).name).append(": ").
                    append(listDemandedStats.get(j)).append(stat).append('\n');
        }

        return compareToReturn.toString();


        }
     */

}

