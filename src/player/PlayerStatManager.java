package player;

import commands.*;
import player.*;

import java.util.*;

/**
 * Return the statistics of a player throughout the demanded years if statistics is specified, else return the
 * whole statistic information.
 */
public class PlayerStatManager implements Command {

    protected String playerName;
    protected String stat;
    protected List<String> seasons;

    public PlayerStatManager(String playerName, String stat, List<String> seasons) {
        this.playerName = playerName;
        this.stat = stat;
        this.seasons = seasons;
    }
    public PlayerStatManager(String playerName, List<String> seasons) {
        this.playerName = playerName;
        this.seasons = seasons;
    }

    public String execute() throws Exception {
        PlayerList p = new PlayerList();
        HashMap<String, List<HockeyPlayer>> playerMap = p.getPlayerMap();

        List<HockeyPlayer> listDemandedStat = new ArrayList<>();
        for (String season: playerMap.keySet()){
            if (this.seasons.contains(season)){
                for (HockeyPlayer playerInfo: playerMap.get(season)){
                    if (playerInfo.name.equals(this.playerName)){
                        listDemandedStat.add(playerInfo);
                    }
                }

            }
        }

        StringBuilder reportedStat = new StringBuilder();

        if (this.stat == null){ // if the demanded stat is not specified, return all the stat.
            for (HockeyPlayer demandedStat: listDemandedStat){
                reportedStat.append(demandedStat.toString());
            }
        }else{ // if the demanded stat is specified, return the season and the related stat.
            for (HockeyPlayer demandedStat: listDemandedStat){
                reportedStat.append(demandedStat.season).append(": ").append(demandedStat.getStat(this.stat));
            }
        }
        return reportedStat.toString();

    }

}
