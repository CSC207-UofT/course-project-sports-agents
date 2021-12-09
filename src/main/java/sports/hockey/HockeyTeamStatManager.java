package sports.hockey;

import driversAdapters.DataContainer;
import commands.TeamStatManager;

import java.util.*;

public class HockeyTeamStatManager extends TeamStatManager {

    public HockeyTeamStatManager() {
        super(
                new HashSet<>(Arrays.asList("games played", "games won", "games lost", "overtime losses",
                        "points", "goals for", "goals against", "shots for per game",
                        "shots against per game", "faceoff win percentage")));
    }

    /**
     * Handle an argument requesting a player's statistics
     *
     * @param arguments A string array of form
     *                  {"Hockey", "team name", "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        HockeyTeam team = (HockeyTeam) container.getTeam("hockey", name);

        String season = arguments.get(2);
        System.out.println("executed");
        String statistic = arguments.get(3);
        checkStatistic(statistic);

        switch (statistic.toLowerCase()) {
            case "games played":
                return formatStat(team, statistic, team.getGamesPlayed(season).toString());
            case "games won":
                return formatStat(team, statistic, team.getGamesWon(season).toString());
            case "games lost":
                return formatStat(team, statistic, team.getGamesLost(season).toString());
            case "overtime losses":
                return formatStat(team, statistic, team.getOvertimeLosses(season).toString());
            case "points":
                return formatStat(team, statistic, team.getPoints(season).toString());
            case "goals for":
                return formatStat(team, statistic, team.getGoalsFor(season).toString());
            case "goals against":
                return formatStat(team, statistic, team.getGoalsAgainst(season).toString());
            case "shots for per game":
                return formatStat(team, statistic, team.getShotsPerGame(season).toString());
            case "shots against per game":
                return formatStat(team, statistic, team.getShotsAgainstPerGame(season).toString());
            case "faceoff win percentage":
                return formatStat(team, statistic, team.getFaceOffWinPercentage(season).toString());
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
