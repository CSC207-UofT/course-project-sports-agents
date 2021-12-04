package commands;

import drivers_adapters.DataContainer;
import sports.tennis.TennisPlayer;

import java.util.*;

public class TennisPlayerStatPredictor extends PlayerStatPredictor {

    public TennisPlayerStatPredictor() {
        super(new HashSet<>(Arrays.asList("Aces",
                "Double Faults", "Serve Points", "First Serves",
                "Break Points Saved")));
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
        return formatOut(playerSeasons, pastStats, prediction);
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
            case "Aces":
                return this.getPastAces(player, seasons);
            case "Double Faults":
                return this.getPastDoubleFaults(player, seasons);
            case "Break Points Saved":
                return this.getPastBreakPointsSaved(player, seasons);
            case "First Serves":
                return this.getPastFirstServes(player, seasons);
            case "Serve Points":
                return this.getPastServePoints(player, seasons);
            default:
                throw new Exception("should not be thrown logically");
        }
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
     *
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past double faults
     * @throws Exception if a season has no double faults data
     */
    private List<Double> getPastDoubleFaults(TennisPlayer player,
                                             List<String> seasons)
            throws Exception {
        List<Double> doubleFaults = new ArrayList<>();
        for (String season : seasons) {
            doubleFaults.add((double) player.getStatDoubleFaults(season));
        }
        return doubleFaults;
    }

    /**
     * Return the number of aces a tennis player has scored in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past aces
     * @throws Exception if a season has no break points data
     */
    private List<Double> getPastBreakPointsSaved(TennisPlayer player,
                                                 List<String> seasons)
            throws Exception {
        List<Double> pastBreakPoints = new ArrayList<>();
        for (String season : seasons) {
            pastBreakPoints.add((double) player.getStatBreakPointsSaved(season));
        }
        return pastBreakPoints;
    }

    /**
     * Return the number of first serves a tennis player has made in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past first serves
     * @throws Exception if a season has no first serves data
     */
    private List<Double> getPastFirstServes(TennisPlayer player,
                                            List<String> seasons)
            throws Exception {
        List<Double> pastFirstServes = new ArrayList<>();

        for (String season : seasons) {
            pastFirstServes.add((double) player.getStatFirstServes(season));
        }
        return pastFirstServes;
    }

    /**
     * Return the number of serve points a tennis player has scored in the given seasons
     * @param player needed player
     * @param seasons seasons to consider
     * @return list of past serve points
     * @throws Exception if a season has no aces data
     */
    private List<Double> getPastServePoints(TennisPlayer player,
                                            List<String> seasons)
            throws Exception {
        List<Double> pastServePoints = new ArrayList<>();

        for (String season : seasons) {
            pastServePoints.add((double) player.getStatServePoints(season));
        }
        return pastServePoints;
    }
}
