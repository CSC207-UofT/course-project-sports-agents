package driversAdapters;

import commands.*;
import constants.CommandsInfo;
import sports.baseball.BaseballPlayerStatManager;
import sports.baseball.BaseballPlayerStatComparer;
import sports.baseball.BaseballPlayerStatPredictor;
import sports.hockey.HockeyPlayerStatComparer;
import sports.hockey.HockeyPlayerStatManager;
import sports.hockey.HockeyPlayerStatPredictor;
import sports.hockey.HockeyTeamStatManager;
import sports.tennis.TennisPlayerStatComparer;
import sports.tennis.TennisPlayerStatManager;
import sports.tennis.TennisPlayerStatPredictor;


import java.util.HashMap;

/**
 * A builder class to construct the Command Dictionary for the Command Manager
 */
public class CommandDictBuilder {
    private final HockeyPlayerStatManager hockeyPlayerStatManager;
    private final HockeyPlayerStatComparer hockeyPlayerStatComparer;
    private final HockeyPlayerStatPredictor hockeyPlayerStatPredictor;

    private final TennisPlayerStatManager tennisPlayerStatManager;
    private final TennisPlayerStatComparer tennisPlayerStatComparer;
    private final TennisPlayerStatPredictor tennisPlayerStatPredictor;

    private final BaseballPlayerStatManager baseballPlayerStatManager;
    private final BaseballPlayerStatComparer baseballPlayerStatComparer;
    private final BaseballPlayerStatPredictor baseballPlayerStatPredictor;

    private final PlayerStatManagerFacade playerStatManagerFacade;
    private final PlayerStatComparerFacade playerStatComparerFacade;
    private final PlayerStatPredictorFacade playerStatPredictorFacade;

    private final LeagueMemberManager leagueMemberManager;

    private final HashMap<String, Command> commandDict;

    public CommandDictBuilder() {
        this.hockeyPlayerStatManager = new HockeyPlayerStatManager();
        this.hockeyPlayerStatComparer = new HockeyPlayerStatComparer();
        this.hockeyPlayerStatPredictor = new HockeyPlayerStatPredictor();

        this.tennisPlayerStatManager = new TennisPlayerStatManager();
        this.tennisPlayerStatComparer = new TennisPlayerStatComparer();
        this.tennisPlayerStatPredictor = new TennisPlayerStatPredictor();

        this.baseballPlayerStatManager = new BaseballPlayerStatManager();
        this.baseballPlayerStatComparer = new BaseballPlayerStatComparer();
        this.baseballPlayerStatPredictor = new BaseballPlayerStatPredictor();

        this.playerStatManagerFacade =
                new PlayerStatManagerFacade(hockeyPlayerStatManager,
                        tennisPlayerStatManager, baseballPlayerStatManager);
        this.playerStatComparerFacade =
                new PlayerStatComparerFacade(hockeyPlayerStatComparer,
                        tennisPlayerStatComparer, baseballPlayerStatComparer);
        this.playerStatPredictorFacade =
                new PlayerStatPredictorFacade(hockeyPlayerStatPredictor,
                        tennisPlayerStatPredictor, baseballPlayerStatPredictor);

        this.leagueMemberManager = new LeagueMemberManager();

        this.commandDict = new HashMap<>();
        this.commandDict.put(CommandsInfo.GetPlayerStatInfo.keyword,
                playerStatManagerFacade);
        this.commandDict.put(CommandsInfo.ComparePlayerStatInfo.keyword,
                playerStatComparerFacade);
        this.commandDict.put(CommandsInfo.PredictPlayerStatInfo.keyword,
                playerStatPredictorFacade);
        for (String keyword : CommandsInfo.manageLeagueKeywords) {
            this.commandDict.put(keyword, leagueMemberManager);
        }

        this.commandDict.put(CommandsInfo.GetListPlayersInfo.keyword, new GetListPlayers());
        this.commandDict.put(CommandsInfo.GetListSportsInfo.keyword, new GetListSports());
        this.commandDict.put(CommandsInfo.GetListStatsInfo.keyword, new GetListStats());
        this.commandDict.put(CommandsInfo.SearchInfo.keyword, new Search());
        this.commandDict.put(CommandsInfo.AvailableCommandsInfo.keyword, new AvailableCommands());

        HockeyTeamStatManager hockeyTeamStatManager = new HockeyTeamStatManager();
        this.commandDict.put(CommandsInfo.GetTeamStatInfo.keyword, new TeamStatManagerFacade(hockeyTeamStatManager));
    }

    public HashMap<String, Command> getCommandDict() {
        return this.commandDict;
    }
}
