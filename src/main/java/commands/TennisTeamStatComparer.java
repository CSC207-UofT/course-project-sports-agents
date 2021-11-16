package commands;

import java.util.List;
import java.util.ArrayList;

import commands.TeamStatManager;
import commands.TennisTeamStatManager;
import team.TeamStats;

public class TennisTeamStatComparer extends TeamStatComparer {
    public TennisTeamStatComparer(TeamStatManager teamStatManager) {
        super(teamStatManager);
    }

    public int compareStats(String team1, String team2, TeamStats teamStat){
        float s1 = ((TennisTeamStatManager) teamStatManager).getStat(team1, teamStat);
        float s2 = ((TennisTeamStatManager) teamStatManager).getStat(team2, teamStat);
        return compare(s1, s2);
    }
}
