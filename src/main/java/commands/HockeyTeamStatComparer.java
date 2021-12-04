package commands;

import commands.TeamStatManager;
import commands.HockeyTeamStatManager;
import drivers_adapters.DataContainer;
import player.HockeyPlayer;
import player.HockeyPlayerComparator;
import team.HockeyTeam;
import team.TeamStats;

import java.util.*;

public class HockeyTeamStatComparer extends TeamStatComparer {

    public HockeyTeamStatComparer() {
        super(
                new HashSet<>(Arrays.asList("Games Played", "Goals",
                        "Assists", "Points", "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a comparison of two or more hockey
     * players' statistics. Players are returned in descending order
     * (best first, worst last)
     * @param arguments A string array of form
     *                  {"Hockey", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the players and their associated statistics
     * @throws Exception if a player does not exists, or lacks data for the
     * given season
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        int argSize = arguments.size();
        List<String> names = arguments.subList(1, argSize - 2);

        ArrayList<HockeyTeam> hockeyTeams = new ArrayList<>();
        for (String name: names) {
            hockeyTeams.add((HockeyTeam) container.getTeam("hockey", name));
        }

        String season = arguments.get(argSize - 2);

        String statistic = arguments.get(argSize - 1);
        checkStatistic(statistic);

        hockeyTeams.sort(new HockeyTeamComparator(statistic, season));
        Collections.reverse(hockeyTeams);
        List<String> playersStatValues = getStatValues(hockeyTeams,
                statistic, season);
        return formatCompare(hockeyTeams, statistic, playersStatValues);
    }

    /**
     * Collect the given statistic in the given season for all Teams in
     * the given list, maintaining order.
     * @param teams the list of Teams to collect statistics for
     * @param statistic the statistic to get
     * @param season the season to consider
     * @return the statistic for each player
     * @throws Exception if one or more statistics are not recorded
     */
    private List<String> getStatValues(List<HockeyTeam> teams,
                                       String statistic, String season)
            throws Exception {
        switch (statistic.toLowerCase()) {
            case "games played":
                return getValuesGamesPlayed(teams, season);
            case "points":
                return getValuesGoals(teams, season);
            case "games won":
                return getValuesAssists(teams, season);
            case "games lost":
                return getValuesPoints(teams, season);
            case "overtime losses":
                return getValuesShots(teams, season);
            case "goals for":
                return getValuesShootingPercentage(teams, season);
            case "goals against":
                null;
            case "shots per game":
                null;
            case "shots against per game":
                null;
            case "faceoff win percentage":
                null;
            default:
                throw new Exception("This shouldn't logically be thrown!");
        }
    }

    /**
     * Get the games played statistic in the given season for all passed players
     * @param players the list of Players to collect games played statistics for
     * @param season the season to consider
     * @return the games played statistics, for the list of players
     * @throws Exception if one player lacks the given season's games played data
     */
    private List<String> getValuesGamesPlayed(List<HockeyPlayer> players,
                                              String season) throws Exception{
        ArrayList<String> gamesPlayedValues = new ArrayList<>();
        for (HockeyPlayer player : players) {
            gamesPlayedValues.add(player.getStatGamesPlayed(season).toString());
        }
        return gamesPlayedValues;
    }

}
