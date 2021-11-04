package commands;

import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.*;

/**
 * This is a class that can report a specific stat for a specific tennis player who played at a specific competition.
 */
public class TennisPlayerStatManager implements Command {
    private final HashSet<String> allowedStats;
    static final int PLAYER_NAME = 0;
    static final int STAT = 1;
    static final int COMPETITION = 2;

    public TennisPlayerStatManager() {
        this.allowedStats = new HashSet<>(Arrays.asList("age", "nationality", "aces", "double faults",
                "serve points", "first serves", "break points saved"));
    }


    /**
     * Return the specified stat for the specified player, who participated in the specified competition
     *
     * @param arguments a list in the format [player name, stat, competition one, competition two, ...]
     * @return the specified stat of the player
     * @throws Exception if the competition or player could not be found
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String neededName = arguments.get(PLAYER_NAME);
        String stat = arguments.get(STAT);

        if (!(this.allowedStats.contains(stat))) {
            throw new Exception("Invalid stat!");
        }

        List<String> neededCompetitions = arguments.subList(COMPETITION, arguments.size());
        TennisPlayerList tp = new TennisPlayerList();
        TennisPlayer neededPlayer = tp.findTennisPlayer(neededName);
        StringBuilder result = new StringBuilder();

        if (stat.equals("nationality")) {
            return neededPlayer.getCountry();
        }

        for (String competition : neededCompetitions) {
            updateResult(result, stat, neededPlayer, competition);
        }
        return result.toString().trim();
    }


    /**
     * This is a helper method for execute. It updates the given result to include the needed stat for a
     * tennis player at a given competition
     * @param result a StringBuilder object that needs to be updated
     * @param stat the needed stat to be added to result
     * @param neededPlayer the player's whose stat is needed
     * @param competition the competition for which the stat is needed
     * @throws Exception if the player did not participate at the given competition
     */
    private void updateResult(StringBuilder result, String stat, TennisPlayer neededPlayer,
                                String competition) throws Exception {
        if (stat.equals("all stats")) {
            result.append(competition).append(":\n");
            result.append(neededPlayer.competitionToString(competition)).append("\n\n");
        } else {
            Map<String, Integer> neededStats = neededPlayer.getNeededStat(stat);
            if (!(neededStats.containsKey(competition))) {
                throw new Exception("Player did not participate in a given competition!");
            }
            result.append(competition).append(": ").append(neededStats.get(competition));
            result.append("\n");
        }
    }
}
