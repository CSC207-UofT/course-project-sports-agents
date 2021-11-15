package commands;

import player.*;
import java.util.*;

/**
 * A class that will predict a tennis player's future performance for a given stat.
 */
public class TennisPlayerStatPredictor extends PlayerStatPredictor {
    private final TennisPlayerList tennisPlayerList;
    static final int PLAYER_NAME = 2;
    static final int STAT = 3;

    public TennisPlayerStatPredictor(TennisPlayerList tennisPlayerList) {
        super(new HashSet<>(Arrays.asList("Aces", "Double Faults", "First Serves",
                "Break Points Saved", "Serve Points")));
        this.tennisPlayerList = tennisPlayerList;
    }


    /**
     * Make a prediction for the given player on the given stat using linear regression
     *
     * @param arguments is a list of strings in the format ["command", "sport", "player name", "stat"]
     * @return the prediction of the stat based on historical data
     * @throws Exception when the player name is not found or the demanded stat is invalid.
     */
    @Override
    public String execute(List<String> arguments) throws Exception {
        String stat = arguments.get(STAT);
        String name = arguments.get(PLAYER_NAME);
        this.checkStatistic(stat);

        // Find the needed tennis player from list of tennis players
        TennisPlayer neededPlayer = this.tennisPlayerList.getPlayer(name);

        List<String> competitions = this.tennisPlayerList.getSeasons();
        Map<String, Integer> competitionValues = this.getSeasonToIntsMap(competitions);


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
}
