package sportsApp;

import org.junit.*;
import static org.junit.Assert.*;
import sportsApp.inputParser;

import java.util.ArrayList;

public class InputParserTest {

    private inputParser parser;

    @Test
    public void memberManagerTest() {
        inputParser parser = new inputParser("member_manager add_member \"Paul Gries\"");
        assertEquals(parser.getKeyword(), "member_manager");
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("add_member");
        arguments.add("Paul Gries");
        assertEquals(parser.getArguments(), arguments);
    }

    @Test public void statsPlayerTest() {
        inputParser parser = new inputParser("stats_player \"Mickael Mendez\" \"lessons TA'd\" \"20202021\"");
        assertEquals(parser.getKeyword(), "stats_player");
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("Mickael Mendez");
        arguments.add("lessons TA'd");
        arguments.add("20202021");
        assertEquals(parser.getArguments(), arguments);
    }
}
