package driversAdapters;

import commands.*;
import constants.CommandsInfo;
import player.Player;

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
    }

    public HashMap<String, Command> getCommandDict() {
        return this.commandDict;
    }
}
