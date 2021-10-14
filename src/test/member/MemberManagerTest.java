package member;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberManagerTest {
    private MemberManager m;

    @Before
    public void setUp() throws Exception {
        m = new MemberManager();
    }

    // TODO: Break up these tests?

    @Test
    public void testAddMember() {
        String[] addMemberCommand = {"add_member", "Paul Gries"};
        assertEquals(m.execute(addMemberCommand),
                "New Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s) successfully added.");

        try {
            String failMessage = m.execute(addMemberCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Paul Gries is already an existing Member!");
        }
    }

    @Test
    public void testCreateMatch() {
        String[] createMatchCommand = {"create_match", "Superb Owl",
                "Ravens", "Owls"};
        // TODO: Update this to reflect Match.toString()
        assertEquals(m.execute(createMatchCommand),
                "New Match Superb Owl successfully created.");

        try {
            String failMessage = m.execute(createMatchCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Superb Owl is already an existing Match!");
        }
    }

    @Test
    public void testBet() {
        String[] addMemberCommand = {"add_member", "Paul Gries"};
        assertEquals(m.execute(addMemberCommand),
                "New Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s) successfully added.");

        String[] createMatchCommand = {"create_match", "Superb Owl",
                "Ravens", "Owls"};
        assertEquals(m.execute(createMatchCommand),
                "New Match Superb Owl successfully created.");

        String[] betCommand = {"bet", "Paul Gries",
                "Superb Owl", "Owls"};
        assertEquals(m.execute(betCommand),
                "Paul Gries has successfully placed a bet that " +
                        "Owls will win Superb Owl");

        try {
            String[] betFakeMemberCommand = {"bet", "Gries Paul",
                    "Superb Owl", "Owls"};
            String failMessage = m.execute(betFakeMemberCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Gries Pail is not an " +
                    "existing Member!");
        }

        try {
            String[] betFakeMatchCommand = {"bet", "Paul Gries",
                    "Super Bowl", "Owls"};
            String failMessage = m.execute(betFakeMatchCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Super Bowl is not an existing Match!");
        }

        try {
            String[] betFakeTeamCommand = {"bet", "Paul Gries",
                    "Super Bowl", "Dogs"};
            String failMessage = m.execute(betFakeTeamCommand);
            fail();
        } catch (Exception e) {
            // TODO: Update this to reflect Match's error
            assertEquals(e.getMessage(), "TODO");
        }
    }

    @Test
    public void testResolveMatch() {
        String[] addMemberCommand = {"add_member", "Paul Gries"};
        assertEquals(m.execute(addMemberCommand),
                "New Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s) successfully added.");

        String[] createMatchCommand = {"create_match", "Superb Owl",
                "Ravens", "Owls"};
        assertEquals(m.execute(createMatchCommand),
                "New Match Superb Owl successfully created.");

        String[] betCommand = {"bet", "Paul Gries",
                "Superb Owl", "Owls"};
        assertEquals(m.execute(betCommand),
                "Paul Gries has successfully placed a bet that " +
                        "Owls will win Superb Owl");

        String[] resolveMatchCommand = {"resolve_match", "Superb Owl", "Owls"};
        assertEquals(m.execute(resolveMatchCommand),
                "Superb Owl was successfully resolved with Owls " +
                        "as the Victors.");

        try {
            String failMessage = m.execute(resolveMatchCommand);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Superb Owl is not an existing Match!");
        }
    }
}