package commands;

import java.util.ArrayList;

import team.TeamConstants;
import team.TeamStats;

public class TeamStatComparer implements Command, TeamConstants {
    private TeamStatManager teamStatManager;
    private final int TEAM_NAME_1_SLOT = 0;
    private final int TEAM_NAME_2_SLOT = 1;
    private final int REQUESTED_STAT_SLOT = 2;

    public TeamStatComparer(TeamStatManager teamStatManager){
        this.teamStatManager = teamStatManager;
    }

    /**
     * Compares the stats of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareStats(String team1, String team2, TeamStats teamStat){
        float s1 = teamStatManager.getStat(team1, teamStat);
        float s2 = teamStatManager.getStat(team2, teamStat);
        if(s1 > s2){
            return 1;
        }else if(s1 < s2){
            return 2;
        }else{
            return 0;
        }
    }

    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String teamName1 = arguments.get(TEAM_NAME_1_SLOT);
        String teamName2 = arguments.get(TEAM_NAME_2_SLOT);
        String requestedStat = arguments.get(REQUESTED_STAT_SLOT);

        if(requestedStat == KEY_ALL_STATS){
            return null;//getAllStats(teamName);
        }else{
            TeamStats parsedStat = teamStatManager.parseStat(requestedStat);
            
            if(parsedStat == null){
                throw new Exception("Stat does not exist");
            }
            return String.valueOf(compareStats(teamName1, teamName2, parsedStat));
        }
    }
}
