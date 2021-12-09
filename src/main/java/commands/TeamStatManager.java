package commands;

import constants.Exceptions;
import sports.Team;

import java.util.*;

/**
 * An abstract class to compute statistics for a single Player.
 * Each sport has a subclass handling that sport's statistics.
 */
public abstract class TeamStatManager implements Command {

    protected final Set<String> allowedStatsToGet;

    /**
     * @param allowedStatsToGet the statistics this StatManager can compute
     */
    public TeamStatManager(Set<String> allowedStatsToGet) {
        this.allowedStatsToGet = allowedStatsToGet;
    }

    /**
     * @param statistic a statistic name, to check if it can be computed
     * @throws Exception if the statistic cannot be computed
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToGet.contains(statistic.toLowerCase())) {
            throw new Exception(Exceptions.INVALID_STATISTIC);
        }
    }

    /**
     * Format the value of the statistic for display on the console
     *
     * @param team      the team the statistic is for
     * @param statName  the name for the demanded statistic
     * @param statValue the value of the statistic
     * @return the formatted output to display
     */
    protected <T extends Team> String formatStat(T team, String statName, String statValue) {
        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------------------------\n");
        builder.append(String.format("%10s %20s %n", "Team Name", statName));
        builder.append("-------------------------------------------\n");
        builder.append(String.format("%10s %10s %n", team.getName(), statValue));
        builder.append("-------------------------------------------");
        return builder.toString();
    }
}
