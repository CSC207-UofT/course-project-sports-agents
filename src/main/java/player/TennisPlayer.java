package player;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a tennis player.
 */

public class TennisPlayer extends Player {
    private final Map<String, Integer> age;
    private final String country;
    private final Map<String, Integer> aces;
    private final Map<String, Integer> doubleFaults;
    private final Map<String, Integer> servePoints;
    private final Map<String, Integer> firstServes;
    private final Map<String, Integer> breakPointsSaved;


    /**
     * Construct a tennis player who has not participated in any competitions yet
     * @param name player's name
     * @param country player's country
     */
    public TennisPlayer(String name, String country) {
        super(name);
        this.age = new HashMap<>();
        this.country = country;
        this.aces = new HashMap<>();
        this.doubleFaults = new HashMap<>();
        this.servePoints = new HashMap<>();
        this.firstServes = new HashMap<>();
        this.breakPointsSaved = new HashMap<>();
    }


    /**
     * Return this player's age for the given competition
     * @param competition the needed competition
     * @return player's age
     */
    public int getAge(String competition) {
        return this.age.get(competition);
    }


    /**
     * Record the player's age during a competition
     * @param competition the new competition the player participated in
     * @param age the player's age during that competition
     */
    public void setAge(String competition, int age) {
        this.age.put(competition, age);
    }


    /**
     * Return this player's country
     * @return player's country
     */
    public String getCountry() {
        return this.country;
    }


    /**
     * Record the number of aces made by this player for a given competition
     * @param competition the new competition the player participated in
     * @param aces number of aces made
     */
    public void setAces(String competition, int aces) {
        this.aces.put(competition, aces);
    }


    /**
     * Update the number of aces made by this player
     * @param competition the needed competition
     * @param aces number of new aces made by player
     */
    public void updateAces(String competition, int aces) {
        int oldAces = this.aces.get(competition);
        this.aces.put(competition, oldAces + aces);
    }


    /**
     * Return the number of aces made by this player for a given competition
     * @param competition the needed competition
     * @return number of aces made during the given competition
     */
    public int getAces(String competition) {
        return this.aces.get(competition);
    }


    /**
     * Record the number of double faults by this player during a competition
     * @param competition the new competition to be recorded
     * @param doubleFaults number of double faults made by this player
     */
    public void setDoubleFaults(String competition, int doubleFaults) {
        this.doubleFaults.put(competition, doubleFaults);
    }


    /**
     * Update the number of double faults made by this player
     * @param competition the needed competition
     * @param doubleFaults number of new double faults made by this player
     */
    public void updateDoubleFaults(String competition, int doubleFaults) {
        int oldDoubleFaults = this.doubleFaults.get(competition);
        this.doubleFaults.put(competition, oldDoubleFaults + doubleFaults);
    }


    /**
     * Return the number of double faults made by this player during a given competition
     * @param competition the needed competition
     * @return number of double faults made
     */
    public int getDoubleFaults(String competition) {
        return this.doubleFaults.get(competition);
    }


    /**
     * Record the number of serve points won by this player during a competition
     * @param competition the new competition to be recorded
     * @param servePoints number of serve points
     */
    public void setServePoints(String competition, int servePoints) {
        this.servePoints.put(competition, servePoints);
    }


    /**
     * Update the number of serve points won by this player
     * @param competition the needed competition
     * @param servePoints number of new serve points won by this player
     */
    public void updateServePoints(String competition, int servePoints) {
        int oldServePoints = this.servePoints.get(competition);
        this.servePoints.put(competition, oldServePoints + servePoints);
    }


    /**
     * Return the number of serve points won by this player for the given competition
     * @return number of serve points won
     */
    public int getServePoints(String competition) {
        return this.servePoints.get(competition);
    }


    /**
     * Record the number of first serves by this player for the given competition
     * @param competition the new competition to be recorded
     * @param firstServes number of first serves
     */
    public void setFirstServes(String competition, int firstServes) {
        this.firstServes.put(competition, firstServes);
    }


