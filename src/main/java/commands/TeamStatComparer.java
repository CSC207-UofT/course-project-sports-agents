package commands;

import java.util.ArrayList;

import driversAdapters.DataContainer;
import team.TeamConstants;
import team.TeamStats;

public abstract class TeamStatComparer implements Command, TeamConstants {
    protected final TeamStatManager teamStatManager;
    protected final int TEAM_NAME_1_SLOT = 1;
    protected final int TEAM_NAME_2_SLOT = 2;
    protected final int REQUESTED_STAT_SLOT = 3;

    public TeamStatComparer(TeamStatManager teamStatManager) {
        this.teamStatManager = teamStatManager;
    }

    protected int compare(float teamStat1, float teamStat2){
        if(teamStat1 == -1 && teamStat2 == -1){
            return -1;
        }
        if (teamStat1 > teamStat2) {
            return 1;
        } else if (teamStat1 < teamStat2) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * Compares the stats of 2 teams
     *
     * @param team1 first team to compare
     * @param team2 second team to compare
     * @param teamStat the stat to compare
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public abstract int compareStats(String team1, String team2, TeamStats teamStat);

    public String formatOut(ArrayList<String> arguments, int result) {
        if (result == 1) {
            return arguments.get(TEAM_NAME_1_SLOT) +
                   " has a higher performance in " +
                   arguments.get(REQUESTED_STAT_SLOT) +
                   " than " +
                   arguments.get(TEAM_NAME_2_SLOT);
        } else if (result == 2) {
            return arguments.get(TEAM_NAME_2_SLOT) +
                   " has a higher performance in " +
                   arguments.get(REQUESTED_STAT_SLOT) +
                   " than " +
                   arguments.get(TEAM_NAME_1_SLOT);
        } else {
            return arguments.get(TEAM_NAME_1_SLOT) +
                   " has an equal performance in " +
                   arguments.get(REQUESTED_STAT_SLOT) +
                   " than " +
                   arguments.get(TEAM_NAME_2_SLOT);
        }
    }

    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String teamName1 = arguments.get(TEAM_NAME_1_SLOT);
        String teamName2 = arguments.get(TEAM_NAME_2_SLOT);
        String requestedStat = arguments.get(REQUESTED_STAT_SLOT);

        if (requestedStat.equals(KEY_ALL_STATS)) {
            return null;
        } else {
            TeamStats parsedStat = teamStatManager.parseStat(requestedStat);

            if (parsedStat == null) {
                throw new Exception("Stat does not exist");
            }
            return formatOut(arguments,
                    compareStats(teamName1, teamName2, parsedStat));
        }
    }
}