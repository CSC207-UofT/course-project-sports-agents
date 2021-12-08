package commands;

import constants.Exceptions;
import sports.Player;
import java.util.*;

/**
 * An abstract class to compute statistics for a single Player.
 * Each sport has a subclass handling that sport's statistics.
 */
public abstract class PlayerStatManager implements Command {

    protected final Set<String> allowedStatsToGet;

    /**
     * @param allowedStatsToGet the statistics this StatManager can compute
     */
    public PlayerStatManager(Set<String> allowedStatsToGet) {
        this.allowedStatsToGet = allowedStatsToGet;
    }

    /**
     * @param statistic a statistic name, to check if it can be computed
     * @throws Exception if the statistic cannot be computed
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToGet.contains(statistic)) {
            throw new Exception(Exceptions.INVALID_STATISTIC);
        }
    }

    /**
     * Format the value of the statistic for display on the console
     * @param player the Player the statistic is for
     * @param statName the name for the demanded statistic
     * @param statValue the value of the statistic
     * @return the formatted output to display
     */
    protected <T extends Player> String formatStat(T player, String statName, String statValue) {
        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------------------------\n");
        builder.append(String.format("%15s %20s %n", "Player Name", statName));
        builder.append("-------------------------------------------\n");
        builder.append(String.format("%15s %10s %n", player.getName(), statValue));
        builder.append("-------------------------------------------");
        return builder.toString();
    }
}
