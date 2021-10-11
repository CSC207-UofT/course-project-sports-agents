import java.util.*;

/**
 * A class for comparing two or more players based on a specific statistic in a specific season.
 */

public class PlayerStatComparer {
    protected String[] playerNames;
    protected String stat;
    protected String season;

    public PlayerStatComparer(String[] playerNames, String stat, String season) {
        this.playerNames = playerNames;
        this.stat = stat;
        this.season = season;
    }

    public StringBuilder compare() throws Exception {

        // Throw exception for a list of statistics that are invalid for comparison
        List<String> invalidStats = Arrays.asList( "name", "season", "team", "skater shoots","position");
        if (invalidStats.contains(this.stat)){
            throw new Exception("Invalid statistic for comparison!");
        }

        PlayerList p = new PlayerList();
        HashMap<String, List<Player>> playerMap = p.getPlayerMap();
        List<Player> listDemandedPlayers = new ArrayList<>();

        for (String season: playerMap.keySet()){ // loop through the season and add demanded Player object to the list of
                                                    // demanded players.
            if (season.equals(this.season)){
                for (Player playerInfo: playerMap.get(season)){
                    if (Arrays.asList(this.playerNames).contains(playerInfo.name)){
                        listDemandedPlayers.add(playerInfo);
                    }

                }
            }
        }

        // throw exception if one or more players were not found.
        if (listDemandedPlayers.size() < this.playerNames.length) {
            throw new Exception("One or more players not found!");}

        StringBuilder compareToReturn = new StringBuilder("From min to max:\n");
        List<Integer> listDemandedStats = new ArrayList<>();

        for (Player player: listDemandedPlayers) {
            listDemandedStats.add(Integer.valueOf(player.getStat(this.stat)));
        }
        Collections.sort(listDemandedStats);
        listDemandedPlayers.sort(new GetStatsComparator(this.stat));
        for(int j = 0; j < listDemandedPlayers.size(); ++j) {
            compareToReturn.append(listDemandedPlayers.get(j)).append(": ").
                    append(listDemandedStats.get(j)).append(this.stat).append('\n');
        }

        return compareToReturn;


        }
    }

