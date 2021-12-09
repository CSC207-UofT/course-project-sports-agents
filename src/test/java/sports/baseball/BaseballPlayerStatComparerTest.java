package sports.baseball;

import driversAdapters.CSVDataContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BaseballPlayerStatComparerTest {
    BaseballPlayerStatComparer baseballPlayerStatComparer;
    CSVDataContainer container;

    @Before
    public void setUp() throws Exception {
        baseballPlayerStatComparer = new BaseballPlayerStatComparer();
        container = new CSVDataContainer();

        BaseballPlayer player1 = new BaseballPlayer("Player 1", "2020-2021", "BOS", "2B",
                34, 54, 65, 2, 4,5, 46, 0.456);
        BaseballPlayer player2 = new BaseballPlayer("Player 2", "2020-2021", "BOS", "2B",
                38, 49, 30, 58, 10, 48, 59, 0.395);
        BaseballPlayer player3 = new BaseballPlayer("Player 3", "2020-2021", "BOS", "2B",
                39, 28, 58, 10, 39, 59, 20, 0.284);

        container.playerMap.put("player 1", player1);
        container.playerMap.put("player 2", player2);
        container.playerMap.put("player 3", player3);
    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "games played"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 3";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 1";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2023-2023", "games played"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAtBatsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "at bats"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 1";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAtBatsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 10", "player 2", "player 3",
                "2020-2021", "at bats"));
        baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteRunsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "runs"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 1";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 3";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 2";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRunsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2023-2023", "runs"));
        baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteHitsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "hits"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 2";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 3";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 1";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteHitsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 10", "player 2", "player 3",
                "2020-2021", "hits"));
        baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteHomeRunsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "home runs"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 3";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 1";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteHomeRunsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2023-2023", "home runs"));
        baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteRunsBattedInPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "runs batted in"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 3";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 1";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRunsBattedInNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 10", "player 2", "player 3",
                "2020-2021", "runs batted it"));
        baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteStrikeOutsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2020-2021", "strike outs"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 3";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 1";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 2";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer3, outputPlayer3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteStrikeOutsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "player 1", "player 2", "player 3",
                "2023-2023", "strike outs"));
        baseballPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteWithPlayerInCsvFile() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("baseball", "Whit Merrifield", "Jose Abreu",
                "2020-2021", "at bats"));
        String output = baseballPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(168, 183);
        String expectedPlayer1 = "Whit Merrifield";
        String outputPlayer2 = output.substring(222, 232);
        String expectedPlayer2 = "Jose Abreu";

        assertEquals(expectedPlayer1, outputPlayer1);
        assertEquals(expectedPlayer2, outputPlayer2);
    }
}
