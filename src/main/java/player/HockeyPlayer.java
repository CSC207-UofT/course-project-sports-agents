package player;

import java.util.HashMap;
import java.util.Map;
/**
 * A player Class.
 */
public class HockeyPlayer extends Player {
    public final String season;
    public final String team;
    public final String skaterShoots;
    public final String position;
    public final String gamesPlayed;
    public final String goals;
    public final String assists;
    public final String points;
    public final String shots;
    public final String shootingPercentage;

    public HockeyPlayer(String name, String season, String team, String skaterShoots, String position,
                        String gamesPlayed, String goals, String assists, String points, String shots,
                        String shootingPercentage) {
        super(name);
        this.season = season;
        this.team = team;
        this.skaterShoots = skaterShoots;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.shots = shots;
        this.shootingPercentage = shootingPercentage;
    }

    public String getStat(String stat) throws Exception {
        Map<String, String> listAllSats = this.mapStats();
        if (!listAllSats.containsKey(stat)) {
            throw new Exception("Demanded statistics not found!");
        } else {
            return listAllSats.get(stat);
        }
    }

    public Map<String, String> mapStats() {
        Map<String, String> listAllStats = new HashMap<>(Map.of("name",
                this.name, "season", this.season, "team", this.team,
                "skater shoots", this.skaterShoots, "position", this.position,
                "games played", this.gamesPlayed, "goals", this.goals, "assists",
                this.assists, "points", this.points, "shots", this.shots));
        listAllStats.put("shooting percentage", this.shootingPercentage);
        return listAllStats;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\nseason: " + this.season + "\nteam: " +
                this.team + "\nskater shoots: " + this.skaterShoots + "\nposition: " +
                this.position + "\ngames played: " + this.gamesPlayed + "\ngoals: " +
                this.goals + "\nassists: " + this.assists + "\npoints: " + this.points +
                "\nshots: " + this.shots + "\nshooting percentage: " + this.shootingPercentage + "\n";
    }
}
