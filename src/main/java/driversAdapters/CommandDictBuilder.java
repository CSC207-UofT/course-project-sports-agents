package driversAdapters;

import FantasyLeague.FantasyLeagueManager;
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

    private final HashMap<String, Command> commandDict;

    public CommandDictBuilder() {
        HockeyPlayerStatManager hockeyPlayerStatManager = new HockeyPlayerStatManager();
        HockeyPlayerStatComparer hockeyPlayerStatComparer = new HockeyPlayerStatComparer();
        HockeyPlayerStatPredictor hockeyPlayerStatPredictor = new HockeyPlayerStatPredictor();

        TennisPlayerStatManager tennisPlayerStatManager = new TennisPlayerStatManager();
        TennisPlayerStatComparer tennisPlayerStatComparer = new TennisPlayerStatComparer();
        TennisPlayerStatPredictor tennisPlayerStatPredictor = new TennisPlayerStatPredictor();

        BaseballPlayerStatManager baseballPlayerStatManager = new BaseballPlayerStatManager();
        BaseballPlayerStatComparer baseballPlayerStatComparer = new BaseballPlayerStatComparer();
        BaseballPlayerStatPredictor baseballPlayerStatPredictor = new BaseballPlayerStatPredictor();

        PlayerStatManagerFacade playerStatManagerFacade = new PlayerStatManagerFacade(hockeyPlayerStatManager,
                tennisPlayerStatManager, baseballPlayerStatManager);
        PlayerStatComparerFacade playerStatComparerFacade = new PlayerStatComparerFacade(hockeyPlayerStatComparer,
                tennisPlayerStatComparer, baseballPlayerStatComparer);
        PlayerStatPredictorFacade playerStatPredictorFacade = new PlayerStatPredictorFacade(hockeyPlayerStatPredictor,
                tennisPlayerStatPredictor, baseballPlayerStatPredictor);

        FantasyLeagueManager leagueMemberManager = new FantasyLeagueManager();

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
