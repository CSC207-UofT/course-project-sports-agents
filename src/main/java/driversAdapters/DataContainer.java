package driversAdapters;

import player.Player;
import team.Team;

public interface DataContainer {

    Player getPlayer(String sport, String name) throws Exception;

    Team getTeam(String sport, String name) throws Exception;

}
