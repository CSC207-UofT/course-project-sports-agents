package sports.tennis;

import driversAdapters.DataContainer;
import player.TennisPlayer;
import commands.PlayerStatPredictor;
import sports.tennis.TennisPlayer;

import java.util.*;

public class TennisPlayerStatPredictor extends PlayerStatPredictor {

    public TennisPlayerStatPredictor() {
        super(new HashSet<>(Arrays.asList("rank", "matches", "aces", "double faults",
                "serve points won", "break points saved", "serve games won",
                "return games won", "break points converted", "return points won")));
    }

    /**
     * Handle an argument requesting a prediction of a player's
     * future statistic. Uses only requested seasons and assumes
     * the seasons were played in the order provided. Uses linear
     * regression.
     * @param arguments A string array of form
     *                  {"Tennis", "player name",
     *                  "season 1", "season 2", ..., "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container)
            throws Exception {
        String name = arguments.get(1);
        TennisPlayer player = (TennisPlayer) container.getPlayer("tennis", name);

        String statistic = arguments.get(2);
        checkStatistic(statistic);

        // Get a list of the player's stats for all the seasons they participated in
        List<String> playerSeasons = player.getSeasons();
        List<Integer> seasonInts = this.getXAxis(playerSeasons);
        List<Double> pastStats = getPastStats(player, statistic, playerSeasons);

        double prediction = linearExtrapolate(seasonInts, pastStats);
        return formatOut(playerSeasons, statistic, pastStats, prediction);
    }


    /**
     * Return the values of the given stat for the given seasons
     * @param player needed player
     * @param stat needed stat
     * @param seasons seasons to consider
     * @return values of needed stat for all competitions the player participated in
     * @throws Exception if a stat does not have data for a competition
     */
    private List<Double> getPastStats(TennisPlayer player, String stat,
                                      List<String> seasons)
            throws Exception {
        switch (stat) {
            case "rank":
                return this.getPastRanks(player, seasons);
            case "matches":
                return this.getPastMatches(player, seasons);
            case "aces":
                return this.getPastAces(player, seasons);
            case "double faults":
                return this.getPastDoubleFaults(player, seasons);
            case "serve points won":
                return this.getPastServePointsWon(player, seasons);
            case "break points saved":
                return this.getPastBreakPointsSaved(player, seasons);
            case "serve games won":
                return this.getPastServeGamesWon(player, seasons);
            case "return games won":
                return this.getPastReturnGamesWon(player, seasons);
            case "break points converted":
                return this.getPastBreakPointsConverted(player, seasons);
            case "return points won":
                return this.getPastReturnPointsWon(player, seasons);
            default:
                throw new Exception("should not be thrown logically");
        }
    }

    /**
     * Return the player's rank in the given list of seasons, assuming the player participated in those seasons
     * @param player player of interest
     * @param seasons seasons to consider
     * @return list of past ranks
     * @throws Exception if a season has no rank data
     */
    private List<Double> getPastRanks(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastRanks = new ArrayList<>();
        for (String season : seasons) {
            pastRanks.add((double) player.getStatRank(season));
        }
        return pastRanks;
    }

    /**
     * Return the number of matches the player participated in for the given seasons, assuming the player
     * participated in those seasons
     * @param player player of interest
     * @param seasons seasons to consider
     * @return list of past numbers of matches
     * @throws Exception if a season has no matches data
     */
    private List<Double> getPastMatches(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastMatches = new ArrayList<>();
        for (String season : seasons) {
            pastMatches.add((double) player.getStatMatches(season));
        }
        return pastMatches;
    }

    /**
     * Return the number of aces a tennis player has scored in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past aces
     * @throws Exception if a season has no aces data
     */
    private List<Double> getPastAces(TennisPlayer player,
                                     List<String> seasons)
            throws Exception {
        List<Double> pastAces = new ArrayList<>();
        for (String season : seasons) {
            pastAces.add((double) player.getStatAces(season));
        }
        return pastAces;
    }

    /**
     * Return the number of double faults a tennis player has made in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past double faults
     * @throws Exception if a season has no double faults data
     */
    private List<Double> getPastDoubleFaults(TennisPlayer player,
                                             List<String> seasons)
            throws Exception {
        List<Double> pastDoubleFaults = new ArrayList<>();
        for (String season : seasons) {
            pastDoubleFaults.add((double) player.getStatDoubleFaults(season));
        }
        return pastDoubleFaults;
    }

    /**
     * Return the percentage of serve points a player has won in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past percentages of serve points won
     * @throws Exception if a given season has no serve points won data
     */
    private List<Double> getPastServePointsWon(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastServePointsWon = new ArrayList<>();
        for (String season : seasons) {
            pastServePointsWon.add(player.getStatServePointsWon(season));
        }
        return pastServePointsWon;
    }

    /**
     * Return the percentage of break points a tennis player has saved in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past percentages of break points saved
     * @throws Exception if a season has no break points saved data
     */
    private List<Double> getPastBreakPointsSaved(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastBreakPointsSaved = new ArrayList<>();
        for (String season : seasons) {
            pastBreakPointsSaved.add(player.getStatBreakPointsSaved(season));
        }
        return pastBreakPointsSaved;
    }

    /**
     * Return the percentage of serve games a tennis player has won in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past percentage of serve games won
     * @throws Exception if a season has no serve games won data
     */
    private List<Double> getPastServeGamesWon(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastServeGamesWon = new ArrayList<>();
        for (String season : seasons) {
            pastServeGamesWon.add(player.getStatServeGamesWon(season));
        }
        return pastServeGamesWon;
    }

    /**
     * Return the percentage of return games a tennis player has won in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past percentage of return games won
     * @throws Exception if a season has no return games won data
     */
    private List<Double> getPastReturnGamesWon(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastReturnGamesWon = new ArrayList<>();
        for (String season : seasons) {
            pastReturnGamesWon.add(player.getStatReturnGamesWon(season));
        }
        return pastReturnGamesWon;
    }

    /**
     * Return the percentage of break points a tennis player has converted in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past percentages of break points converted
     * @throws Exception if a season has no break points converted data
     */
    private List<Double> getPastBreakPointsConverted(TennisPlayer player, List<String> seasons) throws Exception {
        List<Double> pastBreakPointsConverted = new ArrayList<>();
        for (String season : seasons) {
            pastBreakPointsConverted.add(player.getStatBreakPointsConverted(season));
        }
        return pastBreakPointsConverted;
    }

    /**
     * Return the percentage of return points a tennis player has scored in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past percentage of return points won
     * @throws Exception if a season has no aces data
     */
    private List<Double> getPastReturnPointsWon(TennisPlayer player,
                                            List<String> seasons)
            throws Exception {
        List<Double> pastReturnPointsWon = new ArrayList<>();

        for (String season : seasons) {
            pastReturnPointsWon.add(player.getStatReturnPointsWon(season));
        }
        return pastReturnPointsWon;
    }
}
