package commands;

import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a class that can report a specific stat for a specific tennis player who played at a specific competition.
 */

public class TennisPlayerStatManager implements Command {
    static final int PLAYER_NAME = 0;
    static final int STAT = 1;
    static final int COMPETITION = 2;

    public TennisPlayerStatManager() {}


    /**
     * Return the specified stat for the specified player, who participated in the specified competition
     * @param arguments a list in the format [player name, stat, competition one, competition two, ...]
     * @return the specified stat of the player
     * @throws Exception if the competition or player could not be found
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String neededName = arguments.get(PLAYER_NAME);
        String neededStat = arguments.get(STAT);
        List<String> neededCompetitions = arguments.subList(COMPETITION, arguments.size());
        TennisPlayerList tp = new TennisPlayerList();
        HashMap<String, ArrayList<TennisPlayer>> competitionToPlayers = tp.getAllTennisPlayers();

        StringBuilder result = new StringBuilder();

        for (String competition : competitionToPlayers.keySet()) {
            if (neededCompetitions.contains(competition)) {
                result.append(competition).append(": ").append(tp.findTennisPlayer(competition,
                        neededName).getNeededStat(neededStat));

            }
        }
        return result.toString();
    }
}
