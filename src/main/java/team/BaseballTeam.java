package team;

import java.util.List;

import match.Match;

public class BaseballTeam extends Team {
    public BaseballTeam(String name, String homeCity, List<String> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties, int rank){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties, rank);
    }
}
