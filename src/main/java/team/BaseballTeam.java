package team;

import player.Player;
import match.Match;

import java.util.List;

public class BaseballTeam extends Team {
    public BaseballTeam(String name, String homeCity, List<Player> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties);
    }
}
