package commands;

import player.GetStatsComparator;
import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that compare two tennis players, who played in a given competition, based on the given stat.
 */

public class TennisPlayerStatComparer implements Command {

    public TennisPlayerStatComparer() {}


    /**
     * Return the player with the highest specified stat (e.g. aces, double faults, first serves, serve points,
     * and break points saved)
     * @param arguments a list in the format: [player one, player two,....,stat, competition]
     * @return the player with the higher stat, reported as maximum, and the player with the lower stat, reported
     * as minimum
     * @throws Exception if the players cannot be found, the competition cannot be found, or the specified stat cannot
     * be compared
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        List<String> playerNames = arguments.subList(0, arguments.size() - 2);
        String stat = arguments.get(arguments.size() - 2);
        String competition = arguments.get(arguments.size() - 1);

        StringBuilder result = new StringBuilder(competition + "\nFrom lowest to highest:\n");
        List<Integer> neededStats = new ArrayList<>();

        TennisPlayerList tp = new TennisPlayerList();
        ArrayList<TennisPlayer> neededPlayers = new ArrayList<>();

        for (String name : playerNames) {
            TennisPlayer newPlayer =  tp.findTennisPlayer(competition, name);
            neededPlayers.add(newPlayer);
            neededStats.add(newPlayer.getNeededStat(stat).get(competition));
        }

        Collections.sort(neededStats);
        neededPlayers.sort(new GetStatsComparator(stat, competition));

        for(TennisPlayer player : neededPlayers) {
            result.append(player.getName()).append(": ").
                    append(neededStats.get(neededPlayers.indexOf(player))).append(" ").append(stat).append('\n');
        }

        return result.toString().trim();
        }
}
