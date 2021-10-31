package player;

import java.util.*;

public class BaseballPlayer extends Player {

    public String team;
    public String season;
    public String position;
    public String age;
    public String gamesPlayed;
    public String atBats;
    public String runs;
    public String hits;
    public String homeRuns;
    public String runsBattedIn;
    public String strikeOuts;
    public String avg;

    /**
     *  @param name player's name
     * @param team player's team
     * @param season player's season
     * @param position player's position in the team.
     * @param age player's age
     * @param gamesPlayed The number of games the player has played in the season.
     * @param atBats trips to the plate that don't result in a walk, hit by patch, sacrifice, or reach on interference.
     * @param runs number of runs whenever a base runner safely reaches home plate and scores
     * @param hits number of ball hits.
     * @param homeRuns number of runs whenever a bat reaches on a hit, touches all bases, and scores a run whithout a
*                putout recorded or the benefit of error.
     * @param runsBattedIn number of runs that are scored because of the batter's safe hit.
     * @param strikeOuts number when the umpire calls three strikes on the batter.
     * @param avg the rate of hits per at bat.
     */
    public BaseballPlayer(String name, String team, String season,
                          String position, String age, String gamesPlayed,
                          String atBats, String runs, String hits, String homeRuns,
                          String runsBattedIn, String strikeOuts, String avg) {
        super(name);
        this.team = team;
        this.season = season;
        this.position = position;
        this.age = age;
        this.gamesPlayed = gamesPlayed;
        this.atBats = atBats;
        this.runs = runs;
        this.hits = hits;
        this.homeRuns = homeRuns;
        this.runsBattedIn = runsBattedIn;
        this.strikeOuts = strikeOuts;
        this.avg = avg;
    }


    public String getNeededStat(String stat) throws Exception {
        Map<String, String> listAllSats = this.mapStats();
        if (!listAllSats.containsKey(stat)) {
            throw new Exception("Demanded statistics "+ stat+" not found!");
        } else {
            return listAllSats.get(stat);
        }
    }

    public Map<String, String> mapStats() {
        Map<String, String> listAllStats = new HashMap<>(Map.of("name",
                this.name, "team", this.team, "season", this.season,
                "position", this.position, "age", this.age,
                "games played", this.gamesPlayed, "at bats", this.atBats, "runs",
                this.runs, "hits", this.hits, "home runs", this.homeRuns));
        listAllStats.put("home runs", this.homeRuns);
        listAllStats.put("strikeouts", this.strikeOuts);
        return listAllStats;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\nteam: " + this.team + "\nseason: " +
                this.season + "\nposition: " + this.position + "\nage: " +
                this.age + "\ngames played: " + this.gamesPlayed + "\nat bats: " +
                this.atBats + "\nruns: " + this.runs + "\nhits: " + this.hits +
                "\nhome runs: " + this.homeRuns + "\nruns batted in: " + this.runsBattedIn + "\nstrikeouts: " +
                this.strikeOuts+ "\nbatting average: "+ this.avg + "\n";
    }
}
