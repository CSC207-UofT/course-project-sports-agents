package drivers_adapters;

import commands.*;
import player.*;

import java.util.HashMap;

public class commandManager {

    private final HashMap<String, Command> commandDictionary = new HashMap<>();

    public commandManager() {
        PlayerList<HockeyPlayer> hockeyPlayerList = new PlayerList<>();
        HockeyPlayerStatManager hockeyPlayerStatManager =
                new HockeyPlayerStatManager(hockeyPlayerList);
        HockeyPlayerStatComparer hockeyPlayerStatComparer =
                new HockeyPlayerStatComparer(hockeyPlayerList);
        HockeyPlayerStatPredictor hockeyPlayerStatPredictor =
                new HockeyPlayerStatPredictor(hockeyPlayerList);

        PlayerList<TennisPlayer> tennisPlayerList = new PlayerList<>();
        TennisPlayerStatManager tennisPlayerStatManager =
                new TennisPlayerStatManager(tennisPlayerList);
        TennisPlayerStatComparer tennisPlayerStatComparer =
                new TennisPlayerStatComparer(tennisPlayerList);
        TennisPlayerStatPredictor tennisPlayerStatPredictor =
                new TennisPlayerStatPredictor(tennisPlayerList);

        PlayerList<BaseballPlayer> baseballPlayerList = new PlayerList<>();

        PlayerStatManagerFacade playerStatManagerFacade =
                new PlayerStatManagerFacade(hockeyPlayerStatManager,
                        tennisPlayerStatManager);
        this.commandDictionary.put("get_player_stat", playerStatManagerFacade);

        PlayerStatComparerFacade playerStatComparerFacade =
                new PlayerStatComparerFacade(hockeyPlayerStatComparer,
                        tennisPlayerStatComparer);
        this.commandDictionary.put("compare_player_stat", playerStatComparerFacade);

        PlayerStatPredictorFacade playerStatPredictorFacade =
                new PlayerStatPredictorFacade(hockeyPlayerStatPredictor,
                        tennisPlayerStatPredictor,
                        baseballPlayerStatPredictor);
        this.commandDictionary.put("predict_player_stat", playerStatPredictorFacade);

        // TODO: Refactor teams, then make LeagueMemberManager work with injected TeamList
        this.commandDictionary.put("member_manager", new LeagueMemberManager());

    }

    public String execute(String input) throws Exception {
        if (input.equals("")) {
            return "";
        }
        inputParser parser = new inputParser(input);
        String command_keyword = parser.getKeyword();

        Command command = commandDictionary.get(command_keyword);
        return command.execute(parser.getArguments());

    }
}