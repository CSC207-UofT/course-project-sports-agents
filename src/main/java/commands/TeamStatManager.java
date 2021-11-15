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
    private final String KEY_SHOTS_FOR = "shots for";
    private final String KEY_SHOTS_AGAINST = "shots against";
    private final String KEY_REGULATION_WINS = "regulation wins";
    private final String KEY_REGULATION_PLUS_OVERTIME_WINS = "regulation plus overtime wins played";
    private final String KEY_SHOOT_OUT_GAMES_WON = "shoot out games won";
    private final String KEY_OVERTIME_LOSSES = "overtime losses";
    private final String KEY_GOALS_FOR_PER_GAME_PLAYED = "goals for per game played";
    private final String KEY_GOALS_AGAINST_PER_GAME_PLAYED = "goals against per game played";
    private final String KEY_GAMES_STARTED = "games started";
    private final String KEY_COMPLETE_GAMES = "complete games";
    private final String KEY_SHUTOUTS = "shutouts";
    private final String KEY_SAVES = "saves";
    private final String KEY_SAVE_OPPORTUNITIES = "save opportunities";
    private final String KEY_INNINGS_PITCHED = "innings pitched";
    private final String KEY_RUNS_ALLOWED = "runs allowed";
    private final String KEY_EARNED_RUNS = "earned runs";
    private final String KEY_HOME_RUNS_ALLOWED = "home runs allowed";
    private final String KEY_HIT_BATSMEN = "hit batsmen";
    private final String KEY_AT_BATS = "at bats";
    private final String KEY_RUNS = "runs";
    private final String KEY_HITS = "hits";
    private final String KEY_DOUBLES = "doubles";
    private final String KEY_TRIPLES = "triples";
    private final String KEY_HOME_RUNS = "home runs";
    private final String KEY_RUN_BATTED_IN = "run batted in";
    private final String KEY_WALKS = "walks";
    private final String KEY_STRIKEOUTS = "strikeouts";
    private final String KEY_STOLEN_BASES = "stolen bases";
    private final String KEY_CAUGHT_STEALING = "caught stealing";

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
                return TeamStats.SHOOTOUT_GAMES_WON;
            case KEY_OVERTIME_LOSSES:
                return TeamStats.OVERTIME_LOSSES;
            case KEY_GOALS_FOR_PER_GAME_PLAYED:
                return TeamStats.GOALS_FOR_PER_GAMES_PLAYED;
            case KEY_GOALS_AGAINST_PER_GAME_PLAYED:
                return TeamStats.GOALS_AGAINST_PER_GAMES_PLAYED;
            case KEY_GAMES_STARTED:
                return TeamStats.GAMES_STARTED;
            case KEY_COMPLETE_GAMES:
                return TeamStats.COMPLETE_GAMES;
            case KEY_SHUTOUTS:
                return TeamStats.SHUTOUTS;
            case KEY_SAVES:
                return TeamStats.SAVES;
            case KEY_SAVE_OPPORTUNITIES:
                return TeamStats.SAVE_OPPORTUNITIES;
            case KEY_INNINGS_PITCHED:
                return TeamStats.INNINGS_PITCHED;
            case KEY_RUNS_ALLOWED:
                return TeamStats.RUNS_ALLOWED;
            case KEY_EARNED_RUNS:
                return TeamStats.EARNED_RUNS;
            case KEY_HOME_RUNS_ALLOWED:
                return TeamStats.HOME_RUNS_ALLOWED;
            case KEY_HIT_BATSMEN:
                return TeamStats.HIT_BATSMEN;
            case KEY_AT_BATS:
                return TeamStats.AT_BATS;
            case KEY_RUNS:
                return TeamStats.RUNS;
            case KEY_HITS:
                return TeamStats.HITS;
            case KEY_DOUBLES:
                return TeamStats.DOUBLES;
            case KEY_TRIPLES:
                return TeamStats.TRIPLES;
            case KEY_HOME_RUNS:
                return TeamStats.HOME_RUNS;
            case KEY_RUN_BATTED_IN:
                return TeamStats.RUN_BATTED_IN;
            case KEY_WALKS:
                return TeamStats.WALKS;
            case KEY_STRIKEOUTS:
                return TeamStats.STRIKEOUTS;
            case KEY_STOLEN_BASES:
                return TeamStats.STOLEN_BASES;
            case KEY_CAUGHT_STEALING:
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
