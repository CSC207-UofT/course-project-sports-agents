package match;

import leagueMember.LeagueMember;

import java.io.Serializable;
import java.util.ArrayList;


public class Match implements Serializable {
    private ArrayList<LeagueMember> teamABetters;
    private ArrayList<LeagueMember> teamBBetters;
    private final String teamA;
    private final String teamB;
    // TODO: Implement updating score of games and resolving that way
    private int scoreA;
    private int scoreB;

    /**
     * Create a new Match with the teams given
     * @param teamA the home team competing
     * @param teamB the visiting team competing
     */
    public Match(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = 0;
        this.scoreB = 0;
        this.teamABetters = new ArrayList<LeagueMember>();
        this.teamBBetters = new ArrayList<LeagueMember>();
    }

    /**
     * @return team A, the home team
     */
    public String getTeamA() {
        return this.teamA;
    }

    /**
     * @return team B, the visiting team
     */
    public String getTeamB() {
        return this.teamB;
    }

    /**
     * @return Team A's current score
     */
    public int getScoreA() {
        return this.scoreA;
    }

    /**
     * @return Team B's current score
     */
    public int getScoreB() {
        return this.scoreB;
    }

    /**
     * Set Team A's score to the given number
     * @param s Team A's new score
     */
    public void setScoreA(int s) {
        this.scoreA = s;
    }

    /**
     * Set Team B's score to the given number
     * @param s Team B's new score
     */
    public void setScoreB(int s) {
        this.scoreB = s;
    }

    /**
     * Get the winning team based on current score
     * @return
     */
    public String getWinningTeam() {
        if (this.scoreA == this.scoreB) {
            return "";
        } else if (this.scoreA > this.scoreB) {
            return this.teamA;
        } else {
            return this.teamB;
        }
    }

    /**
     * Record a new bet on the Match's outcome
     * @param m the League Member who placed the bet
     * @param team the team predicted to win
     * @throws Exception if team is not a team in the game
     */
    public void addBet(LeagueMember m, String team) throws Exception {
        if (team.equals(this.teamA)) {
            this.teamABetters.add(m);
        } else if (team.equals(this.teamB)) {
            this.teamBBetters.add(m);
        } else {
            throw new Exception(team + " is not a Team in this Match!");
        }
    }

    /*
    This is based on an old implementation and is not currently used
    elsewhere in the code. However, it should be implemented later

    public ArrayList<LeagueMember> getBetWinners() {
        ArrayList<LeagueMember> winners = new ArrayList<LeagueMember>();
        for (LeagueMember m : this.bets.keySet()) {
            if (this.bets.get(m).equals(getWinningTeam())) {
                winners.add(m);
            }
        }
        return winners;
    }

    public int getNumBetWinners() {
        return getBetWinners().size();
    }
     */

    /**
     * Resolve the Match and note which League Members bet
     * correctly and Incorrectly
     * @param winningTeam the team which won the Match
     * @throws Exception if winningTeam is not in the Match
     */
    public void resolve(String winningTeam) throws Exception {
        if (winningTeam.equals(this.teamA)) {
            awardCorrectBet(this.teamABetters);
            awardIncorrectBet(this.teamBBetters);
        } else if (winningTeam.equals(this.teamB)) {
            awardCorrectBet(this.teamBBetters);
            awardIncorrectBet(this.teamABetters);
        } else {
            throw new Exception(winningTeam + "is not a Team in this Match!");
        }

    }

    /**
     * Record a correct bet for a list of LeagueMembers
     * @param correctBetters the correctly betting LeagueMembers
     */
    private void awardCorrectBet(ArrayList<LeagueMember> correctBetters) {
        for (LeagueMember better : correctBetters) {
            better.recordCorrectBet();
        }
    }

    /**
     * Record an incorrect bet for a list of LeagueMembers
     * @param incorrectBetters the incorrectly betting LeagueMembers
     */
    private void awardIncorrectBet(ArrayList<LeagueMember> incorrectBetters) {
        for (LeagueMember better : incorrectBetters) {
            better.recordIncorrectBet();
        }
    }

    /**
     * Matches are defined based on the home and visiting team.
     * Check equality based on this.
     * @param other another object to compare this with
     * @return true if other is a Match with the same home and visiting team
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }

        Match otherMatch = (Match) other;
        return (this.teamA.equals(otherMatch.teamA) &&
                this.teamB.equals(otherMatch.teamB));
    }

    /**
     * Override hashCode, for use in LeagueMemberManager
     * @return the hashCode for team A plus the hashCode for teamB
     */
    @Override
    public int hashCode() {
        return this.teamA.hashCode() + this.teamB.hashCode();
    }

    @Override
    public String toString() {
        return "Match between " + this.teamA + " and " + this.teamB;
    }

}