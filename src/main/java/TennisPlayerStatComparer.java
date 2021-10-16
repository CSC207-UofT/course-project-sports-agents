import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a class that compare two tennis players, who played in a given competition, based on the given stat.
 */

public class TennisPlayerStatComparer implements Command {
    static final int PLAYER_ONE = 0;
    static final int PLAYER_TWO = 1;
    static final int STAT = 2;
    static final int COMPETITION = 3;

    public TennisPlayerStatComparer() {}

    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String playerOneName = arguments.get(PLAYER_ONE);
        String playerTwoName = arguments.get(PLAYER_TWO);
        String neededStat = arguments.get(STAT);
        String neededCompetition = arguments.get(COMPETITION);
        TennisPlayerList tp = new TennisPlayerList();
        HashMap<String, ArrayList<TennisPlayer>> competitionToPlayers = tp.getAllTennisPlayers();
        ArrayList<TennisPlayer> competitionPlayers = new ArrayList<>();
        ArrayList<TennisPlayer> neededPlayers = new ArrayList<>();

        for (String competition : competitionToPlayers.keySet()) {
            if (competition.equals(neededCompetition)) {
                competitionPlayers = competitionToPlayers.get(competition);
            }
        }

        for (TennisPlayer player : competitionPlayers) {
            if (player.getName().equals(playerOneName) | player.getName().equals(playerTwoName)) {
                neededPlayers.add(player);
            }
        }

        if (competitionPlayers.isEmpty()) {
            throw new Exception("Competition not found!");
        }

        if (neededPlayers.size() < 2) {
            throw new Exception("Could not find all players!");
        }

        int playerOneStat = Integer.parseInt(neededPlayers.get(PLAYER_ONE).getNeededStat(neededStat));
        int playerTwoStat = Integer.parseInt(neededPlayers.get(PLAYER_TWO).getNeededStat(neededStat));


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
