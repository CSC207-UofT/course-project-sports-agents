package team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import match.Match;
import player.Player;

public abstract class Team {

    protected final String name;
    protected final List<String> seasons;

    public Team(String name) {
        this.name = name;
        this.seasons = new ArrayList<>();
    }

    /**
     * Precondition: seasons has all seasons in correct order
     * @return list of seasons the team has participated in
     */
    public List<String> getSeasons() {
        return this.seasons;
    }

    /**
     * Add a new season to the list of seasons
     * Assumes given season is the newest
     * @param season new season to record
     */
    public void addSeason(String season) {
        if (!this.seasons.contains(season)) {
            this.seasons.add(season);
        }
    }

    /**
     * Return this team's name
     * @return player's name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Check if a map containing statistics has a record for a given season
     * @param dataMap the map to check
     * @param season the season to check for
     * @param expected the expectation for if data is stored
     * @throws Exception if the expectation is violated
     */
    public void checkForSeason(Map dataMap, String season,
                               boolean expected) throws Exception {
        if (dataMap.containsKey(season) != expected) {
            // We expect data, but there is none
            if (expected) {
                throw new Exception("Information on " + season +
                        " is not recorded!");
            }
            // We expect nothing, but there is data
            else {
                throw new Exception("Information on " + season +
                        " already exists!");
            }
        }
    }

    /**
     * Create a string representation of this team
     * @return team in string representation
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Compare two teams to check if they are equal
     * @param obj another player
     * @return true if the two teams are the same, and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Team other = (Team) obj;
        return this.name.equals(other.name);
    }

    /**
     * Implement hashCode, for using Players in hashmaps
     * @return hashCode of player name
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }


}