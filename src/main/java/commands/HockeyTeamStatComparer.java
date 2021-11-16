package commands;

import commands.TeamStatManager;
import commands.HockeyTeamStatManager;
import team.TeamStats;

public class HockeyTeamStatComparer extends TeamStatComparer {
    public HockeyTeamStatComparer(TeamStatManager teamStatManager) {
        super(teamStatManager);
    }

    public int compareStats(String team1, String team2, TeamStats teamStat){
        float s1 = ((HockeyTeamStatManager) teamStatManager).getStat(team1, teamStat);
        float s2 = ((HockeyTeamStatManager) teamStatManager).getStat(team2, teamStat);
        return compare(s1, s2);
    }
}
