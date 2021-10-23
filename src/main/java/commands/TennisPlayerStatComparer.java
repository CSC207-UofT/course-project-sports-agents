package commands;

import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a class that compare two tennis players, who played in a given competition, based on the given stat.
 */

public class TennisPlayerStatComparer implements Command {
    static final int PLAYER_ONE = 0;
    static final int PLAYER_TWO = 1;
    static final int STAT = 2;
    static final int COMPETITION = 3;

    public TennisPlayerStatComparer() {}


    /**
     * Return the player with the highest specified stat (e.g. aces, double faults, first serves, serve points,
     * and break points saved)
     * @param arguments a list in the format: [player one, player two, stat, competition]
     * @return the player with the higher stat, reported as maximum, and the player with the lower stat, reported
     * as minimum
     * @throws Exception if the players cannot be found, the competition cannot be found, or the specified stat cannot
     * be compared
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        List<String> playerNames = arguments.subList(0, arguments.size() - 2);
        TennisPlayerList tp = new TennisPlayerList();
        ArrayList<TennisPlayer> neededPlayers = new ArrayList<>();

        for (String name : playerNames) {
            neededPlayers.add(tp.findTennisPlayer(arguments.get(COMPETITION), name));
        }

        int playerOneStat = Integer.parseInt(neededPlayers.get(PLAYER_ONE).getNeededStat(arguments.get(STAT)));
        int playerTwoStat = Integer.parseInt(neededPlayers.get(PLAYER_TWO).getNeededStat(arguments.get(STAT)));


        if (playerOneStat > playerTwoStat) {
            return "Maximum:\n" + neededPlayers.get(PLAYER_ONE).toString() + "\n\nMinimum:\n" +
                    neededPlayers.get(PLAYER_TWO).toString();
        } else if (playerOneStat < playerTwoStat) {
            return "Maximum:\n" + neededPlayers.get(PLAYER_TWO).toString() + "\n\nMinimum:\n" +
                    neededPlayers.get(PLAYER_ONE).toString();
        } else {
            return "Both players are equal." + "\n\n" + neededPlayers.get(PLAYER_ONE).toString() + "\n\n" +
                    neededPlayers.get(PLAYER_TWO).toString();
        }
    }
}
