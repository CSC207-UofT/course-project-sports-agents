package commands;

import java.util.ArrayList;

import drivers_adapters.DataContainer;
import team.Team;
import team.TeamConstants;
import team.TeamManager;
import team.TeamStats;

public abstract class TeamStatManager implements Command, TeamConstants {
    protected final TeamManager teamManager;
    protected final int TEAM_NAME_SLOT = 1;
    protected final int REQUESTED_STAT_SLOT = 2;

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
                default:
                    return -5;
            }
        }
        return -1;
    }

    protected float calculateRate(Team team, int numerator, int denominator) {
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
            default:
                return null;
        }
    }

    protected String getAllStats(ArrayList<String> arguments, String teamName) {
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

    protected String formatOut(ArrayList<String> arguments, float stat) {
        return arguments.get(REQUESTED_STAT_SLOT) +
               stat +
               "\n";
    }

    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
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