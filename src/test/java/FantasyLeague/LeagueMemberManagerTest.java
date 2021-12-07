package FantasyLeague;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LeagueMemberManagerTest {
    private FantasyLeagueManager m;
    private DataContainer container;

    @Before
    public void setUp() {
        m = new FantasyLeagueManager();
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
                m.execute(addMemberCommand, container));

        try {
            String failMessage = m.execute(addMemberCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given member already exists", e.getMessage());
        }
        ArrayList<String> memberInfoCommand = new ArrayList<>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("paul gries");
        assertEquals("Member paul gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s)", m.execute(memberInfoCommand, container));
    }

    @Test
    public void testCreateMatch() throws Exception {
        ArrayList<String> createMatchCommand = new ArrayList<>();
        createMatchCommand.add("create_match");
        createMatchCommand.add("super bowl");
        createMatchCommand.add("ravens");
        createMatchCommand.add("owls");
        assertEquals("New Match between ravens and owls successfully created.",
                m.execute(createMatchCommand, container));

        try {
            String failMessage = m.execute(createMatchCommand, container);
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
                "owls will win super bowl", m.execute(betCommand, container));

        try {
            ArrayList<String> betFakeMemberCommand = new ArrayList<>();
            betFakeMemberCommand.add("bet");
            betFakeMemberCommand.add("gries paul");
            betFakeMemberCommand.add("super bowl");
            betFakeMemberCommand.add("owls");
            String failMessage = m.execute(betFakeMemberCommand, container);
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
            String failMessage = m.execute(betFakeMatchCommand, container);
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
            String failMessage = m.execute(betFakeTeamCommand, container);
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
                        "as the victors.", m.execute(resolveMatchCommand, container));

        try {
            String failMessage = m.execute(resolveMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Given match does not exist yet", e.getMessage());
        }

        ArrayList<String> memberInfoCommand = new ArrayList<>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("paul gries");
        assertEquals("Member paul gries with 1 correct bet(s) and " +
                        "0 incorrect bet(s)", m.execute(memberInfoCommand, container));
    }
}