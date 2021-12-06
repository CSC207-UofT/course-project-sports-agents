package commands;

import constants.Exceptions;
import player.Player;

import java.util.List;
import java.util.Set;

/**
 * An abstract class for comparing two or more players based on a specific statistic.
 * Each sport has a subclass handling that sport's statistic.
 */
public abstract class PlayerStatComparer implements Command {
    protected final Set<String> allowedStatsToCompare;

    public PlayerStatComparer(Set<String> allowedStatsToCompare) {
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
     * @param players the Players, sorted from best to worst stat
     * @param statName the name of the statistic that was used to compare
     * @param statValues the values corresponding to each Player
     * @return the formatted output to displayed
     */
    protected <T extends Player> String formatCompare(List<T> players, String statName,
                                                      List<String> statValues) {

        StringBuilder output = new StringBuilder();
        output.append("-----------------------------------------------------\n");
        output.append(String.format("%5s %20s %20s %n", "Rank", "Name", statName));
        output.append("-----------------------------------------------------\n");
        // Precondition: players.size() == statValues.size()
        for (int i = 0; i != players.size(); i += 1) {
            Player player = players.get(i);
//            output.append(player.getName());
//            output.append(": ");
//            output.append(statValues.get(i));
//            output.append("\n");
            output.append(String.format("%5s %20s %20s %n", i+1, player.getName(), statValues.get(i)));
        }
        return output.toString();
    }
}