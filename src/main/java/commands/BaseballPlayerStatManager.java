package commands;

import player.*;

import java.util.*;

public class BaseballPlayerStatManager implements Command{

    public BaseballPlayerStatManager(){}

    /**
     *
     * @param arguments is a list of strings where ["player name", "stat", "season 1", "season 2", ...] if
     *                  the user wants the report of a specific stat
     *                  OR ["player name", "all stats", "season 1", "season 2", ...] if the user wants the report of
     *                  all stats.
     * @return a string reporting the stat.
     * @throws Exception when the player name is not found or the demanded stat is invalid.
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String playerName = arguments.get(0);
        String stat = arguments.get(1);
        List<String> seasons = arguments.subList(2, arguments.size());

        List<BaseballPlayer> listDemandedStat = getBaseballPlayersFromFile(playerName, seasons);


        return returnStatOfPlayer(stat, listDemandedStat);

    }

    private String returnStatOfPlayer(String stat, List<BaseballPlayer> listDemandedStat) throws Exception {
        StringBuilder reportedStat = new StringBuilder();

        if (stat.equals("all stats")){ // if the demanded stat is not specified, return all the stat.
            for (BaseballPlayer demandedStat: listDemandedStat){
                reportedStat.append(demandedStat.toString());
            }
        }else{ // if the demanded stat is specified, return the season and the related stat.
            for (BaseballPlayer demandedStat: listDemandedStat){
                reportedStat.append(demandedStat.season).append(": ").append(demandedStat.getNeededStat(stat)).append(stat);
            }
        }
        return reportedStat.toString();
    }

    private List<BaseballPlayer> getBaseballPlayersFromFile(String playerName,
                                                            List<String> seasons) throws Exception {
        BaseballPlayerList b = new BaseballPlayerList();
        HashMap<String, List<BaseballPlayer>> playerMap = b.getPlayerMap();

        List<BaseballPlayer> listDemandedStat = new ArrayList<>();
        for (String season: playerMap.keySet()){
            if (seasons.contains(season)){
                for (BaseballPlayer playerInfo: playerMap.get(season)){
                    if (playerInfo.name.equals(playerName)){
                        listDemandedStat.add(playerInfo);
                    }
                }

            }
        }

        if (listDemandedStat.isEmpty()){
            throw new Exception("player not found!");
        }
        return listDemandedStat;
    }

}
