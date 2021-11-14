package commands;

import java.util.ArrayList;

import team.HockeyTeam;
import team.Team;
import team.TeamConstants;
import team.TeamManager;
import team.TeamStats;
import team.TennisTeam;

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
    private final String KEY_RANK = "rank";
    private final String KEY_TOURNAMENTS_PLAYED = "tournaments played";
    private final String KEY_TOURNAMENT_WINS = "tournament wins";
    private final String KEY_GOALS_FOR = "goals for";
    private final String KEY_GOALS_AGAINST = "goals against";
    private final String KEY_FACE_OFF_WIN_PERCENTAGE = "face off win percentage";
    private final String KEY_SHOTS_AGAINST = "shots against";
    private final String KEY_SHOTS_FOR = "shots for";
    private final String KEY_REGULATION_WINS = "regulation wins";
    private final String KEY_REGULATION_PLUS_OVERTIME_WINS = "regulation plus overtime wins played";
    private final String KEY_SHOOT_OUT_GAMES_WON = "shoot out games won";
    private final String KEY_OVERTIME_LOSSES = "overtime losses";
    
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
                    return calculateRate(team, team.getWins(), team.getTotalGamesPlayed());
                case LOSS_RATE:
                    return calculateRate(team, team.getLosses(), team.getTotalGamesPlayed());
                case RANK:
                    return team.getRank();
                case TOTAL_TOURNAMENTS_PLAYED:
                    return ((TennisTeam) team).getTotalTournamentsPlayed();
                case TOURNAMENT_WINS:
                    return ((TennisTeam) team).getTournamentWins();
                case GOALS_FOR:
                    return ((HockeyTeam) team).getGoalsFor(); 
                case GOALS_AGAINST:
                    return ((HockeyTeam) team).getGoalsAgainst();
                case FACE_OFF_WIN_PERCENTAGE:
                    return ((HockeyTeam) team).getFaceOffWinPercentage();
                case SHOTS_AGAINST: 
                    return ((HockeyTeam) team).getShotsAgainst();
                case SHOTS_FOR:
                    return ((HockeyTeam) team).getShotsFor();
                case REGULATION_WINS:
                    return ((HockeyTeam) team).getRegulationWins();
                case REGULATION_PLUS_OVERTIME_WINS:
                    return ((HockeyTeam) team).getRegulationPlusOvertimeWins();
                case SHOOT_OUT_GAMES_WON:
                    return ((HockeyTeam) team).getShootOutGamesWon();
                case OVERTIME_LOSSES:
                    return ((HockeyTeam) team).getOvertimeLosses();
                default:
                    return -5;
            }
        }
        return -1;
    }

    private float calculateRate(Team team, int numerator, int denominator){
        if(denominator == 0){
            return 0;
        }
        return (float) numerator / denominator * 100;
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
            case KEY_RANK:
                return TeamStats.RANK;
            case KEY_TOURNAMENTS_PLAYED:
                return TeamStats.TOTAL_TOURNAMENTS_PLAYED;
            case KEY_TOURNAMENT_WINS:
                return TeamStats.TOURNAMENT_WINS;
            case KEY_GOALS_FOR:
                return TeamStats.GOALS_FOR;
            case KEY_GOALS_AGAINST:
                return TeamStats.GOALS_AGAINST;
            case KEY_FACE_OFF_WIN_PERCENTAGE:
                return TeamStats.FACE_OFF_WIN_PERCENTAGE;
            case KEY_SHOTS_AGAINST:
                return TeamStats.SHOTS_AGAINST;
            case KEY_SHOTS_FOR:
                return TeamStats.SHOTS_FOR;
            case KEY_REGULATION_WINS:
                return TeamStats.REGULATION_WINS;
            case KEY_REGULATION_PLUS_OVERTIME_WINS:
                return TeamStats.REGULATION_PLUS_OVERTIME_WINS;
            case KEY_SHOOT_OUT_GAMES_WON:
                return TeamStats.SHOOT_OUT_GAMES_WON;
            case KEY_OVERTIME_LOSSES:
                return TeamStats.OVERTIME_LOSSES;
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
