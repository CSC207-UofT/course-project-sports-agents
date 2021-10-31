package commands;

import player.*;

import java.util.*;

public class BaseballPlayerStatComparer implements Command{

    public BaseballPlayerStatComparer() {}

    /**
     *
     * @param arguments is a list of strings where ["player name 1", "player name2", ..., "stat", "season"]
     * @return the comparison between 2 or more player names based on the given stat in the given season.
     * @throws Exception when one or more player names is not found or the demanded stat is invalid.
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        List<String> playerNames = arguments.subList(0, arguments.size() - 2);
        String stat = arguments.get(arguments.size() - 2);
        String demandedSeason = arguments.get(arguments.size() - 1);

        // Throw exception for a list of statistics that are invalid for comparison
        ExceptionForInvalidStatsInComparison(stat);

        List<BaseballPlayer> listDemandedPlayers = getBaseballPlayersFromFile(playerNames, demandedSeason);

        return returnComparisonBasedOnStat(stat, listDemandedPlayers);

    }


    private String returnComparisonBasedOnStat(String stat, List<BaseballPlayer> listDemandedPlayers) throws Exception {
        StringBuilder compareToReturn = new StringBuilder("From min to max:\n");
        List<Integer> listDemandedStats = new ArrayList<>();

        for (BaseballPlayer player: listDemandedPlayers) {
            listDemandedStats.add(Integer.valueOf(player.getNeededStat(stat)));
        }
        Collections.sort(listDemandedStats);
        listDemandedPlayers.sort(new GetStatsComparator(stat));
        for(int j = 0; j < listDemandedPlayers.size(); ++j) {
            compareToReturn.append(listDemandedPlayers.get(j).name).append(": ").
                    append(listDemandedStats.get(j)).append(stat).append('\n');
        }

        return compareToReturn.toString();
    }

    private List<BaseballPlayer> getBaseballPlayersFromFile(List<String> playerNames,
                                                            String demandedSeason) throws Exception {

        BaseballPlayerList p = new BaseballPlayerList();
        HashMap<String, List<BaseballPlayer>> playerMap = p.getPlayerMap();
        List<BaseballPlayer> listDemandedPlayers = new ArrayList<>();

        for (String season: playerMap.keySet()){ // loop through the season and add demanded player.Player object to the list of
            // demanded players.
            if (season.equals(demandedSeason)){
                for (BaseballPlayer playerInfo: playerMap.get(season)){
                    if (playerNames.contains(playerInfo.name)){
                        listDemandedPlayers.add(playerInfo);
                    }

                }
            }
        }

        // throw exception if one or more players were not found.
        if (listDemandedPlayers.size() < playerNames.size()) {
            throw new Exception("One or more players not found!");}
        return listDemandedPlayers;
    }

    private void ExceptionForInvalidStatsInComparison(String stat) throws Exception {
        List<String> invalidStats = Arrays.asList( "name", "season", "team","position");
        if (invalidStats.contains(stat)){
            throw new Exception("Invalid statistic for comparison!");
        }
    }
}
