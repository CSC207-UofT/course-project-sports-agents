package player;

import java.util.*;

/**
 * This class represents a tennis player.
 */

public class TennisPlayer extends Player {
    private int age;
    private final String country;
    private int aces;
    private int doubleFaults;
    private int servePoints;
    private int firstServes;
    private int breakPointsSaved;

    /**
     * Construct a tennis player with the following information specified
     * @param name player's name
     * @param age player's age
     * @param country IOC code for this player's country
     * @param aces number of aces made by this player
     * @param servePoints number of serve points won by this player
     * @param firstServes number of first serves made by this player
     * @param breakPointsSaved number of break points saved
     */
    public TennisPlayer(String name, int age, String country, int aces, int doubleFaults,
                        int servePoints, int firstServes, int breakPointsSaved) {
        super(name);
        this.age = age;
        this.country = country;
        this.aces = aces;
        this.doubleFaults = doubleFaults;
        this.servePoints = servePoints;
        this.firstServes = firstServes;
        this.breakPointsSaved = breakPointsSaved;
    }


    /**
     * Construct a tennis player who has participated in 0 rounds, and has 0 sets won and lost,
     * and 0 games won and lost
     * @param name player's name
     * @param age player's age
     * @param country player's country
     */
    public TennisPlayer(String name, int age, String country) {
        super(name);
        this.age = age;
        this.country = country;
        this.aces = 0;
        this.doubleFaults = 0;
        this.servePoints = 0;
        this.firstServes = 0;
        this.breakPointsSaved = 0;
    }


    /**
     * Record this player's age
     * @param age the player's age
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Return this player's age
     * @return player's age
     */
    public int getAge() {
        return this.age;
    }


    /**
     * Return this player's country
     * @return player's country
     */
    public String getCountry() {
        return this.country;
    }


    /**
     * Record the number of aces made by this player
     * @param aces number of aces made
     */
    public void setAces(int aces) {
        this.aces = aces;
    }


    /**
     * Update the number of aces made by this player
     * @param aces number of new aces made by player
     */
    public void updateAces(int aces) {
        this.aces = this.aces + aces;
    }


    /**
     * Return the number of aces made by this player
     * @return number of aces made
     */
    public int getAces() {
        return this.aces;
    }


    /**
     * Record the number of double faults by this player
     * @param doubleFaults number of double faults made by this player
     */
    public void setDoubleFaults(int doubleFaults) {
        this.doubleFaults = doubleFaults;
    }


    /**
     * Update the number of double faults made by this player
     * @param doubleFaults number of new double faults made by this player
     */
    public void updateDoubleFaults(int doubleFaults) {
        this.doubleFaults = this.doubleFaults + doubleFaults;
    }


    /**
     * Return the number of double faults made by this player
     * @return number of double faults made
     */
    public int getDoubleFaults() {
        return this.doubleFaults;
    }


    /**
     * Record the number of serve points won by this player
     * @param servePoints number of serve points
     */
    public void setServePoints(int servePoints) {
        this.servePoints = servePoints;
    }


    /**
     * Update the number of serve points won by this player
     * @param servePoints number of new serve points won by this player
     */
    public void updateServePoints(int servePoints) {
        this.servePoints = this.servePoints + servePoints;
    }


    /**
     * Return the number of serve points won by this player
     * @return number of serve points won
     */
    public int getServePoints() {
        return this.servePoints;
    }


    /**
     * Record the number of first serves by this player
     * @param firstServes number of first serves
     */
    public void setFirstServes(int firstServes) {
        this.firstServes = firstServes;
    }


    /**
     * Update the number of first serves made by this player
     * @param firstServes number of first serves made by this player
     */
    public void updateFirstServes(int firstServes) {
        this.firstServes = this.firstServes + firstServes;
    }


    /**
     * Return the number of first serves by this player
     * @return number of first serves made
     */
    public int getFirstServes() {
        return this.firstServes;
    }


    /**
     * Record the number of break points saved by this player
     * @param breakPointsSaved number of break points saved
     */
    public void setBreakPointsSaved(int breakPointsSaved) {
        this.breakPointsSaved = breakPointsSaved;
    }


    /**
     * Update the number of break points saved by this player
     * @param breakPointsSaved number of new break points saved
     */
    public void updateBreakPointsSaved(int breakPointsSaved) {
        this.breakPointsSaved = this.breakPointsSaved + breakPointsSaved;
    }


    /**
     * Return the number of break points saved by this player
     * @return number of break points saved
     */
    public int getBreakPointsSaved() {
        return this.breakPointsSaved;
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

    public Map<String, String> mapStats(){
        return new HashMap<>(Map.of("name",
                this.name, "age", String.valueOf(this.age), "country", this.country,
                "aces", String.valueOf(this.aces), "double faults", String.valueOf(this.doubleFaults),
                "serve points", String.valueOf(this.servePoints), "first serves",
                String.valueOf(this.firstServes), "break points saved",
                String.valueOf(this.breakPointsSaved)));
    }


    public String getNeededStat(String stat) throws Exception {
        Map<String, String> listAllSats = this.mapStats();
        if (!listAllSats.containsKey(stat)) {
            throw new Exception("Demanded statistics "+ stat+" not found!");
        } else {
            return listAllSats.get(stat);
        }
    }


//    public String getNeededStat(String stat) {
//        switch (stat) {
//            case "aces":
//                return String.valueOf(this.aces);
//            case "double faults":
//                return String.valueOf(this.doubleFaults);
//            case "serve points":
//                return String.valueOf(this.servePoints);
//            case "first serves":
//                return String.valueOf(this.firstServes);
//            case "break points saved":
//                return String.valueOf(this.breakPointsSaved);
//            case "age":
//                return String.valueOf(this.age);
//        }
//        return this.country;
//    }


}
