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
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Ashleigh Barty", "Barbora Krejcikova", "Karolina Pliskova", "2016", "Aces"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name                 aces \n" +
                "-----------------------------------------------------\n" +
                "    1    Karolina Pliskova                  530 \n" +
                "    2       Ashleigh Barty                   20 \n" +
                "    3   Barbora Krejcikova                   17";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Ashleigh Barty", "Barbora Krejcikova", "2016", "Aces"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "Player 2", "Player 3", "2020", "Aces"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Sofia Kenin", "Elise Mertens", "Simona Halep", "2016", "Double Faults"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name        double faults \n" +
                "-----------------------------------------------------\n" +
                "    1         Simona Halep                  120 \n" +
                "    2        Elise Mertens                   28 \n" +
                "    3          Sofia Kenin                    2";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Simona Halep", "Sofia Kenin", "20202021", "Double Faults"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Sofia Kenin", "Elise Mertens", "Simona Halep", "1991", "Double Faults"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "2017", "Break Points Saved"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                " Rank                 Name   break points saved \n" +
                "-----------------------------------------------------\n" +
                "    1      Jasmine Paolini                0.645 \n" +
                "    2      Madison Brengle                0.468 \n" +
                "    3   Anastasia Potapova                0.375";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "Jasmine Paolini", "nastasia Potapova", "2017", "Break Points Saved"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "1991", "Break Points Saved"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "2017", "Goals"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

}