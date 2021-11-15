package commands;

import player.PlayerList;
import player.TennisPlayer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TennisPlayerStatPredictor extends PlayerStatPredictor {

    public TennisPlayerStatPredictor(PlayerList<TennisPlayer> playerList) {
        super(playerList, new HashSet<String>(Arrays.asList("Aces",
                "Double Faults", "Serve Points", "First Serves",
                "Break Points Saved")));
    }

    /**
     * Handle an argument requesting a prediction of a player's
     * future statistic. Uses only requested seasons and assumes
     * the seasons were played in the order provided. Uses linear
     * regression.
     * @param arguments A string array of form
     *                  {"predict_player_stat", "Tennis", "player name",
     *                  "season 1", "season 2", ..., "stat name"}
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String name = arguments.get(2);
        TennisPlayer player = (TennisPlayer) this.playerList.getPlayer(name);

        int argSize = arguments.size();
        List<String> seasons = arguments.subList(3, argSize - 1);

        String statistic = arguments.get(argSize);
        checkStatistic(statistic);

        List<Double> pastStats = getPastStats(player, statistic, seasons);
        int prediction = linearExtrapolate(pastStats);
        return formatOut(seasons, pastStats, prediction);
    }

    /**
     * Collect the player's past statistics for the given seasons, maintaining order.
     * @param player the player to get statistics for
     * @param statistic the statistic to get
     * @param seasons the list of seasons to get
     * @return the player's statistics for the given seasons
     * @throws Exception if one statistic is not recorded
     */
    private List<Double> getPastStats(TennisPlayer player, String statistic,
                                      List<String> seasons)
            throws Exception {
        switch (statistic) {
            case "Aces":
                return this.getPastAces(player, seasons);
            case "Double Faults":
                return this.getPastDoubleFaults(player, seasons);
            case "Serve Points":
                return this.getPastServePoints(player, seasons);
            case "First Serves":
                return this.getPastFirstServes(player, seasons);
            case "Break Points Saved":
                return this.getPastBreakPointsSaved(player, seasons);
            default:
                throw new Exception("this shouldn't logically be thrown!");
        }
    }

    /**
     * Get the Aces statistics for the given player in all given seasons
     * @param player the Player to get Goals statistics for
     * @param seasons the list of seasons to consider
     * @return the Aces statistics, for all given seasons
     * @throws Exception if one season lacks recorded Aces data
     */
    private List<Double> getPastAces(TennisPlayer player,
                                     List<String> seasons)
            throws Exception {
        ArrayList<Double> pastAces = new ArrayList<>();
        for (String season : seasons) {
            pastAces.add((double) player.getStatAces(season));
        }
        return pastAces;
    }

    /**
     * Get the Double Faults statistics for the given player in all given seasons
     * @param player the Player to get Double Faults statistics for
     * @param seasons the list of seasons to consider
     * @return the Aces statistics, for all given seasons
     * @throws Exception if one season lacks recorded Double Faults data
     */
    private List<Double> getPastDoubleFaults(TennisPlayer player,
                                             List<String> seasons)
            throws Exception {
        ArrayList<Double> pastDoubleFaults = new ArrayList<>();
        for (String season : seasons) {
            pastDoubleFaults.add((double) player.getStatDoubleFaults(season));
        }
        return pastDoubleFaults;
    }

    /**
     * Get the Serve Points statistics for the given player in all given seasons
     * @param player the Player to get Goals statistics for
     * @param seasons the list of seasons to consider
     * @return the Serve Points statistics, for all given seasons
     * @throws Exception if one season lacks recorded Serve Points data
     */
    private List<Double> getPastServePoints(TennisPlayer player,
                                            List<String> seasons)
            throws Exception {
        ArrayList<Double> pastServePoints = new ArrayList<>();
        for (String season : seasons) {
            pastServePoints.add((double) player.getStatServePoints(season));
        }
        return pastServePoints;
    }

    /**
     * Get the First Serves statistics for the given player in all given seasons
     * @param player the Player to get Goals statistics for
     * @param seasons the list of seasons to consider
     * @return the First Serves statistics, for all given seasons
     * @throws Exception if one season lacks recorded First Serves data
     */
    private List<Double> getPastFirstServes(TennisPlayer player,
                                            List<String> seasons)
            throws Exception {
        ArrayList<Double> pastFirstServes = new ArrayList<>();
        for (String season : seasons) {
            pastFirstServes.add((double) player.getStatFirstServes(season));
        }
        return pastFirstServes;
    }

    /**
     * Get the Break Points Saved statistics for the given player in all given seasons
     * @param player the Player to get Goals statistics for
     * @param seasons the list of seasons to consider
     * @return the Break Points Saved statistics, for all given seasons
     * @throws Exception if one season lacks recorded Break Points Saved data
     */
    private List<Double> getPastBreakPointsSaved(TennisPlayer player,
                                                 List<String> seasons)
            throws Exception {
        ArrayList<Double> pastBreakPointsSaved = new ArrayList<>();
        for (String season : seasons) {
            pastBreakPointsSaved.add((double) player.getStatBreakPointsSaved(season));
        }
        return pastBreakPointsSaved;
    }
}
