package commands;

import player.*;

import java.util.*;

/**
 * An abstract class to compute statistics for a single Player.
 * Each sport has a subclass handling that sport's statistics.
 */
public abstract class PlayerStatManager implements Command {
    protected PlayerList playerList;
    protected final Set<String> allowedStatsToGet;

    /**
     * @param playerList the Players this StatManager will get statistics for
     * @param allowedStatsToGet the statistics this StatManager can compute
     */
    public PlayerStatManager(PlayerList playerList,
                             Set<String> allowedStatsToGet) {
        this.playerList = playerList;
        this.allowedStatsToGet = allowedStatsToGet;
    }

    /**
     * @param statistic a statistic name, to check if it can be computed
     * @throws Exception if the statistic cannot be computed
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToGet.contains(statistic)) {
            throw new Exception("Cannot get Statistic " + statistic + "!");
        }
    }

    /**
     * Format the value of the statistic for display on the console
     * @param player the Player the statistic is for
     * @param statValue the value of the statistic
     * @return the formatted output to display
     */
    protected String formatStat(Player player, String statValue) {
        return player.getName() + ": " + statValue;
    }

    /*
    public PlayerStatManager() {}

     *
     * @param arguments is a list of strings where ["player name", "stat", "season 1", "season 2", ...] if
     *                  the user wants the report of a specific stat
     *                  OR ["player name", "all stats", "season 1", "season 2", ...] if the user wants the report of
     *                  all stats.
     * @return a string reporting the stat.
     * @throws Exception when the player name is not found or the demanded stat is invalid.
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String playerName = arguments.get(0);
        String stat = arguments.get(1);
        List<String> seasons = arguments.subList(2, arguments.size());
        PlayerList p = new PlayerList();
        HashMap<String, List<HockeyPlayer>> playerMap = p.getPlayerMap();

        List<HockeyPlayer> listDemandedStat = new ArrayList<>();
        for (String season: playerMap.keySet()){
            if (seasons.contains(season)){
                for (HockeyPlayer playerInfo: playerMap.get(season)){
                    if (playerInfo.name.equals(playerName)){
                        listDemandedStat.add(playerInfo);
                    }
                }

            }
        }

        if (listDemandedStat.isEmpty()){
            throw new Exception("player not found!");
        }

        StringBuilder reportedStat = new StringBuilder();

        if (stat.equals("all stats")){ // if the demanded stat is not specified, return all the stat.
            for (HockeyPlayer demandedStat: listDemandedStat){
                reportedStat.append(demandedStat.toString());
            }
        }else{ // if the demanded stat is specified, return the season and the related stat.
            for (HockeyPlayer demandedStat: listDemandedStat){
                reportedStat.append(demandedStat.season).append(": ").append(demandedStat.getStat(stat)).append(stat);
            }
        }
        return reportedStat.toString();

    }
    */


}
