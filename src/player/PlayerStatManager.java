package player;

import commands.*;
import player.*;

import java.util.*;

/**
 * Return the statistics of a player throughout the demanded years if statistics is specified, else return the
 * whole statistic information.
 */
public class PlayerStatManager implements Command {

    public PlayerStatManager(){}

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


}
