package commands;

import team.Team;
import team.TennisTeam;
import team.TeamManager;
import team.TeamStats;

public class TennisTeamStatManager extends TeamStatManager {
    public TennisTeamStatManager(TeamManager teamManager){
        super(teamManager);
    }

    public float getStat(String teamName, TeamStats teamStat) {
        float retrievedStat = super.getStat(teamName, teamStat);
        
        if(retrievedStat != -5 && retrievedStat != -1){
            return retrievedStat;
        }
        if(retrievedStat == -5){
            Team team = teamManager.findTeamWithName(teamName);
            if (team != null) {
                switch (teamStat) {
                    case TOTAL_TOURNAMENTS_PLAYED:
                        return ((TennisTeam) team).getTotalTournamentsPlayed();
                    case TOURNAMENT_WINS:
                        return ((TennisTeam) team).getTournamentWins();
                    default:
                        return -5;
                }
            }
        }
        return -1;
    }

    /**
     * Parses the input text into an enum
     *
     * @param stat stat being queried
     * @return If the stat exists returns enum, otherwise returns null
     */
    public TeamStats parseStat(String stat) {
        TeamStats retrieveStat = super.parseStat(stat);
        
        if(retrieveStat != null){
            return retrieveStat;
        }
        switch (stat.toLowerCase()) {
            case "tournaments played":
                return TeamStats.TOTAL_TOURNAMENTS_PLAYED;
            case "tournament wins":
                return TeamStats.TOURNAMENT_WINS;
            default:
                return null;
        }
    }
}
