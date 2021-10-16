import java.util.ArrayList;

public class HockeyTeam extends Team {
    public HockeyTeam(){
        super();
    }

    public HockeyTeam(String name, String homeCity, ArrayList<Player> players, ArrayList<Game> playedGames, int totalGamesPlayed, int wins, int losses, int ties){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties);
    }
}
