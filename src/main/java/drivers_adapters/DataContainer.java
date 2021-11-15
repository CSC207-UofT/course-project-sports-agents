package drivers_adapters;

import player.Player;
import team.Team;

public interface DataContainer {

    Player getPlayer(String name);

    Team getTeam(String name);

}
