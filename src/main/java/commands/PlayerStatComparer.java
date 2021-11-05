package commands;

import player.PlayerList;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * An abstract class for comparing two or more players based on a specific statistic.
 * Each sport has a subclass handling that sport's statistic.
 */
public abstract class PlayerStatComparer implements Command {
    protected PlayerList<?> playerList;
    protected final Set<String> allowedStatsToCompare;

    public PlayerStatComparer(PlayerList playerList,
                              Set<String> allowedStatsToCompare) {
        this.playerList = playerList;
        this.allowedStatsToCompare = allowedStatsToCompare;
    }

    /**
     * @param statistic a statistic name, to check if it can be compared
     * @throws Exception if the statistic cannot be compared
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToCompare.contains(statistic)) {
            throw new Exception("Cannot compare Statistic " + statistic + "!");
        }
    }

    /**
     * Format the comparisons for display on the console
     * @param players the Players, sorted from best to worst stat
     * @param statValues the values corresponding to each Player
     * @return the formatted output to displayed
     */
    protected <T extends Player> String formatCompare(List<T> players,
                                                      List<String> statValues) {
        StringBuilder output = new StringBuilder("From best to worst:\n");
        // Precondition: players.size() == statValues.size()
        for (int i = 0; i != players.size(); i += 1) {
            Player player = players.get(i);
            output.append(player.getName());
            output.append(": ");
            output.append(statValues.get(0));
            output.append("\n");
        }
        return output.toString();
    }

    // TODO: Is there a better way to do this?
    /**
     * Cast a List of Players to List of T class objects
     * @param genericPlayers List of Player subclass castable to type T
     * @return List with original Players cast to HockeyPlayer
     */
    protected <T extends Player> List<T> castToPlayerType(List<?> genericPlayers) {
        ArrayList<T> specificPlayers = new ArrayList<T>();
        for (Object player : genericPlayers) {
            specificPlayers.add((T) player);
        }
        return specificPlayers;
    }
}

