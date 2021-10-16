package league_member;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    private LeagueMember leagueMember1;

    @Before
    public void setUp() throws Exception {
        leagueMember1 = new LeagueMember("Paul Gries");
    }

    @Test
    public void testRecordBets() {
        assert(leagueMember1.getCorrectBets() == 0);
        assert(leagueMember1.getIncorrectBets() == 0);

        leagueMember1.recordCorrectBet();
        leagueMember1.recordIncorrectBet();
        leagueMember1.recordCorrectBet();

        assert(leagueMember1.getCorrectBets() == 2);
        assert(leagueMember1.getIncorrectBets() == 1);
    }

    @Test
    public void testToString() {
        assertEquals(leagueMember1.toString(),
                "Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s)");
        leagueMember1.recordIncorrectBet();
        leagueMember1.recordCorrectBet();
        leagueMember1.recordIncorrectBet();
        assertEquals(leagueMember1.toString(),
                "Member Paul Gries with 1 correct bet(s) and " +
                        "2 incorrect bet(s)");
    }

    @Test
    public void testEqualsHashCode() {
        LeagueMember leagueMember2 = new LeagueMember("Paul Gries");
        assert(leagueMember1.equals(leagueMember2));
        assertEquals(leagueMember1.hashCode(), leagueMember2.hashCode());
    }
}