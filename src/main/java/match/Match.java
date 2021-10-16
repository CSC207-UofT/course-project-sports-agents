package match;

import java.util.ArrayList;
import java.util.HashMap;
import member.Member;



public abstract class Match {
    private HashMap<Member, String> Bets;
    private String teamA, teamB;
    private int scoreA, scoreB;

    public Match(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = 0;
        this.scoreB = 0;
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


    public Boolean AddBet(Member m, String team){
        /* Bet includes a member name and their team they bet on */
        if (team.equals(this.teamA)||team.equals(this.teamB)) {
            this.Bets.put(m, team);
            return true;
        }
        return false;


    }

    public HashMap<Member, String> getBets() {
        return this.Bets;
    }


    public ArrayList<Member> getBetWinners() {
        ArrayList<Member> winners = new ArrayList<Member>();
        for (Member m : this.Bets.keySet()) {
            if (this.Bets.get(m).equals(getWinningTeam())) {
                winners.add(m);
            }
        }
        return winners;
    }

    public int getNumBetWinners() {
        return getBetWinners().size();
    }


}