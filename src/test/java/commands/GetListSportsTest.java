package commands;

import driversAdapters.*;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;


public class GetListSportsTest {

    @Test
    public void getListSportsTest() throws Exception {
        GetListSports getListSports = new GetListSports();
        DataContainer dataContainer = new CSVDataContainer();
        ArrayList<String> arguments = new ArrayList<>();
        String expected = "All Available sports: \n" + "Baseball\n" +
                "Hockey\n" +
                "Tennis\n";
        assertEquals(expected, getListSports.execute(arguments, dataContainer));
    }

}