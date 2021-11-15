package commands;

import java.util.ArrayList;

import team.BaseballTeam;
import team.HockeyTeam;
import team.Team;
import team.TeamConstants;
import team.TeamManager;
import team.TeamStats;
import team.TennisTeam;

public class TeamStatManager implements Command, TeamConstants {
    private final TeamManager teamManager;
    private final int TEAM_NAME_SLOT = 0;
    private final int REQUESTED_STAT_SLOT = 1;

    public TeamStatManager(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    /**
     * Gets the stats for teams
     *
     * @param teamName name of team being queried
     * @param teamStat stat being queried
     * @return the stat for the specified team
     */
    public float getStat(String teamName, TeamStats teamStat) {
        Team team = teamManager.findTeamWithName(teamName);
        if (team != null) {
            switch (teamStat) {
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
                case GAMES_STARTED:
                    return ((BaseballTeam) team).getGamesStarted();
                case COMPLETE_GAMES:
                    return ((BaseballTeam) team).getCompleteGames();
                case SHUTOUTS:
                    return ((BaseballTeam) team).getShutouts();
                case SAVES:
                    return ((BaseballTeam) team).getSaves();
                case SAVE_OPPORTUNITIES:
                    return ((BaseballTeam) team).getSaveOpportunities();
                case INNINGS_PITCHED:
                    return ((BaseballTeam) team).getInningsPitched();
                case RUNS_ALLOWED:
                    return ((BaseballTeam) team).getRunsAllowed();
                case EARNED_RUNS:
                    return ((BaseballTeam) team).getEarnedRuns();
                case HOME_RUNS_ALLOWED:
                    return ((BaseballTeam) team).getHomeRunsAllowed();
                case HIT_BATSMEN:
                    return ((BaseballTeam) team).getHitBatsmen();
                case AT_BATS:
                    return ((BaseballTeam) team).getAtBats();
                case RUNS:
                    return ((BaseballTeam) team).getRuns();
                case HITS:
                    return ((BaseballTeam) team).getHits();
                case DOUBLES:
                    return ((BaseballTeam) team).getDoubles();
                case TRIPLES:
                    return ((BaseballTeam) team).getTriples();
                case HOME_RUNS:
                    return ((BaseballTeam) team).getHomeRuns();
                case RUN_BATTED_IN:
                    return ((BaseballTeam) team).getRunBattedIn();
                case WALKS:
                    return ((BaseballTeam) team).getWalks();
                case STRIKEOUTS:
                    return ((BaseballTeam) team).getStrikeouts();
                case STOLEN_BASES:
                    return ((BaseballTeam) team).getStolenBases();
                case CAUGHT_STEALING:
                    return ((BaseballTeam) team).getCaughtStealing();
                default:
                    return -5;
            }
        }
        return -1;
    }

    private float calculateRate(Team team, int numerator, int denominator) {
        if (denominator == 0) {
            return 0;
        }
        return (float) numerator / denominator * 100;
    }

    /**
     * Parses the input text into an enum
     *
     * @param stat stat being queried
     * @return If the stat exists returns enum, otherwise returns null
     */
    public TeamStats parseStat(String stat) {
        switch (stat.toLowerCase()) {
            case "games played":
                return TeamStats.GAMES_PLAYED;
            case "wins":
                return TeamStats.WINS;
            case "losses":
                return TeamStats.LOSSES;
            case "ties":
                return TeamStats.TIES;
            case "win rate":
                return TeamStats.WIN_RATE;
            case "loss rate":
                return TeamStats.LOSS_RATE;
            case "rank":
                return TeamStats.RANK;
            case "tournaments played":
                return TeamStats.TOTAL_TOURNAMENTS_PLAYED;
            case "tournament wins":
                return TeamStats.TOURNAMENT_WINS;
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
            case "games started":
                return TeamStats.GAMES_STARTED;
            case "complete games":
                return TeamStats.COMPLETE_GAMES;
            case "shutouts":
                return TeamStats.SHUTOUTS;
            case "saves":
                return TeamStats.SAVES;
            case "save opportunities":
                return TeamStats.SAVE_OPPORTUNITIES;
            case "innings pitched":
                return TeamStats.INNINGS_PITCHED;
            case "runs allowed":
                return TeamStats.RUNS_ALLOWED;
            case "earned runs":
                return TeamStats.EARNED_RUNS;
            case "home runs allowed":
                return TeamStats.HOME_RUNS_ALLOWED;
            case "hit batsmen":
                return TeamStats.HIT_BATSMEN;
            case "at bats":
                return TeamStats.AT_BATS;
            case "runs":
                return TeamStats.RUNS;
            case "hits":
                return TeamStats.HITS;
            case "doubles":
                return TeamStats.DOUBLES;
            case "triples":
                return TeamStats.TRIPLES;
            case "home runs":
                return TeamStats.HOME_RUNS;
            case "run batted in":
                return TeamStats.RUN_BATTED_IN;
            case "walks":
                return TeamStats.WALKS;
            case "strikeouts":
                return TeamStats.STRIKEOUTS;
            case "stolen bases":
                return TeamStats.STOLEN_BASES;
            case "caught stealing":
                return TeamStats.CAUGHT_STEALING;
            default:
                return null;
        }
    }

    private String getAllStats(ArrayList<String> arguments, String teamName) {
        StringBuilder out = new StringBuilder();
        out.append(arguments.get(TEAM_NAME_SLOT));
        out.append("\n");

        for (TeamStats ts : TeamStats.values()) {
            out.append(ts.name());
            out.append(": ");
            out.append(getStat(teamName, ts));
            out.append("\n");
        }
        return out.toString();
    }

    private String formatOut(ArrayList<String> arguments, float stat) {
        return arguments.get(REQUESTED_STAT_SLOT) +
               stat +
               "\n";
    }

    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String teamName = arguments.get(TEAM_NAME_SLOT);
        String requestedStat = arguments.get(REQUESTED_STAT_SLOT);

        if (requestedStat.equals(KEY_ALL_STATS)) {
            return getAllStats(arguments, teamName);
        } else {
            TeamStats parsedStat = parseStat(requestedStat);

            if (parsedStat == null) {
                throw new Exception("Stat does not exist");
            }
            return formatOut(arguments, getStat(teamName, parsedStat));
        }
    }
}