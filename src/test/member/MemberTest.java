package member;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    private Member member1;

    @Before
    public void setUp() throws Exception {
        member1 = new Member("Paul Gries");
    }

    @Test
    public void testRecordBets() {
        assert(member1.getCorrectBets() == 0);
        assert(member1.getIncorrectBets() == 0);

        member1.recordCorrectBet();
        member1.recordIncorrectBet();
        member1.recordCorrectBet();

        assert(member1.getCorrectBets() == 2);
        assert(member1.getIncorrectBets() == 1);
    }

    @Test
    public void testToString() {
        assertEquals(member1.toString(),
                "Member Paul Gries with 0 correct bet(s) and " +
                        "0 incorrect bet(s)");
        member1.recordIncorrectBet();
        member1.recordCorrectBet();
        member1.recordIncorrectBet();
        assertEquals(member1.toString(),
                "Member Paul Gries with 1 correct bet(s) and " +
                        "2 incorrect bet(s)");
    }

    @Test
    public void testEqualsHashCode() {
        Member member2 = new Member("Paul Gries");
        assert(member1.equals(member2));
        assertEquals(member1.hashCode(), member2.hashCode());
    }
}