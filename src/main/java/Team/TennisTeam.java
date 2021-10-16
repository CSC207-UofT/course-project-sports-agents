package Team;

import Player.Player;
import Team.Team;

import java.util.ArrayList;

public class TennisTeam extends Team {
    public TennisTeam(){
        super();
    }

    public TennisTeam(String name, String homeCity, ArrayList<Player> players, ArrayList<Game> playedGames, int totalGamesPlayed, int wins, int losses, int ties){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties);
    }
}
