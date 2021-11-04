package commands;

import java.util.ArrayList;

import team.Team;
import team.TeamConstants;
import team.TeamManager;
import team.TeamStats;

public class TeamStatManager implements Command, TeamConstants {
    private TeamManager teamManager;
    private final int TEAM_NAME_SLOT = 0;
    private final int REQUESTED_STAT_SLOT = 1;
    private final String KEY_GAMES_PLAYED = "games played";
    private final String KEY_WINS = "wins";
    private final String KEY_LOSSES = "losses";
    private final String KEY_TIES = "ties";
    private final String KEY_WIN_RATE = "win rate";
    private final String KEY_LOSS_RATE = "loss rate";

    
    public TeamStatManager(TeamManager teamManager){
        this.teamManager = teamManager;
    }

    /**
     * Gets the stats for teams
     * @param teamName
     * @param teamStat
     * @return the stat for the specified team
     */
    public float getStat(String teamName, TeamStats teamStat){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            switch(teamStat){
                case GAMES_PLAYED:
                    return team.getTotalGamesPlayed();
                case WINS:
                    return team.getWins();
                case LOSSES:
                    return team.getLosses();
                case TIES:
                    return team.getTies();
                case WIN_RATE:
                    return calculateWinRate(team);
                case LOSS_RATE:
                    return calculateLossRate(team);
                default:
                    return -1;
            }
        }
        return -1;
    }

    private float calculateWinRate(Team team){
        if(team.getTotalGamesPlayed() == 0){
            return 0;
        }
        return (float) team.getWins() / team.getTotalGamesPlayed() * 100;
    }

    private float calculateLossRate(Team team){
        if(team.getTotalGamesPlayed() == 0){
            return 0;
        }
        return (float) team.getLosses() / team.getTotalGamesPlayed() * 100;
    }

    /**
     * Parses the input text into an enum
     * @param stat
     * @return If the stat exists returns enum, otherwise returns null
     */
    public TeamStats parseStat(String stat){
        switch(stat.toLowerCase()){
            case KEY_GAMES_PLAYED:
                return TeamStats.GAMES_PLAYED;
            case KEY_WINS:
                return TeamStats.WINS;
            case KEY_LOSSES:
                return TeamStats.LOSSES;
            case KEY_TIES:
                return TeamStats.TIES;
            case KEY_WIN_RATE:
                return TeamStats.WIN_RATE;
            case KEY_LOSS_RATE:
                return TeamStats.LOSS_RATE;
            default:
                return null;
        }
    }

    private String getAllStats(String teamName){
        String out = "";

        for(TeamStats ts : TeamStats.values()){
            out += ts.name() + ": " + getStat(teamName, ts) + ", ";
        }
        return out;
    }

    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String teamName = arguments.get(TEAM_NAME_SLOT);
        String requestedStat = arguments.get(REQUESTED_STAT_SLOT);

        if(requestedStat == KEY_ALL_STATS){
            return getAllStats(teamName);
        }else{
            TeamStats parsedStat = parseStat(requestedStat);
            
            if(parsedStat == null){
                throw new Exception("Stat does not exist");
            }
            return String.valueOf(getStat(teamName, parsedStat));
        }
    }
}
