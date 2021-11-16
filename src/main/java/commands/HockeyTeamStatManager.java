package commands;

import team.Team;
import team.HockeyTeam;
import team.TeamManager;
import team.TeamStats;

public class HockeyTeamStatManager extends TeamStatManager {
    public HockeyTeamStatManager(TeamManager teamManager){
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
                    case GOALS_FOR:
                        return ((HockeyTeam) team).getGoalsFor();
                    case GOALS_AGAINST:
                        return ((HockeyTeam) team).getGoalsAgainst();
                    case FACE_OFF_WIN_PERCENTAGE:
                        return ((HockeyTeam) team).getFaceOffWinPercentage();
                    case SHOTS_FOR:
                        return ((HockeyTeam) team).getShotsFor();
                    case SHOTS_AGAINST:
                        return ((HockeyTeam) team).getShotsAgainst();
                    case REGULATION_WINS:
                        return ((HockeyTeam) team).getRegulationWins();
                    case REGULATION_PLUS_OVERTIME_WINS:
                        return ((HockeyTeam) team).getRegulationPlusOvertimeWins();
                    case SHOOTOUT_GAMES_WON:
                        return ((HockeyTeam) team).getShootoutGamesWon();
                    case OVERTIME_LOSSES:
                        return ((HockeyTeam) team).getOvertimeLosses();
                    case SHOTS_FOR_PER_GAMES_PLAYED:
                        return calculateRate(team, ((HockeyTeam) team).getShotsFor(), team.getTotalGamesPlayed());
                    case SHOTS_AGAINST_PER_GAMES_PLAYED:
                        return calculateRate(team, ((HockeyTeam) team).getShotsAgainst(), team.getTotalGamesPlayed());
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
            case "goals for":
                return TeamStats.GOALS_FOR;
            case "goals against":
                return TeamStats.GOALS_AGAINST;
            case "face off win percentage":
                return TeamStats.FACE_OFF_WIN_PERCENTAGE;
            case "shots against":
                return TeamStats.SHOTS_AGAINST;
            case "shots for":
                return TeamStats.SHOTS_FOR;
            case "regulation wins":
                return TeamStats.REGULATION_WINS;
            case "regulation plus overtime wins played":
                return TeamStats.REGULATION_PLUS_OVERTIME_WINS;
            case "shoot out games won":
                return TeamStats.SHOOTOUT_GAMES_WON;
            case "overtime losses":
                return TeamStats.OVERTIME_LOSSES;
            case "goals for per game played":
                return TeamStats.GOALS_FOR_PER_GAMES_PLAYED;
            case "goals against per game played":
                return TeamStats.GOALS_AGAINST_PER_GAMES_PLAYED;
            default:
                return null;
        }
    }
}
