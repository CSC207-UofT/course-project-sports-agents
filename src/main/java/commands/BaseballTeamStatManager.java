package commands;

import team.Team;
import team.BaseballTeam;
import team.TeamManager;
import team.TeamStats;

public class BaseballTeamStatManager extends TeamStatManager {
    public BaseballTeamStatManager(TeamManager teamManager){
        super(teamManager);
    }

    public float getStat(String teamName, TeamStats teamStat) {
        float retrievedStat = super.getStat(teamName, teamStat);
        
        if(retrievedStat != -5 && retrievedStat != -1){
            return retrievedStat;
        }
        if(retrievedStat == -5){
            Team team = teamManager.findTeamWithName(teamName);
            if (team != null) {
                switch (teamStat) {
                    case GAMES_STARTED:
                        return ((BaseballTeam) team).getGamesStarted();
                    case COMPLETE_GAMES:
                        return ((BaseballTeam) team).getCompleteGames();
                    case SHUTOUTS:
                        return ((BaseballTeam) team).getShutouts();
                    case SAVES:
                        return ((BaseballTeam) team).getSaves();
                    case SAVE_OPPORTUNITIES:
                        return ((BaseballTeam) team).getSaveOpportunities();
                    case INNINGS_PITCHED:
                        return ((BaseballTeam) team).getInningsPitched();
                    case RUNS_ALLOWED:
                        return ((BaseballTeam) team).getRunsAllowed();
                    case EARNED_RUNS:
                        return ((BaseballTeam) team).getEarnedRuns();
                    case HOME_RUNS_ALLOWED:
                        return ((BaseballTeam) team).getHomeRunsAllowed();
                    case HIT_BATSMEN:
                        return ((BaseballTeam) team).getHitBatsmen();
                    case AT_BATS:
                        return ((BaseballTeam) team).getAtBats();
                    case RUNS:
                        return ((BaseballTeam) team).getRuns();
                    case HITS:
                        return ((BaseballTeam) team).getHits();
                    case DOUBLES:
                        return ((BaseballTeam) team).getDoubles();
                    case TRIPLES:
                        return ((BaseballTeam) team).getTriples();
                    case HOME_RUNS:
                        return ((BaseballTeam) team).getHomeRuns();
                    case RUN_BATTED_IN:
                        return ((BaseballTeam) team).getRunBattedIn();
                    case WALKS:
                        return ((BaseballTeam) team).getWalks();
                    case STRIKEOUTS:
                        return ((BaseballTeam) team).getStrikeouts();
                    case STOLEN_BASES:
                        return ((BaseballTeam) team).getStolenBases();
                    case CAUGHT_STEALING:
                        return ((BaseballTeam) team).getCaughtStealing();
                    default:
                        return -5;
                }
            }
        }
        return -1;
    }

    /**
     * Parses the input text into an enum
     *
     * @param stat stat being queried
     * @return If the stat exists returns enum, otherwise returns null
     */
    public TeamStats parseStat(String stat) {
        TeamStats retrieveStat = super.parseStat(stat);
        
        if(retrieveStat != null){
            return retrieveStat;
        }
        switch (stat.toLowerCase()) {
            case "games started":
                return TeamStats.GAMES_STARTED;
            case "complete games":
                return TeamStats.COMPLETE_GAMES;
            case "shutouts":
                return TeamStats.SHUTOUTS;
            case "saves":
                return TeamStats.SAVES;
            case "save opportunities":
                return TeamStats.SAVE_OPPORTUNITIES;
            case "innings pitched":
                return TeamStats.INNINGS_PITCHED;
            case "runs allowed":
                return TeamStats.RUNS_ALLOWED;
            case "earned runs":
                return TeamStats.EARNED_RUNS;
            case "home runs allowed":
                return TeamStats.HOME_RUNS_ALLOWED;
            case "hit batsmen":
                return TeamStats.HIT_BATSMEN;
            case "at bats":
                return TeamStats.AT_BATS;
            case "runs":
                return TeamStats.RUNS;
            case "hits":
                return TeamStats.HITS;
            case "doubles":
                return TeamStats.DOUBLES;
            case "triples":
                return TeamStats.TRIPLES;
            case "home runs":
                return TeamStats.HOME_RUNS;
            case "run batted in":
                return TeamStats.RUN_BATTED_IN;
            case "walks":
                return TeamStats.WALKS;
            case "strikeouts":
                return TeamStats.STRIKEOUTS;
            case "stolen bases":
                return TeamStats.STOLEN_BASES;
            case "caught stealing":
                return TeamStats.CAUGHT_STEALING;
            default:
                return null;
        }
    }
}
