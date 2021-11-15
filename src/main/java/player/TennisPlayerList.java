package player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * A class that can read a .csv file containing data about tennis players that participated in different tournaments,
 * and store that data as a value in a Map with the name of player as a key, and the player object as the value.
 * In the .csv file, the tournaments are in the order that they happened (i.e. the .csv file is in chronological
 * order).
 */
public class TennisPlayerList extends PlayerList<TennisPlayer> {
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
        Map<String, TennisPlayer> playerMap = new HashMap<>();
        List<String> allCompetitions = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] playerData = line.split(",");
                if (!(allCompetitions.contains(playerData[TOURNAMENT_NAME]))) {
                    allCompetitions.add(playerData[TOURNAMENT_NAME]);
                }
                TennisPlayer winner = this.getTennisPlayer(playerMap, playerData[WINNER_NAME],
                        playerData[WINNER_COUNTRY]);
                TennisPlayer loser = this.getTennisPlayer(playerMap, playerData[LOSER_NAME],
                        playerData[LOSER_COUNTRY]);

                winner.addCompetition(playerData[TOURNAMENT_NAME],
                        (int) Math.round(Double.parseDouble(playerData[WINNER_AGE])));
                loser.addCompetition(playerData[TOURNAMENT_NAME],
                        (int) Math.round(Double.parseDouble(playerData[LOSER_AGE])));

                this.updatePlayer(playerData, winner, WINNER_ACES, WINNER_DOUBLE_FAULTS, WINNER_SERVE_POINTS,
                        WINNER_FIRST_SERVES, WINNER_BREAK_POINTS);
                this.updatePlayer(playerData, loser, LOSER_ACES, LOSER_DOUBLE_FAULTS, LOSER_SERVE_POINTS,
                        LOSER_FIRST_SERVES, LOSER_BREAK_POINTS);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setPlayerMap(playerMap);
        this.setSeasons(allCompetitions);
    }


    /**
     * Construct a map of tennis players with a default file
     */
    public TennisPlayerList() {
        this("tennis.csv");
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
        player.updateAll(playerData[TOURNAMENT_NAME], Integer.parseInt(playerData[aces]),
                Integer.parseInt(playerData[doubleFaults]), Integer.parseInt(playerData[servePoints]),
                Integer.parseInt(playerData[firstServes]), Integer.parseInt(playerData[breakPoints]));
    }


    /**
     * This is a helper method for the constructor; if a tennis player with the given name
     * is already in the map of all tennis players, that tennis player is found and returned. If that
     * tennis player is not in the map of all tennis players, that player is added to the map of tennis players
     * and returned
     * @param playerMap a map of all the tennis players that have already been added
     * @param name tennis player's name
     * @param nationality tennis player's nationality
     * @return a Tennis player from players if the player is there, or a new Tennis player if the player is not there
     */
    private TennisPlayer getTennisPlayer(Map<String, TennisPlayer> playerMap, String name, String nationality) {
        TennisPlayer newPlayer = new TennisPlayer(name, nationality);
        if (!(playerMap.containsKey(name))) {
            playerMap.put(name, newPlayer);
            return newPlayer;
        } else {
            return playerMap.get(name);
        }
    }
}
