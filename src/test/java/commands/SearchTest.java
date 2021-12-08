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
        String expected = "Jeff Carter: Hockey\n" +
                          "Jeff Petry: Hockey\n" +
                          "Jeff Skinner: Hockey\n" +
                          "Jeff McNeil: Baseball\n" +
                          "Jeff Mathis: Baseball\n" +
                          "Ryan Jeffers: Baseball\n" +
                          "Jeff Francoeur: Baseball\n";
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