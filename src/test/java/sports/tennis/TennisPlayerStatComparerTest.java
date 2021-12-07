package sports.tennis;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TennisPlayerStatComparerTest {
    TennisPlayerStatComparer tennisPlayerStatComparer;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        this.tennisPlayerStatComparer = new TennisPlayerStatComparer();
        this.container = new CSVDataContainer();

    }

    @Test(timeout = 100)
    public void testExecuteRankPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "Barbora Krejcikova", "Karolina Pliskova", "2016", "rank"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name                 rank \n" +
                "-----------------------------------------------------\n" +
                "    1       Ashleigh Barty                    1 \n" +
                "    2   Barbora Krejcikova                    3 \n" +
                "    3    Karolina Pliskova                    4 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "Barbora Krejcikova", "Karolina Pliskova", "2016", "aces"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name                 aces \n" +
                "-----------------------------------------------------\n" +
                "    1    Karolina Pliskova                  530 \n" +
                "    2       Ashleigh Barty                   20 \n" +
                "    3   Barbora Krejcikova                   17 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Ashleigh Barty", "Barbora Krejcikova", "2016", "aces"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Sofia Kenin", "Elise Mertens", "Simona Halep", "2040", "aces"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Sofia Kenin", "Elise Mertens", "Simona Halep", "2016", "double faults"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name        double faults \n" +
                "-----------------------------------------------------\n" +
                "    1          Sofia Kenin                    2 \n" +
                "    2        Elise Mertens                   28 \n" +
                "    3         Simona Halep                  120 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Simona Halep", "Sofia Kenin", "2017", "double faults"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Sofia Kenin", "Elise Mertens", "Simona Halep", "1991", "double faults"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis", "Ashleigh Barty", "Barbora Krejcikova",
                "Karolina Pliskova", "2016", "serve points won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name     serve points won \n" +
                "-----------------------------------------------------\n" +
                "    1       Ashleigh Barty                 0.64 \n" +
                "    2    Karolina Pliskova                 0.62 \n" +
                "    3   Barbora Krejcikova                 0.55 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Jasmine Paolini", "nastasia Potapova", "2017", "serve points won"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "1991", "serve points won"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "2017", "break points saved"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name   break points saved \n" +
                "-----------------------------------------------------\n" +
                "    1      Jasmine Paolini                0.645 \n" +
                "    2      Madison Brengle                0.468 \n" +
                "    3   Anastasia Potapova                0.375 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Jasmine Paolini", "Anastasia Potapova", "2017", "break points saved"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "1991", "break points saved"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteReturnGamesWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "Barbora Krejcikova",
                "Karolina Pliskova", "2016", "return games won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name     return games won \n" +
                "-----------------------------------------------------\n" +
                "    1    Karolina Pliskova                 0.35 \n" +
                "    2       Ashleigh Barty                 0.35 \n" +
                "    3   Barbora Krejcikova                 0.32 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnGamesWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Jasmine Paolini", "Anastasia Potapova", "2017", "return games won"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnGamesWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "1991", "return games won"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsConvertedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "Barbora Krejcikova",
                "Karolina Pliskova", "2016", "break points converted"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name break points converted \n" +
                "-----------------------------------------------------\n" +
                "    1    Karolina Pliskova                 0.46 \n" +
                "    2   Barbora Krejcikova                 0.43 \n" +
                "    3       Ashleigh Barty                 0.35 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsConvertedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Jasmine Paolini", "Anastasia Potapova", "2017", "break points converted"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsConvertedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "1991", "break points converted"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteReturnPointsWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "Barbora Krejcikova",
                "Karolina Pliskova", "2016", "return points won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name    return points won \n" +
                "-----------------------------------------------------\n" +
                "    1    Karolina Pliskova                 0.43 \n" +
                "    2       Ashleigh Barty                 0.43 \n" +
                "    3   Barbora Krejcikova                 0.42 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnPointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Jasmine Paolini", "Anastasia Potapova", "2017", "return points won"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnPointsWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "1991", "return points won"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "2017", "goals"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

}