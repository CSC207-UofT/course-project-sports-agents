package commands;

import constants.Exceptions;
import team.Team;

import java.util.List;
import java.util.Set;


/**
 * An abstract class for comparing two or more players based on a specific statistic.
 * Each sport has a subclass handling that sport's statistic.
 */
public abstract class TeamStatComparer implements Command {
    protected final Set<String> allowedStatsToCompare;

    public TeamStatComparer(Set<String> allowedStatsToCompare) {
        this.allowedStatsToCompare = allowedStatsToCompare;
    }

    /**
     * @param statistic a statistic name, to check if it can be compared
     * @throws Exception if the statistic cannot be compared
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToCompare.contains(statistic)) {
            throw new Exception(Exceptions.INVALID_STATISTIC);
        }
    }

    /**
     * Format the comparisons for display on the console
     * @param teams the Teams, sorted from best to worst stat
     * @param statName the name of the statistic that was used to compare
     * @param statValues the values corresponding to each Player
     * @return the formatted output to displayed
     */
    protected <T extends Team> String formatCompare(List<T> teams, String statName,
                                                    List<String> statValues) {

        StringBuilder output = new StringBuilder();
        output.append("-----------------------------------------------------\n");
        output.append(String.format("%5s %20s %20s %n", "Rank", "Name", "Games Played"));
        output.append("-----------------------------------------------------\n");
        // Precondition: players.size() == statValues.size()
        for (int i = 0; i != teams.size(); i += 1) {
            Team team = teams.get(i);
            output.append(String.format("%5s %20s %20s %n", i+1, team.getName(), statValues.get(i)));
        }
        return output.toString();
    }
}