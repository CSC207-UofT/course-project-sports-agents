package team;

import player.Player;
import match.Match;

import java.util.List;

public class TennisTeam extends Team {
    public TennisTeam(){
        super();
    }

    public TennisTeam(String name, String homeCity, List<Player> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties);
    }
}
