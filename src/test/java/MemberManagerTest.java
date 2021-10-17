import commands.LeagueMemberManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberManagerTest {
    private LeagueMemberManager m;

    @Before
    public void setUp() throws Exception {
        m = new LeagueMemberManager();
    }

    // TODO: Break up these tests. Most rely on multiple methods.

    @Test
    public void testAddMember() throws Exception {
        ArrayList<String> addMemberCommand = new ArrayList<String>();
        addMemberCommand.add("add_member");
        addMemberCommand.add("Paul Gries");
        assertEquals(m.execute(addMemberCommand),
                "New Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s) successfully added.");

        try {
            String failMessage = m.execute(addMemberCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Paul Gries is already an existing Member!");
        }
        ArrayList<String> memberInfoCommand = new ArrayList<String>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("Paul Gries");
        assertEquals(m.execute(memberInfoCommand),
                "Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s)");
    }

    @Test
    public void testCreateMatch() throws Exception {
        ArrayList<String> createMatchCommand = new ArrayList<String>();
        createMatchCommand.add("create_match");
        createMatchCommand.add("Super Bowl");
        createMatchCommand.add("Ravens");
        createMatchCommand.add("Owls");
        // TODO: Update this to reflect Match.toString()
        assertEquals(m.execute(createMatchCommand),
                "New Match Super Bowl successfully created.");

        try {
            String failMessage = m.execute(createMatchCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Super Bowl is already an existing Match!");
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
        assertEquals(m.execute(betCommand),
                "Paul Gries has successfully placed a bet that " +
                        "Owls will win Super Bowl");

        try {
            ArrayList<String> betFakeMemberCommand = new ArrayList<String>();
            betFakeMemberCommand.add("bet");
            betFakeMemberCommand.add("Gries Paul");
            betFakeMemberCommand.add("Super Bowl");
            betFakeMemberCommand.add("Owls");
            String failMessage = m.execute(betFakeMemberCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Gries Pail is not an " +
                    "existing Member!");
        }

        try {
            ArrayList<String> betFakeMatchCommand = new ArrayList<>();
            betFakeMatchCommand.add("bet");
            betFakeMatchCommand.add("Paul Gries");
            betFakeMatchCommand.add("Superb Owl");
            betFakeMatchCommand.add("Owls");
            String failMessage = m.execute(betFakeMatchCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Super Bowl is not an existing Match!");
        }

        try {
            ArrayList<String> betFakeTeamCommand = new ArrayList<String>();
            betFakeTeamCommand.add("bet");
            betFakeTeamCommand.add("Paul Gries");
            betFakeTeamCommand.add("Super Bowl");
            betFakeTeamCommand.add("Dogs");
            String failMessage = m.execute(betFakeTeamCommand);
            fail();
        } catch (Exception e) {
            // TODO: Update this to reflect Match's error
            assertEquals(e.getMessage(), "TODO");
        }
    }

    @Test
    public void testResolveMatch() throws Exception {
        testBet();

        ArrayList<String> resolveMatchCommand = new ArrayList<String>();
        resolveMatchCommand.add("resolve_match");
        resolveMatchCommand.add("Superb Owl");
        resolveMatchCommand.add("Owls");
        assertEquals(m.execute(resolveMatchCommand),
                "Superb Owl was successfully resolved with Owls " +
                        "as the Victors.");

        try {
            String failMessage = m.execute(resolveMatchCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Superb Owl is not an existing Match!");
        }

        ArrayList<String> memberInfoCommand = new ArrayList<String>();
        memberInfoCommand.add("member_info");
        memberInfoCommand.add("Paul Gries");
        assertEquals(m.execute(memberInfoCommand),
                "Member Paul Gries with 1 correct bet(s) and " +
                        "0 incorrect bet(s)");
    }
}