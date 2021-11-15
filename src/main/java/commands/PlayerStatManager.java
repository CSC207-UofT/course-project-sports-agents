package commands;

import constants.Exceptions;
import player.PlayerList;
import player.Player;
import java.util.*;

/**
 * An abstract class to compute statistics for a single Player.
 * Each sport has a subclass handling that sport's statistics.
 */
public abstract class PlayerStatManager implements Command {
    protected PlayerList playerList;
    protected final Set<String> allowedStatsToGet;

    /**
     * @param playerList the Players this StatManager will get statistics for
     * @param allowedStatsToGet the statistics this StatManager can compute
     */
    public PlayerStatManager(PlayerList playerList,
                             Set<String> allowedStatsToGet) {
        this.playerList = playerList;
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
     * @param statValue the value of the statistic
     * @return the formatted output to display
     */
    protected <T extends Player> String formatStat(T player, String statValue) {
        return player.getName() + ": " + statValue;
    }
}
