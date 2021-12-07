package driversAdapters;

import sports.Player;
import sports.Team;

import java.io.*;
import java.util.*;

public interface DataContainer {

    Player getPlayer(String sport, String name) throws Exception;

    Team getTeam(String sport, String name) throws Exception;

    //Get all players in all sports and seasons
    List<String> getAllPlayers(String sport, String season) throws Exception;

    //Get all players in all sports and seasons
    List<String> getAllPlayersForAllSports() throws IOException;

}
