package fantasyLeague;

import java.io.Serializable;
import java.util.ArrayList;


public class Match implements Serializable {
    private final ArrayList<LeagueMember> teamABetters;
    private final ArrayList<LeagueMember> teamBBetters;
    private final String teamA;
    private final String teamB;

    /**
     * Create a new Match with the teams given
     *
     * @param teamA the home team competing
     * @param teamB the visiting team competing
     */
    public Match(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamABetters = new ArrayList<>();
        this.teamBBetters = new ArrayList<>();
    }

    /**
     * Record a new bet on the Match's outcome
     *
     * @param m    the League Member who placed the bet
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

    /**
     * Resolve the Match and note which League Members bet
     * correctly and Incorrectly
     *
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
     *
     * @param correctBetters the correctly betting LeagueMembers
     */
    private void awardCorrectBet(ArrayList<LeagueMember> correctBetters) {
        for (LeagueMember better : correctBetters) {
            better.recordCorrectBet();
        }
    }

    /**
     * Record an incorrect bet for a list of LeagueMembers
     *
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
     *
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
     *
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