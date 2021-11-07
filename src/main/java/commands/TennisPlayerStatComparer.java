package commands;

import player.GetStatsComparator;
import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.*;

/**
 * A class that compare two tennis players, who played in a given competition, based on the given stat.
 */
public class TennisPlayerStatComparer implements Command {
    private final HashSet<String> allowedStats;
    static final int PLAYER = 1;
    static final int STAT = 2;
    static final int COMPETITION = 1;

    public TennisPlayerStatComparer() {
        this.allowedStats = new HashSet<>(Arrays.asList("aces", "double faults", "break points", "first serves",
                "break points saved"));
    }


    /**
     * Return the player with the highest specified stat (e.g. aces, double faults, first serves, serve points,
     * and break points saved)
     * @param arguments a list in the format: [sport, player one, player two,....,stat, competition]
     * @return the player with the higher stat, reported as maximum, and the player with the lower stat, reported
     * as minimum
     * @throws Exception if the players cannot be found, the competition cannot be found, or the specified stat cannot
     * be compared
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        List<String> playerNames = arguments.subList(PLAYER, arguments.size() - 2);
        String stat = arguments.get(arguments.size() - STAT);
        String competition = arguments.get(arguments.size() - COMPETITION);

        if (!(allowedStats.contains(stat))) {
            throw new Exception("Invalid stat!");
        }

        StringBuilder result = new StringBuilder(competition + "\nFrom lowest to highest:\n");
        List<Integer> neededStats = new ArrayList<>();

        TennisPlayerList tp = new TennisPlayerList();
        ArrayList<TennisPlayer> neededPlayers = new ArrayList<>();

        for (String name : playerNames) {
            TennisPlayer newPlayer = tp.findTennisPlayer(competition, name);
            neededPlayers.add(newPlayer);
            neededStats.add(newPlayer.getNeededStat(stat).get(competition));
        }

        Collections.sort(neededStats);
        neededPlayers.sort(new GetStatsComparator(stat, competition));

        for (TennisPlayer player : neededPlayers) {
            result.append(player.getName()).append(": ").
                    append(neededStats.get(neededPlayers.indexOf(player))).append(" ").append(stat).append('\n');
        }

        return result.toString().trim();
    }
}
