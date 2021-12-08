package commands;

import driversAdapters.*;
import org.junit.Test;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void searchTest() throws IOException {
        Search search = new Search();
        DataContainer dataContainer = new CSVDataContainer();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("Jeff");
        String expected = "jeff carter: Hockey\n" +
                "jeff petry: Hockey\n" +
                "jeff skinner: Hockey\n" +
                "jeff mcneil: Baseball\n" +
                "jeff mathis: Baseball\n" +
                "ryan jeffers: Baseball\n" +
                "jeff francoeur: Baseball\n";
        assertEquals(expected, search.execute(arguments, dataContainer));

    }

    @Test
    public void NoResultsTest() throws IOException {
        Search search = new Search();
        DataContainer dataContainer = new CSVDataContainer();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("Nishikori");
        String expected = "No results found!";
        assertEquals(expected, search.execute(arguments, dataContainer));
    }

}