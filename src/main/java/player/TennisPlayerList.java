package player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * A class that can read a .csv file containing data about tennis players that participated in different tournaments,
 * and store that data as a value in a Map with the name of the tournament as a key.
 */
public class TennisPlayerList {
    private final HashMap<String, ArrayList<TennisPlayer>> competitionToPlayers;
    private final List<String> allCompetitions;
    private final List<TennisPlayer> allPlayers;
    static final int TOURNAMENT_NAME = 0;
    static final int WINNER_NAME = 1;
    static final int WINNER_AGE = 3;
    static final int WINNER_COUNTRY = 2;
    static final int LOSER_NAME = 4;
    static final int LOSER_AGE = 6;
    static final int LOSER_COUNTRY = 5;
    static final int WINNER_ACES = 7;
    static final int WINNER_DOUBLE_FAULTS = 8;
    static final int WINNER_SERVE_POINTS = 9;
    static final int WINNER_FIRST_SERVES = 10;
    static final int WINNER_BREAK_POINTS = 11;
    static final int LOSER_ACES = 12;
    static final int LOSER_DOUBLE_FAULTS = 13;
    static final int LOSER_SERVE_POINTS = 14;
    static final int LOSER_FIRST_SERVES = 15;
    static final int LOSER_BREAK_POINTS = 16;

    /**
     * Construct a map mapping tennis players to a competition when given the name of a file
     */
    public TennisPlayerList(String fileName) {
        competitionToPlayers = new HashMap<>();
        allCompetitions = new ArrayList<>();
        allPlayers = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] playerData = line.split(",");
                if (!(competitionToPlayers.containsKey(playerData[TOURNAMENT_NAME]))) {
                    competitionToPlayers.put(playerData[TOURNAMENT_NAME], new ArrayList<>());
                    allCompetitions.add(playerData[TOURNAMENT_NAME]);
                }
                ArrayList<TennisPlayer> competitionPlayers = competitionToPlayers.get(playerData[TOURNAMENT_NAME]);
                TennisPlayer winner = findTennisPlayer(playerData[TOURNAMENT_NAME], competitionPlayers,
                        playerData[WINNER_NAME], playerData[WINNER_COUNTRY]);
                winner.addCompetition(playerData[TOURNAMENT_NAME],
                        (int) Math.round(Double.parseDouble(playerData[WINNER_AGE])));
                TennisPlayer loser = findTennisPlayer(playerData[TOURNAMENT_NAME], competitionPlayers,
                        playerData[LOSER_NAME], playerData[LOSER_COUNTRY]);
                loser.addCompetition(playerData[TOURNAMENT_NAME],
                        (int) Math.round(Double.parseDouble(playerData[LOSER_AGE])));
                updatePlayer(playerData, winner, WINNER_ACES, WINNER_DOUBLE_FAULTS, WINNER_SERVE_POINTS,
                        WINNER_FIRST_SERVES, WINNER_BREAK_POINTS);
                updatePlayer(playerData, loser, LOSER_ACES, LOSER_DOUBLE_FAULTS, LOSER_SERVE_POINTS,
                        LOSER_FIRST_SERVES, LOSER_BREAK_POINTS);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Construct a map of tennis players with a default file
     */
    public TennisPlayerList() {
        this("Sample_Tennis_Data_2019.csv");
    }

    /**
     * This is a helper method for the constructor; it updates all the attributes associated with a given
     * tennis player for a competition
     * @param playerData a list that contains all the data about two players
     * @param player the player that needs to be updated
     * @param aces playerData[aces] contains the number of new aces made by player
     * @param doubleFaults playerData[doubleFaults] contains the number of new double faults made by player
     * @param servePoints playerData[servePoints] contains the number of new serve points won by player
     * @param firstServes playerData[firstServes] contains the number of new first serves made by player
     * @param breakPoints playerData[breakPoints] contains the number of new break points saved by player
     */
    private void updatePlayer(String[] playerData, TennisPlayer player, int aces, int doubleFaults, int servePoints,
                              int firstServes, int breakPoints) {
        player.updateAces(playerData[TOURNAMENT_NAME], Integer.parseInt(playerData[aces]));
        player.updateDoubleFaults(playerData[TOURNAMENT_NAME], Integer.parseInt(playerData[doubleFaults]));
        player.updateServePoints(playerData[TOURNAMENT_NAME], Integer.parseInt(playerData[servePoints]));
        player.updateFirstServes(playerData[TOURNAMENT_NAME], Integer.parseInt(playerData[firstServes]));
        player.updateBreakPointsSaved(playerData[TOURNAMENT_NAME], Integer.parseInt(playerData[breakPoints]));
    }


    /**
     * This is a helper method for the constructor; if a tennis player with the given name
     * is already in the list of all tennis players, that tennis player is found and returned. If that
     * tennis player is not in the list of all tennis players, that player is added to a list of competition players
     * and the list of all players, and returned.
     * @param competitionPlayers list of all tennis players that participated in a competition
     * @param name tennis player's name
     * @param nationality tennis player's nationality
     * @return a Tennis player from players if the player is there, or a new Tennis player if the player is not there
     */
    private TennisPlayer findTennisPlayer(String competition, List<TennisPlayer> competitionPlayers, String name,
                                          String nationality) {
        TennisPlayer newPlayer = new TennisPlayer(name, nationality);
        for (TennisPlayer player : allPlayers) {
            if (!(containsPlayer(competition, player.getName()))) {
                competitionPlayers.add(player);
            }
            if (player.equals(newPlayer)) {
                return player;
            }
        }
        allPlayers.add(newPlayer);
        competitionPlayers.add(newPlayer);
        return newPlayer;
    }


    /**
     * Return a HashMap of competitions and associated players
     * @return HashMap of players
     */
    public HashMap<String, ArrayList<TennisPlayer>> getAllTennisPlayers() {
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
    public TennisPlayer findTennisPlayer(String competition, String name) throws Exception {
        if (!(competitionToPlayers.containsKey(competition))) {
            throw new Exception("Competition not found!");
        } else if (containsPlayer(competition, name)) {
            for (TennisPlayer player : competitionToPlayers.get(competition)) {
                if (Objects.equals(player.getName(), name)) {
                    return player;
                }
            }
        }
        throw new Exception("Player not found!");
    }


    /**
     * Return the tennis player with the given name
     * @param name the name of the needed player
     * @return the tennis player with the given name
     * @throws Exception if the player cannot be found (the player is not included in the .csv file
     */
    public TennisPlayer findTennisPlayer(String name) throws Exception {
        for (TennisPlayer player : allPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new Exception("Player not found!");
    }


    /**
     * Return a list of all the competitions contained in the .csv file, in the order they appear in the
     * .csv file
     * @return a list of all competition names
     */
    public List<String> getAllCompetitions() {
        return allCompetitions;
    }
}
