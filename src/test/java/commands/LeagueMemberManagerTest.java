package commands;

import drivers_adapters.CSVDataContainer;
import drivers_adapters.DataContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LeagueMemberManagerTest {
    private LeagueMemberManager m;
    private DataContainer container;

    @Before
    public void setUp() throws Exception {
        m = new LeagueMemberManager();
        DataContainer container = new CSVDataContainer();
    }

    // TODO: Break up these tests. Most rely on multiple methods.

    @Test
    public void testAddMember() throws Exception {
        ArrayList<String> addMemberCommand = new ArrayList<String>();
        addMemberCommand.add("add_member");
        addMemberCommand.add("Paul Gries");
        assertEquals("New Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s) successfully added.",
                m.execute(addMemberCommand, container));

        try {
            String failMessage = m.execute(addMemberCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Paul Gries is already an existing Member!", e.getMessage());
        }
        ArrayList<String> memberInfoCommand = new ArrayList<String>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("Paul Gries");
        assertEquals("Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s)", m.execute(memberInfoCommand, container));
    }

    @Test
    public void testCreateMatch() throws Exception {
        ArrayList<String> createMatchCommand = new ArrayList<String>();
        createMatchCommand.add("create_match");
        createMatchCommand.add("Super Bowl");
        createMatchCommand.add("Ravens");
        createMatchCommand.add("Owls");
        assertEquals("New Match between Ravens and Owls successfully created.",
                m.execute(createMatchCommand, container));

        try {
            String failMessage = m.execute(createMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Super Bowl is already an existing Match!",
                    e.getMessage());
        }
    }

    @Test
    public void testBet() throws Exception {
        testAddMember();

        testCreateMatch();
        ArrayList<String> betCommand = new ArrayList<String>();
        betCommand.add("bet");
        betCommand.add("Paul Gries");
        betCommand.add("Super Bowl");
        betCommand.add("Owls");
        assertEquals("Paul Gries has successfully placed a bet that " +
                "Owls will win Super Bowl", m.execute(betCommand, container));

        try {
            ArrayList<String> betFakeMemberCommand = new ArrayList<String>();
            betFakeMemberCommand.add("bet");
            betFakeMemberCommand.add("Gries Paul");
            betFakeMemberCommand.add("Super Bowl");
            betFakeMemberCommand.add("Owls");
            String failMessage = m.execute(betFakeMemberCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Gries Paul is not an " +
                    "existing Member!", e.getMessage());
        }

        try {
            ArrayList<String> betFakeMatchCommand = new ArrayList<>();
            betFakeMatchCommand.add("bet");
            betFakeMatchCommand.add("Paul Gries");
            betFakeMatchCommand.add("Superb Owl");
            betFakeMatchCommand.add("Owls");
            String failMessage = m.execute(betFakeMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Superb Owl is not an existing Match!", e.getMessage());
        }

        try {
            ArrayList<String> betFakeTeamCommand = new ArrayList<String>();
            betFakeTeamCommand.add("bet");
            betFakeTeamCommand.add("Paul Gries");
            betFakeTeamCommand.add("Super Bowl");
            betFakeTeamCommand.add("Dogs");
            String failMessage = m.execute(betFakeTeamCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Dogs is not a Team in this Match!");
        }
    }

    @Test
    public void testResolveMatch() throws Exception {
        testBet();

        ArrayList<String> resolveMatchCommand = new ArrayList<String>();
        resolveMatchCommand.add("resolve_match");
        resolveMatchCommand.add("Super Bowl");
        resolveMatchCommand.add("Owls");
        assertEquals("Super Bowl was successfully resolved with Owls " +
                        "as the victors.", m.execute(resolveMatchCommand, container));

        try {
            String failMessage = m.execute(resolveMatchCommand, container);
            fail();
        } catch (Exception e) {
            assertEquals("Super Bowl is not an existing Match!", e.getMessage());
        }

        ArrayList<String> memberInfoCommand = new ArrayList<String>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("Paul Gries");
        assertEquals("Member Paul Gries with 1 correct bet(s) and " +
                        "0 incorrect bet(s)", m.execute(memberInfoCommand, container));
    }
}