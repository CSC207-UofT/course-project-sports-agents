package player;

import java.util.HashMap;
import java.util.Map;
/**
 * A player Class.
 */
public class HockeyPlayer extends Player {
    public String season;
    public String team;
    public String skaterShoots;
    public String position;
    public String gamesPlayed;
    public String goals;
    public String assists;
    public String points;
    public String shots;
    public String shootingPercentage;

    /**
     *
     * @param name player's name
     * @param season player's season
     * @param team player's team
     * @param skaterShoots either left or right.
     * @param position player's position in the team.
     * @param gamesPlayed The number of games the player has played in the season.
     * @param goals number of player's goals.
     * @param assists number of player's assists.
     * @param points number of player's points.
     * @param shots number of player's shots.
     * @param shootingPercentage the percentage of the shooting of the skater.
     */
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

    public String getNeededStat(String stat) throws Exception {
        Map<String, String> listAllSats = this.mapStats();
        if (!listAllSats.containsKey(stat)) {
            throw new Exception("Demanded statistics "+ stat+" not found!");
        } else {
            return listAllSats.get(stat);
        }
    }

    public Map<String, String> mapStats(){
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
