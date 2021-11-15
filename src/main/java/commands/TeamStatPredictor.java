package commands;

import java.util.ArrayList;

import drivers_adapters.DataContainer;
import team.TeamStats;

public class TeamStatPredictor implements Command {
    private final TeamStatManager teamStatManager;
    private final int TEAM_NAME_1_SLOT = 0;
    private final int TEAM_NAME_2_SLOT = 1;

    public TeamStatPredictor(TeamStatManager teamStatManager) {
        this.teamStatManager = teamStatManager;
    }

    /**
     * Predicts the winner of 2 teams
     *
     * @param team1 first team being considered
     * @param team2 second team being considered
     * @return 1 if team 1 is better, 2 if team 2 is better, 0 if team 1 equals team 2
     */
    public int predictWinner(String team1, String team2) {
        float RANK_SCALE_FACTOR = 0.5f;
        float rs1 = teamStatManager.getStat(team1, TeamStats.RANK) * RANK_SCALE_FACTOR;
        float WIN_RATE_SCALE_FACTOR = 1.3f;
        float ws1 = teamStatManager.getStat(team1, TeamStats.WIN_RATE) * WIN_RATE_SCALE_FACTOR;
        float rs2 = teamStatManager.getStat(team2, TeamStats.RANK) * RANK_SCALE_FACTOR;
        float ws2 = teamStatManager.getStat(team2, TeamStats.WIN_RATE) * WIN_RATE_SCALE_FACTOR;

        if (rs1 + ws1 > 1 / rs2 + ws2) {
            return 1;
        } else if (rs1 + ws1 < rs2 + ws2) {
            return 2;
        } else {
            return 0;
        }
    }

    public String formatOut(ArrayList<String> arguments, int winner) {
        if (winner == 1) {
            return arguments.get(TEAM_NAME_1_SLOT) +
                   " is the predicted winner.";
        } else if (winner == 2) {
            return arguments.get(TEAM_NAME_2_SLOT) +
                   " is the predicted winner";
        } else {
            return "No winner can be predicted! It is too close to call.";
        }
    }

    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) {
        String teamName1 = arguments.get(TEAM_NAME_1_SLOT);
        String teamName2 = arguments.get(TEAM_NAME_2_SLOT);
        return formatOut(arguments,
                predictWinner(teamName1, teamName2));
    }
}