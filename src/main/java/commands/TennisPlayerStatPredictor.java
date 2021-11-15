package commands;

import drivers_adapters.DataContainer;
import player.TennisPlayer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TennisPlayerStatPredictor extends PlayerStatPredictor {

    public TennisPlayerStatPredictor() {
        super(new HashSet<String>(Arrays.asList("Aces",
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
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        TennisPlayer player = (TennisPlayer) container.getPlayer("tennis", name);

        int argSize = arguments.size();
        List<String> seasons = arguments.subList(2, argSize - 1);

        String statistic = arguments.get(argSize);
        checkStatistic(statistic);

        // Get the integer values for all the competitions the player participated in, the stat values for
        // those competitions
        List<Integer> competitionInts = new ArrayList<>();
        List<String> playerCompetitions = neededPlayer.getCompetitions();
        List<Double> playerStatsAsDoubles = this.getStat(neededPlayer, stat);

        for (String competition : playerCompetitions) {
            competitionInts.add(competitionValues.get(competition));
        }

        double prediction = this.linearExtrapolate(competitionInts, playerStatsAsDoubles);
        return this.formatOut(playerCompetitions, playerStatsAsDoubles, prediction);
    }


    /**
     * Return the values of the given stat for all the competitions a given player has participated in
     * @param player needed player
     * @param stat needed stat
     * @return values of needed stat for all competitions the player participated in
     * @throws Exception if a stat does not have data for a competition
     */
    private List<Double> getStat(TennisPlayer player, String stat) throws Exception {
        switch (stat) {
            case "Aces":
                return this.getPastAces(player);
            case "Double Faults":
                return this.getPastDoubleFaults(player);
            case "Break Points Saved":
                return this.getPastBreakPointsSaved(player);
            case "First Serves":
                return this.getPastFirstServes(player);
            case "Serve Points":
                return this.getPastServePoints(player);
            default:
                throw new Exception("should not be thrown logically");
        }
    }

    /**
     * Return the number of aces a tennis player has scored in all the competitions they have participated in
     *
     * @param player needed player
     * @return list of past aces
     * @throws Exception if a season has no aces data
     */
    private List<Double> getPastAces(TennisPlayer player) throws Exception {
        List<String> competitions = player.getCompetitions();
        List<Double> pastAces = new ArrayList<>();

        for (String competition : competitions) {
            pastAces.add((double) player.getStatAces(competition));
        }
        return pastAces;
    }

    /**
     * Return the number of double faults a tennis player has made in all the competitions they have participated in
     *
     * @param player needed player
     * @return list of past double faults
     * @throws Exception if a season has no double faults data
     */
    private List<Double> getPastDoubleFaults(TennisPlayer player) throws Exception {
        List<String> competitions = player.getCompetitions();
        List<Double> doubleFaults = new ArrayList<>();

        for (String competition : competitions) {
            doubleFaults.add((double) player.getStatDoubleFaults(competition));
        }
        return doubleFaults;
    }

    /**
     * Return the number of aces a tennis player has scored in all the competitions they have participated in
     * @param player needd player
     * @return list of past aces
     * @throws Exception if a season has no break points data
     */
    private List<Double> getPastBreakPointsSaved(TennisPlayer player) throws Exception {
        List<String> competitions = player.getCompetitions();
        List<Double> pastBreakPoints = new ArrayList<>();

        for (String competition : competitions) {
            pastBreakPoints.add((double) player.getStatBreakPointsSaved(competition));
        }
        return pastBreakPoints;
    }

    /**
     * Return the number of first serves a tennis player has made in all the competitions they have participated in
     * @param player needed player
     * @return list of past first serves
     * @throws Exception if a season has no first serves data
     */
    private List<Double> getPastFirstServes(TennisPlayer player) throws Exception {
        List<String> competitions = player.getCompetitions();
        List<Double> pastFirstServes = new ArrayList<>();

        for (String competition : competitions) {
            pastFirstServes.add((double) player.getStatFirstServes(competition));
        }
        return pastFirstServes;
    }

    /**
     * Return the number of serve points a tennis player has scored in all the competitions they have participated in
     * @param player needed player
     * @return list of past serve points
     * @throws Exception if a season has no aces data
     */
    private List<Double> getPastServePoints(TennisPlayer player) throws Exception {
        List<String> competitions = player.getCompetitions();
        List<Double> pastServePoints = new ArrayList<>();

        for (String competition : competitions) {
            pastServePoints.add((double) player.getStatServePoints(competition));
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
