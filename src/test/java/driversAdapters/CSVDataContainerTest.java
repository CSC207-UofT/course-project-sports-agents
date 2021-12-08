package driversAdapters;

import org.junit.Before;
import org.junit.Test;
import sports.baseball.BaseballPlayer;
import sports.hockey.HockeyPlayer;
import sports.hockey.HockeyTeam;
import sports.tennis.TennisPlayer;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CSVDataContainerTest {
    private CSVDataContainer container;

    @Before
    public void setUp() {
        container = new CSVDataContainer();
    }

    @Test
    public void testGetPlayerHockey() throws Exception {
        HockeyPlayer player =
                (HockeyPlayer) container.getPlayer("hockey", "zdeno chara");
        String data20202021 = "Team: WSH\n" +
                              "Skater Shoots: L\n" +
                              "Position: D\n" +
                              "Games Played: 55\n" +
                              "Goals: 2\n" +
                              "Assists: 8\n" +
                              "Points: 10\n" +
                              "Shots: 67\n" +
                              "Shooting Percentage: 3.0";
        assertEquals(data20202021, player.getSeasonData("2020-2021"));

        String data20192020 = "Team: BOS\n" +
                              "Skater Shoots: L\n" +
                              "Position: D\n" +
                              "Games Played: 68\n" +
                              "Goals: 5\n" +
                              "Assists: 9\n" +
                              "Points: 14\n" +
                              "Shots: 86\n" +
                              "Shooting Percentage: 5.8";
        assertEquals(data20192020, player.getSeasonData("2019-2020"));

        String data20182019 = "Team: BOS\n" +
                              "Skater Shoots: L\n" +
                              "Position: D\n" +
                              "Games Played: 62\n" +
                              "Goals: 5\n" +
                              "Assists: 9\n" +
                              "Points: 14\n" +
                              "Shots: 99\n" +
                              "Shooting Percentage: 5.1";
        assertEquals(data20182019, player.getSeasonData("2018-2019"));

        String data20172018 = "Team: BOS\n" +
                              "Skater Shoots: L\n" +
                              "Position: D\n" +
                              "Games Played: 73\n" +
                              "Goals: 7\n" +
                              "Assists: 17\n" +
                              "Points: 24\n" +
                              "Shots: 144\n" +
                              "Shooting Percentage: 4.9";
        assertEquals(data20172018, player.getSeasonData("2017-2018"));

        String data20162017 = "Team: BOS\n" +
                              "Skater Shoots: L\n" +
                              "Position: D\n" +
                              "Games Played: 75\n" +
                              "Goals: 10\n" +
                              "Assists: 19\n" +
                              "Points: 29\n" +
                              "Shots: 136\n" +
                              "Shooting Percentage: 7.4";
        assertEquals(data20162017, player.getSeasonData("2016-2017"));
    }

    @Test
    public void testGetPlayerTennis() throws Exception {
        TennisPlayer player =
                (TennisPlayer) container.getPlayer("tennis", "ons jabeur");
        String data2016 = "Nationality: TUN\n" +
                          "Rank: 7\n" +
                          "Matches: 2\n" +
                          "Aces: 8\n" +
                          "Double Faults: 4\n" +
                          "Percentage of Serve Points Won: 0.51\n" +
                          "Percentage of Break Points Saved: 0.5\n" +
                          "Percentage of Serve Games Won: 0.52\n" +
                          "Percentage of Return Games Won: 0.26\n" +
                          "Percentage of Break Points Converted: 0.43\n" +
                          "Percentage of Return Points Won: 0.33";
        assertEquals(data2016, player.getSeasonData("2016"));

        String data2017 = "Nationality: TUN\n" +
                          "Rank: 7\n" +
                          "Matches: 20\n" +
                          "Aces: 75\n" +
                          "Double Faults: 62\n" +
                          "Percentage of Serve Points Won: 0.569\n" +
                          "Percentage of Break Points Saved: 0.614\n" +
                          "Percentage of Serve Games Won: 0.687\n" +
                          "Percentage of Return Games Won: 0.312\n" +
                          "Percentage of Break Points Converted: 0.39\n" +
                          "Percentage of Return Points Won: 0.42";
        assertEquals(data2017, player.getSeasonData("2017"));
    }

    @Test
    public void testGetPlayerBaseball() throws Exception {
        BaseballPlayer player =
                (BaseballPlayer) container.getPlayer("baseball", "spencer kieboom");
        String data20182019 = "Team: WAS\n" +
                              "Position: C\n" +
                              "Games Played: 52\n" +
                              "At Bats: 125\n" +
                              "Runs: 16\n" +
                              "Hits: 29\n" +
                              "Home Runs: 2\n" +
                              "Runs Batted In: 13\n" +
                              "Strike Outs: 28\n" +
                              "Average Hits per at Bat: 0.232";
        assertEquals(data20182019, player.getSeasonData("2018-2019"));

        String data20162017 = "Team: WAS\n" +
                              "Position: C\n" +
                              "Games Played: 1\n" +
                              "At Bats: 0\n" +
                              "Runs: 1\n" +
                              "Hits: 0\n" +
                              "Home Runs: 0\n" +
                              "Runs Batted In: 0\n" +
                              "Strike Outs: 0\n" +
                              "Average Hits per at Bat: 0.0";
        assertEquals(data20162017, player.getSeasonData("2016-2017"));
    }

    @Test
    public void testGetTeamHockey() throws Exception {
        HockeyTeam team =
                (HockeyTeam) container.getTeam("hockey", "tampa bay lightning");
        assertEquals((Integer) 82, team.getGamesPlayed("2018-2019"));
        assertEquals((Integer) 62, team.getGamesWon("2018-2019"));
        assertEquals((Integer) 16, team.getGamesLost("2018-2019"));
        assertEquals((Integer) 4, team.getOvertimeLosses("2018-2019"));
        assertEquals((Integer) 128, team.getPoints("2018-2019"));
        assertEquals((Integer) 319, team.getGoalsFor("2018-2019"));
        assertEquals((Integer) 221, team.getGoalsAgainst("2018-2019"));
        assertEquals((Double) 32.0, team.getShotsPerGame("2018-2019"));
        assertEquals((Double) 32.1, team.getShotsAgainstPerGame("2018-2019"));
        assertEquals((Double) 51.2, team.getFaceOffWinPercentage("2018-2019"));
    }

    @Test
    public void testGetAllHockeyPlayersSeason() throws Exception {
        List<String> hockeyPlayers =
                container.getAllHockeyPlayers("2020-2021");
        List<String> firstHockeyPlayers = Arrays.asList("Zdeno Chara", "Joe Thornton",
                "Jason Spezza", "Duncan Keith");
        List<String> lastHockeyPlayers = Arrays.asList("Kaapo Kakko", "Jack Hughes",
                "Ilya Mikheyev", "Alexander Barabanov");
        assertEquals(firstHockeyPlayers,
                hockeyPlayers.subList(0, firstHockeyPlayers.size()));
        assertEquals(lastHockeyPlayers,
                hockeyPlayers.subList(hockeyPlayers.size() - lastHockeyPlayers.size(),
                        hockeyPlayers.size()));
    }

    @Test
    public void testGetAllBaseballPlayersSeason() throws Exception {
        List<String> baseballPlayers =
                container.getAllBaseballPlayers("2020-2021");
        List<String> firstBaseballPlayers = Arrays.asList("Whit Merrifield", "Jose Abreu",
                "Dansby Swanson", "Francisco Lindor");
        List<String> lastBaseballPlayers = Arrays.asList("Luis Gonzalez", "Greg Allen",
                "Cheslor Cuthbert", "Scott Schebler");
        assertEquals(firstBaseballPlayers,
                baseballPlayers.subList(0, firstBaseballPlayers.size()));
        assertEquals(lastBaseballPlayers,
                baseballPlayers.subList(baseballPlayers.size() - lastBaseballPlayers.size(),
                        baseballPlayers.size()));
    }

    @Test
    public void testGetAllTennisPlayersSeason() throws Exception {
        List<String> tennisPlayers =
                container.getAllTennisPlayers("2016");
        List<String> firstTennisPlayers = Arrays.asList("Ashleigh Barty", "Barbora Krejcikova",
                "Karolina Pliskova", "Garbine Mugurza");
        List<String> lastTennisPlayers = Arrays.asList("Frances Altick", "Olesya Pervushina",
                "Komola Umarova", "Ioana Minca");
        assertEquals(firstTennisPlayers,
                tennisPlayers.subList(0, firstTennisPlayers.size()));
        assertEquals(lastTennisPlayers,
                tennisPlayers.subList(tennisPlayers.size() - lastTennisPlayers.size(),
                        tennisPlayers.size()));
    }

    @Test
    public void testGetAllHockeyPlayers() throws Exception {
        List<String> hockeyPlayers =
                container.getAllHockeyPlayers();
        List<String> firstHockeyPlayers = Arrays.asList("Zdeno Chara: Hockey",
                "Joe Thornton: Hockey", "Jason Spezza: Hockey", "Duncan Keith: Hockey");
        List<String> lastHockeyPlayers = Arrays.asList("Adam Clendening: Hockey",
                "Brian Flynn: Hockey", "Jayson Megna: Hockey", "Patrick Brown: Hockey");
        assertEquals(firstHockeyPlayers,
                hockeyPlayers.subList(0, firstHockeyPlayers.size()));
        assertEquals(lastHockeyPlayers,
                hockeyPlayers.subList(hockeyPlayers.size() - lastHockeyPlayers.size(),
                        hockeyPlayers.size()));
    }

    @Test
    public void testGetAllBaseballPlayers() throws Exception {
        List<String> baseballPlayers =
                container.getAllBaseballPlayers();
        List<String> firstBaseballPlayers = Arrays.asList("Whit Merrifield: Baseball",
                "Jose Abreu: Baseball", "Dansby Swanson: Baseball", "Francisco Lindor: Baseball");
        List<String> lastBaseballPlayers = Arrays.asList("Matt Tuiasosopo: Baseball",
                "Andrew Lambo: Baseball", "Mike Miller: Baseball", "Mike McKenry: Baseball");
        assertEquals(firstBaseballPlayers,
                baseballPlayers.subList(0, firstBaseballPlayers.size()));
        assertEquals(lastBaseballPlayers,
                baseballPlayers.subList(baseballPlayers.size() - lastBaseballPlayers.size(),
                        baseballPlayers.size()));
    }

    @Test
    public void testGetAllTennisPlayers() throws Exception {
        List<String> tennisPlayers =
                container.getAllTennisPlayers();
        List<String> firstTennisPlayers = Arrays.asList("Ashleigh Barty: Tennis",
                "Barbora Krejcikova: Tennis", "Karolina Pliskova: Tennis", "Garbine Mugurza: Tennis");
        List<String> lastTennisPlayers = Arrays.asList("Petra Krejsova: Tennis",
                "Alexa Guarachi: Tennis", "Victoria Kamenskaya: Tennis", "Alyssa Mayo: Tennis");
        assertEquals(firstTennisPlayers,
                tennisPlayers.subList(0, firstTennisPlayers.size()));
        assertEquals(lastTennisPlayers,
                tennisPlayers.subList(tennisPlayers.size() - lastTennisPlayers.size(),
                        tennisPlayers.size()));
    }
}