    /**
     * Update the number of first serves made by this player for a competition
     * @param competition the needed competition
     * @param firstServes number of first serves made by this player
     */
    public void updateFirstServes(String competition, int firstServes) {
        int oldFirstServes = this.firstServes.get(competition);
        this.firstServes.put(competition, oldFirstServes + firstServes);
    }


    /**
     * Return the number of first serves by this player at a competition
     * @param competition the needed competition
     * @return number of first serves made
     */
    public int getFirstServes(String competition) {
        return this.firstServes.get(competition);
    }


    /**
     * Record the number of break points saved by this player for a competition
     * @param competition the new competition to be recorded
     * @param breakPointsSaved number of break points saved
     */
    public void setBreakPointsSaved(String competition, int breakPointsSaved) {
        this.breakPointsSaved.put(competition, breakPointsSaved);
    }


    /**
     * Update the number of break points saved by this player
     * @param competition the needed competition
     * @param breakPointsSaved number of new break points saved
     */
    public void updateBreakPointsSaved(String competition, int breakPointsSaved) {
        int oldBreakPointsSaved = this.breakPointsSaved.get(competition);
        this.breakPointsSaved.put(competition, oldBreakPointsSaved + breakPointsSaved);
    }


    /**
     * Return the number of break points saved by this player
     * @param competition the needed competition
     * @return number of break points saved
     */
    public int getBreakPointsSaved(String competition) {
        return this.breakPointsSaved.get(competition);
    }


    /**
     * Add a competition to all maps for this player if the competition cannot be found in a map; all maps for this
     * player have the same competitions
     * @param competition the new competition to be added
     * @param age the player's age during the given competition
     */
    public void addCompetition(String competition, int age) {
        if (!(this.age.containsKey(competition))) {
            this.age.put(competition, age);
            this.aces.put(competition, 0);
            this.doubleFaults.put(competition, 0);
            this.servePoints.put(competition, 0);
            this.firstServes.put(competition, 0);
            this.breakPointsSaved.put(competition, 0);
        }
    }


    /**
     * Return a string representation of this tennis player
     * @return tennis player string
     */
    @Override
    public String toString() {
        String partOne = super.toString();
        return partOne + "\nAge: " + this.age + "\nNationality: " + this.country + "\nAces: " + this.aces +
                "\nDouble Faults: " + this.doubleFaults + "\nServe Points: " + this.servePoints +
                "\nFirst Serves: " + this.firstServes + "\nBreak Points Saved: " + this.breakPointsSaved;
    }


    /**
     * Return this player's data for a given competition in string format
     * @param competition the needed competition
     * @return string of player's data for given competition
     */
    public String printCompetitionData(String competition) {
        String partOne = super.toString();
        return partOne + "\nAge: " + this.age.get(competition) + "\nNationality: " + this.country + "\nAces: "
                + this.aces.get(competition) + "\nDouble Faults: " + this.doubleFaults.get(competition) +
                "\nServe Points: " + this.servePoints.get(competition) + "\nFirst Serves: " +
                this.firstServes.get(competition) + "\nBreak Points Saved: " + this.breakPointsSaved.get(competition);
    }


     /**
     * Return the given comparable stat, assuming the given stat is a possible stat associated with a tennis player.
     * @param stat stat that needs to be reported (possible stats include aces, dauble faults, serve points,
     *             first serves, age, and country
     * @return the needed stat of the player (as a string)
     */
    public Map<String, Integer> getNeededStat(String stat) throws Exception {
        switch (stat) {
            case "aces":
                return this.aces;
            case "age":
                return this.age;
            case "double faults":
                return this.doubleFaults;
            case "serve points":
                return this.servePoints;
            case "first serves":
                return this.firstServes;
            case "break points saved":
                return this.breakPointsSaved;
        }
        throw new Exception("Invalid stat!");
    }



}
