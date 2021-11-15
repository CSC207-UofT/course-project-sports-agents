package player;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerListTest {
    HockeyPlayer player1;
    HockeyPlayer player2;
    HockeyPlayer player3;
    PlayerList<HockeyPlayer> playerList;

    @Before
    public void setUp() throws Exception {
        this.player1 = new HockeyPlayer("Auston Matthews",
                "20202021", "TOR","L", "C",
                52,41,25,66,222,
                18.5);
        this.player2 = new HockeyPlayer("Mikko Rantanen",
                "20202021", "COL", "L", "R",
                52,30,36,66,177,
                17.0);
        this.player3 = new HockeyPlayer("Ryan O'Reilly",
                "20202021", "STL", "L", "C",
                56,24,30,54,129,
                18.6);
        this.playerList = new HockeyPlayerList();
        this.playerList.addPlayer(this.player1);
        this.playerList.addPlayer(this.player2);
        this.playerList.addPlayer(this.player3);
    }

    @Test(timeout = 100)
    public void testGetPlayerPasses() throws Exception {
        HockeyPlayer selectedPlayer = this.playerList.getPlayer("Mikko Rantanen");
        assertEquals(this.player2, selectedPlayer);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetPlayerFails() throws Exception {
        HockeyPlayer fail = this.playerList.getPlayer("Paul Gries");
    }

    @Test(timeout = 100)
    public void testGetPlayersPasses() throws Exception {
        List<String> playerNames = Arrays.asList("Auston Matthews", "Ryan O'Reilly");
        List<HockeyPlayer> selectedPlayers = this.playerList.getPlayers(playerNames);
        assertEquals(Arrays.asList(player1, player3), selectedPlayers);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetPlayersFails() throws Exception {
        List<String> playerNames = Arrays.asList("Auston Matthews", "Paul Gries");
        List<HockeyPlayer> fail = this.playerList.getPlayers(playerNames);
    }
}