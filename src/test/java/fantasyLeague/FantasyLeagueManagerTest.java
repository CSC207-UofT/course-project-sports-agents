package fantasyLeague;

import constants.Exceptions;
import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FantasyLeagueManagerTest {
    private FantasyLeagueManager fantasyLeagueManager;
    private DataContainer container;

    @Before
    public void setUp() {
        fantasyLeagueManager = new FantasyLeagueManager();
        container = new CSVDataContainer();
    }

    // TODO: Break up these tests. Most rely on multiple methods.

    @Test
    public void testAddMember() throws Exception {
        ArrayList<String> addMemberCommand = new ArrayList<>();
        addMemberCommand.add("add_member");
        addMemberCommand.add("paul gries");
        assertEquals("New Member paul gries with 0 correct bet(s) and " +
                     "0 incorrect bet(s) successfully added.",
                fantasyLeagueManager.execute(addMemberCommand, container));

        try {
            fantasyLeagueManager.execute(addMemberCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given member already exists", e.getMessage());
        }
        ArrayList<String> memberInfoCommand = new ArrayList<>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("paul gries");
        assertEquals("Member paul gries with 0 correct bet(s) and " +
                     "0 incorrect bet(s)", fantasyLeagueManager.execute(memberInfoCommand, container));
    }

    @Test
    public void testCreateMatch() throws Exception {
        ArrayList<String> createMatchCommand = new ArrayList<>();
        createMatchCommand.add("create_match");
        createMatchCommand.add("super bowl");
        createMatchCommand.add("ravens");
        createMatchCommand.add("owls");
        assertEquals("New Match between ravens and owls successfully created.",
                fantasyLeagueManager.execute(createMatchCommand, container));

        try {
            fantasyLeagueManager.execute(createMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given match already exists",
                    e.getMessage());
        }
    }

    @Test
    public void testBet() throws Exception {
        testAddMember();

        testCreateMatch();
        ArrayList<String> betCommand = new ArrayList<>();
        betCommand.add("bet");
        betCommand.add("paul gries");
        betCommand.add("super bowl");
        betCommand.add("owls");
        assertEquals("paul gries has successfully placed a bet that " +
                     "owls will win super bowl", fantasyLeagueManager.execute(betCommand, container));

        try {
            ArrayList<String> betFakeMemberCommand = new ArrayList<>();
            betFakeMemberCommand.add("bet");
            betFakeMemberCommand.add("gries paul");
            betFakeMemberCommand.add("super bowl");
            betFakeMemberCommand.add("owls");
            fantasyLeagueManager.execute(betFakeMemberCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given member does not exist yet", e.getMessage());
        }

        try {
            ArrayList<String> betFakeMatchCommand = new ArrayList<>();
            betFakeMatchCommand.add("bet");
            betFakeMatchCommand.add("paul gries");
            betFakeMatchCommand.add("superb owl");
            betFakeMatchCommand.add("owls");
            fantasyLeagueManager.execute(betFakeMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given match does not exist yet", e.getMessage());
        }

        try {
            ArrayList<String> betFakeTeamCommand = new ArrayList<>();
            betFakeTeamCommand.add("bet");
            betFakeTeamCommand.add("paul gries");
            betFakeTeamCommand.add("super bowl");
            betFakeTeamCommand.add("dogs");
            fantasyLeagueManager.execute(betFakeTeamCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "dogs is not a Team in this Match!");
        }
    }

    @Test
    public void testResolveMatch() throws Exception {
        testBet();

        ArrayList<String> resolveMatchCommand = new ArrayList<>();
        resolveMatchCommand.add("resolve_match");
        resolveMatchCommand.add("super bowl");
        resolveMatchCommand.add("owls");
        assertEquals("super bowl was successfully resolved with owls " +
                     "as the victors.", fantasyLeagueManager.execute(resolveMatchCommand, container));

        try {
            fantasyLeagueManager.execute(resolveMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given match does not exist yet", e.getMessage());
        }

        ArrayList<String> memberInfoCommand = new ArrayList<>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("paul gries");
        assertEquals("Member paul gries with 1 correct bet(s) and " +
                     "0 incorrect bet(s)", fantasyLeagueManager.execute(memberInfoCommand, container));
    }

    @Test
    public void testSaveLoad() throws Exception {
        File saveFile = new File("testFantasyLeagueFile");
        saveFile.delete();

        testResolveMatch();

        ArrayList<String> saveCommand = new ArrayList<>();
        saveCommand.add("save");
        saveCommand.add("testFantasyLeagueFile");

        assertEquals("Successfully saved to testFantasyLeagueFile",
                fantasyLeagueManager.execute(saveCommand, container));

        fantasyLeagueManager = new FantasyLeagueManager();

        ArrayList<String> loadCommand = new ArrayList<>();
        loadCommand.add("load");
        loadCommand.add("testFantasyLeagueFile");
        assertEquals("Successfully loaded the league. Welcome back!",
                fantasyLeagueManager.execute(loadCommand, container));

        ArrayList<String> memberInfoCommand = new ArrayList<>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("paul gries");
        assertEquals("Member paul gries with 1 correct bet(s) and " +
                     "0 incorrect bet(s)", fantasyLeagueManager.execute(memberInfoCommand, container));

        saveFile.delete();
    }

    @Test
    public void testInvalidArgLength() {
        ArrayList<String> invalidCommand = new ArrayList<>();
        invalidCommand.add("add_member");
        try {
            fantasyLeagueManager.execute(invalidCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals(Exceptions.WRONG_ARGUMENT_NUMBER,
                    e.getMessage());
        }

        invalidCommand.add("Paul");
        invalidCommand.add("Gries");
        try {
            fantasyLeagueManager.execute(invalidCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals(Exceptions.WRONG_ARGUMENT_NUMBER,
                    e.getMessage());
        }
    }
}