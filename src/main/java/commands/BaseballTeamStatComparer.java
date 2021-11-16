package commands;

import commands.TeamStatManager;
import commands.BaseballTeamStatManager;
import team.TeamStats;

public class BaseballTeamStatComparer extends TeamStatComparer {
    public BaseballTeamStatComparer(TeamStatManager teamStatManager) {
        super(teamStatManager);
    }

    public int compareStats(String team1, String team2, TeamStats teamStat){
        float s1 = ((BaseballTeamStatManager) teamStatManager).getStat(team1, teamStat);
        float s2 = ((BaseballTeamStatManager) teamStatManager).getStat(team2, teamStat);
        return compare(s1, s2);
    }
}
