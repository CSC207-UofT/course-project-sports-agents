package drivers_adapters;

import commands.*;
import constants.Exceptions;

import java.util.HashMap;

public class CommandManager {

    private final HashMap<String, Command> commandDictionary = new HashMap<>();

    public CommandManager() {
        HockeyPlayerStatManager hockeyPlayerStatManager =
                new HockeyPlayerStatManager();
        HockeyPlayerStatComparer hockeyPlayerStatComparer =
                new HockeyPlayerStatComparer();
        HockeyPlayerStatPredictor hockeyPlayerStatPredictor =
                new HockeyPlayerStatPredictor();

        TennisPlayerStatManager tennisPlayerStatManager =
                new TennisPlayerStatManager();
        TennisPlayerStatComparer tennisPlayerStatComparer =
                new TennisPlayerStatComparer();
        TennisPlayerStatPredictor tennisPlayerStatPredictor =
                new TennisPlayerStatPredictor();

        BaseballPlayerStatManager baseballPlayerStatManager =
                new BaseballPlayerStatManager();
        BaseballPlayerStatComparer baseballPlayerStatComparer =
                new BaseballPlayerStatComparer();
        BaseballPlayerStatPredictor baseballPlayerStatPredictor =
                new BaseballPlayerStatPredictor();

        PlayerStatManagerFacade playerStatManagerFacade =
                new PlayerStatManagerFacade(hockeyPlayerStatManager,
                        tennisPlayerStatManager, baseballPlayerStatManager);
        this.commandDictionary.put("get_player_stat", playerStatManagerFacade);

        PlayerStatComparerFacade playerStatComparerFacade =
                new PlayerStatComparerFacade(hockeyPlayerStatComparer,
                        tennisPlayerStatComparer, baseballPlayerStatComparer);
        this.commandDictionary.put("compare_player_stat", playerStatComparerFacade);

        PlayerStatPredictorFacade playerStatPredictorFacade =
                new PlayerStatPredictorFacade(hockeyPlayerStatPredictor,
                        tennisPlayerStatPredictor, baseballPlayerStatPredictor);
        this.commandDictionary.put("predict_player_stat", playerStatPredictorFacade);

        // TODO: Refactor teams, then make LeagueMemberManager work with injected TeamList
        this.commandDictionary.put("member_manager", new LeagueMemberManager());

        GetListSports getListSports = new GetListSports();
        this.commandDictionary.put("get_list_sports", getListSports);

        GetListStats getListStats = new GetListStats();
        this.commandDictionary.put("get_list_stats", getListStats);

        GetListPlayers getListPlayers = new GetListPlayers();
        this.commandDictionary.put("get_list_players", getListPlayers);

        Search search = new Search();
        this.commandDictionary.put("search_player", search);

    }

    public String execute(String input, DataContainer container) throws Exception {
        if (input.equals("")) {
            return "";
        }
        InputParser parser = new InputParser(input);
        String command_keyword = parser.getKeyword();

        Command command = commandDictionary.get(command_keyword);
        if (command == null) {
            throw new Exception(Exceptions.WRONG_COMMAND);
        }
        return command.execute(parser.getArguments(), container);

    }
}

