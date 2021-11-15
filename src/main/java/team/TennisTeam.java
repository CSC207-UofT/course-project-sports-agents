package team;

import java.util.List;

import match.Match;

public class TennisTeam extends Team {
    private int totalTournamentsPlayed;
    private int tournamentWins;


    public TennisTeam(){
        super();
    }

    public TennisTeam(String name, String homeCity, List<String> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties, int rank, int totalTournamentsPlayed, int tournamentWins){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties, rank);
        this.totalTournamentsPlayed = totalTournamentsPlayed;
        this.tournamentWins = tournamentWins;
    }

    /**
     * Get total tournaments played
     * @return totalTournamentsPlayed
     */
    public int getTotalTournamentsPlayed(){
        return this.totalTournamentsPlayed;
    }

    /**
     * Set total tournaments played
     * @param totalTournamentsPlayed
     */
    public void setTotalTournamentsPlayed(int totalTournamentsPlayed){
        this.totalTournamentsPlayed = totalTournamentsPlayed;
    }

    /**
     * Get tournament wins
     * @return tournamentWins
     */
    public int getTournamentWins(){
        return this.tournamentWins;
    }

    /**
     * Set tournament wins
     * @param tournamentWins
     */
    public void setTournamentWins(int tournamentWins){
        this.tournamentWins = tournamentWins;
    }
}