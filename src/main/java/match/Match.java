package match;

import league_member.LeagueMember;

import java.util.ArrayList;
import java.util.HashMap;


public class Match {
    // TODO: Need to make the Member class hashable or find a different implementation
    private HashMap<LeagueMember, String> bets;
    private final String teamA, teamB;
    private int scoreA, scoreB;

    public Match(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = 0;
        this.scoreB = 0;
        bets = new HashMap<LeagueMember, String>();
    }

    public String getTeamA() {
        return this.teamA;
    }

    public String getTeamB() {
        return this.teamB;
    }

    public int getScoreA() {
        return this.scoreA;
    }

    public int getScoreB() {
        return this.scoreB;
    }

    public void setScoreA(int s) {
        this.scoreA = s;
    }

    public void setScoreB(int s) {
        this.scoreB = s;
    }
    public String getWinningTeam() {
        if (this.scoreA == this.scoreB) {
            return "";
        } else if (this.scoreA > this.scoreB) {
            return this.teamA;
        } else {
            return this.teamB;
        }
    }


    public Boolean addBet(LeagueMember m, String team){
        /* Bet includes a member name and their team they bet on */
        if (team.equals(this.teamA)||team.equals(this.teamB)) {
            this.bets.put(m, team);
            return true;
        }
        return false;


    }

    public HashMap<LeagueMember, String> getBets() {
        return this.bets;
    }


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

    public void resolve(String winner) {
        // TODO: Make sure to check that the winner is valid, i.e. it's either team a or team b, also can be a tie
        for (HashMap.Entry<LeagueMember, String> set: bets.entrySet()) {
            if (set.getValue().equals(winner)) {
                set.getKey().recordCorrectBet();
            }
            else {
                set.getKey().recordIncorrectBet();
            }
        }
    }


}