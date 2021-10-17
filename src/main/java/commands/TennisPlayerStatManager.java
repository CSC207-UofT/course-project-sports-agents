package commands;

import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.ArrayList;
import java.util.HashMap;

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
     * @param arguments a list in the format [player name, stat, competition]
     * @return the specified stat of the player
     * @throws Exception if the competition or player could not be found
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String neededName = arguments.get(PLAYER_NAME);
        String neededStat = arguments.get(STAT);
        String neededCompetition = arguments.get(COMPETITION);
        TennisPlayerList tp = new TennisPlayerList();
        HashMap<String, ArrayList<TennisPlayer>> competitionToPlayers = tp.getAllTennisPlayers();
        ArrayList<TennisPlayer> competitionPlayers = new ArrayList<>();

        for (String competition : competitionToPlayers.keySet()) {
            if (competition.equals(neededCompetition)) {
                competitionPlayers = competitionToPlayers.get(competition);
            }
        }

        if (competitionPlayers.isEmpty()) {
            throw new Exception("Competition not found!");
        }
        
        TennisPlayer neededPlayer = null;
        for (TennisPlayer player : competitionPlayers) {
            if (player.getName().equals(neededName)) {
                neededPlayer = player;
            }
        }

        if (neededPlayer == null) {
            throw new Exception("That player did not participate in this competition!");
        }

        if (neededStat.equals("all stats")) {
            return neededPlayer.toString();
        } else {
            return neededPlayer.getNeededStat(neededStat);
        }
    }
}
