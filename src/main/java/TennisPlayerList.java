import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A class that can read a .csv file containing data about tennis players that participated in a specific tournament,
 * and store that data as a value in a HashMap with the name of the tournament as a key.
 */
public class TennisPlayerList {
    private static HashMap<String, ArrayList<TennisPlayer>> competitionToPlayers;
    static final int WINNER_NAME = 0;
    static final int WINNER_AGE = 1;
    static final int WINNER_NATIONALITY = 2;
    static final int LOSER_NAME = 3;
    static final int LOSER_AGE = 4;
    static final int LOSER_NATIONALITY = 5;
    static final int WINNER_SETS_WON = 6;
    static final int WINNER_SETS_LOST = 7;
    static final int LOSER_SETS_WON = 7;
    static final int LOSER_SETS_LOST = 6;
    static final int WINNER_GAMES_WON = 8;
    static final int WINNER_GAMES_LOST = 9;
    static final int LOSER_GAMES_WON = 9;
    static final int LOSER_GAMES_LOST = 8;


    /**
     * Construct a TennisPlayerList with the data in file.
     */
    public TennisPlayerList(String competition, FileReader file) {
        competitionToPlayers = new HashMap<>();
        ArrayList<TennisPlayer> tennisPlayers = generatePlayerList(file);
        competitionToPlayers.put(competition, tennisPlayers);
    }


    /**
     * Generate a list of all the tennis players that participated in a competition; file contains data about
     * the players that participated in a competition
     * @param file contains data about all the tennis players that participated in the competition
     * @return list of tennis players
     */
    private ArrayList<TennisPlayer> generatePlayerList(FileReader file) {
        ArrayList<TennisPlayer> tennisPlayers = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(file);
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] playerData = line.split(",");
                TennisPlayer winner = helperFindTennisPlayer(tennisPlayers, playerData[WINNER_NAME],
                        Integer.parseInt(playerData[WINNER_AGE]), playerData[WINNER_NATIONALITY]);
                TennisPlayer loser = helperFindTennisPlayer(tennisPlayers, playerData[LOSER_NAME],
                        Integer.parseInt(playerData[LOSER_AGE]), playerData[LOSER_NATIONALITY]);
                updateWinner(playerData, winner);
                updateLoser(playerData, loser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tennisPlayers;
    }

    /**
     * This is a helper function for generatePlayerList; it updates a tennis player's sets won and lost, and games
     * won and lost
     * @param playerData an array containing the player's data
     * @param winner the winner in a match as specified in <file> of generatePlayerList
     */
    private void updateWinner(String[] playerData, TennisPlayer winner) {
        winner.updateSetsWon(Integer.parseInt(playerData[WINNER_SETS_WON]));
        winner.updateSetsLost(Integer.parseInt(playerData[WINNER_SETS_LOST]));
        winner.updateGamesWon(Integer.parseInt(playerData[WINNER_GAMES_WON]));
        winner.updateGamesLost(Integer.parseInt(playerData[WINNER_GAMES_LOST]));
    }


    /**
     * This is a helper function for generatePlayerList; it updates a tennis player's sets won and lost, and games
     * won and lost
     * @param playerData an array containing the player's data
     * @param loser the loser in a match as specified in <file> of generatePlayerList
     */
    private void updateLoser(String[] playerData, TennisPlayer loser) {
        loser.updateSetsWon(Integer.parseInt(playerData[LOSER_SETS_WON]));
        loser.updateSetsLost(Integer.parseInt(playerData[LOSER_SETS_LOST]));
        loser.updateGamesWon(Integer.parseInt(playerData[LOSER_GAMES_WON]));
        loser.updateGamesLost(Integer.parseInt(playerData[LOSER_GAMES_LOST]));
    }


    /**
     * This is a helper function for generatePlayerList; if a tennis player with the given name, age, and nationality
     * is already in the list of tennis players, that tennis player is found and returned. If that tennis player is
     * not in the list of tennis players, that player is added to the list and returned.
     * @param players list of tennis players
     * @param name tennis player's name
     * @param age tennis player's age
     * @param nationality tennis player's nationality
     * @return a Tennis player from players if the player is there, or a new Tennis player if the player is not there
     */
    private TennisPlayer helperFindTennisPlayer(ArrayList<TennisPlayer> players, String name, int age,
                                                String nationality) {
        TennisPlayer newPlayer = new TennisPlayer(name, age, nationality);
        for (TennisPlayer player : players) {
            if (player.equals(newPlayer)) {
                return player;
            }
        }
        players.add(newPlayer);
        return newPlayer;
    }



    /**
     * Return a HashMap of competitions and associated players
     * @return HashMap of players
     */
    public HashMap<String, ArrayList<TennisPlayer>> getALLTennisPlayers() {
        return competitionToPlayers;
    }


    /**
     * Return true if this tennis player and competition can be found in competitionToPlayers
     * @param competition the name of the competition
     * @param name the name of the tennis player
     * @return true if the tennis player is found, and false otherwise
     */
    public boolean containsPlayer(String competition, String name) {
        if (competitionToPlayers.containsKey(competition)) {
            for (TennisPlayer player : competitionToPlayers.get(competition)) {
                if (player.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Return a string representation of a player in a given competition
     * @param competition name of the competition
     * @param name name of the player
     * @return string representation of the tennis player
     * @throws Exception if the tennis player or competition are not found
     */
    public String findTennisPlayer(String competition, String name) throws Exception {
        if (containsPlayer(competition, name)) {
            for (TennisPlayer player : competitionToPlayers.get(competition)) {
                if (Objects.equals(player.getName(), name)) {
                    return player.toString();
                }
            }
        }
        throw new Exception("Player or Competition not found!");
    }


    /**
     * Return the winner of this competition; the winner of a competition has won the highest number of sets
     * @param competition name of competition
     * @return string representation of the winner
     */
    public String findCompetitionWinner(String competition) {
        int maxSets = 0;
        TennisPlayer winner = new TennisPlayer("NAME", 100, "NATIONALITY");
        ArrayList<TennisPlayer> competitionPlayers = competitionToPlayers.get(competition);
        for (TennisPlayer player : competitionPlayers) {
            if (player.getSetsWon() > maxSets) {
                winner = player;
                maxSets = player.getSetsWon();
            }
        }
        return winner.toString();
    }

}
