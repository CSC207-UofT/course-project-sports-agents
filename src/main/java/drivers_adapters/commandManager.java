package drivers_adapters;

import commands.*;
import player.HockeyPlayer;
import player.PlayerList;
import player.TennisPlayer;

import java.util.HashMap;

public class commandManager {

    private final HashMap<String, Command> commandDictionary = new HashMap<String, Command>();

    public commandManager() {
        // TODO: Should this be its own builder class? Also, better var name ideas?
        PlayerList<HockeyPlayer> hockeyPlayerList = new PlayerList<HockeyPlayer>();
        HockeyPlayerStatManager hockeyPlayerStatManager =
                new HockeyPlayerStatManager(hockeyPlayerList);
        HockeyPlayerStatComparer hockeyPlayerStatComparer =
                new HockeyPlayerStatComparer(hockeyPlayerList);
        HockeyPlayerStatPredictor hockeyPlayerStatPredictor =
                new HockeyPlayerStatPredictor(hockeyPlayerList);

        PlayerList<TennisPlayer> tennisPlayerList = new PlayerList<TennisPlayer>();
        TennisPlayerStatManager tennisPlayerStatManager =
                new TennisPlayerStatManager(tennisPlayerList);
        TennisPlayerStatComparer tennisPlayerStatComparer =
                new TennisPlayerStatComparer(tennisPlayerList);

        PlayerStatManagerFacade playerStatManagerFacade =
                new PlayerStatManagerFacade(hockeyPlayerStatManager,
                        tennisPlayerStatManager);
        this.commandDictionary.put("get_player_stat", playerStatManagerFacade);

        PlayerStatComparerFacade playerStatComparerFacade =
                new PlayerStatComparerFacade(hockeyPlayerStatComparer,
                        tennisPlayerStatComparer);
        this.commandDictionary.put("compare_player_stat", playerStatComparerFacade);

        PlayerStatPredictorFacade playerStatPredictorFacade =
                new PlayerStatPredictorFacade(hockeyPlayerStatPredictor);
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
