package FantasyLeague;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    private Match match;
    private LeagueMember member1;
    private LeagueMember member2;

    @Before
    public void setUp() throws Exception {
        member1 = new LeagueMember("Paul");
        member2 = new LeagueMember("Gries");
        match = new Match("Red Team", "Blue Team");
        match.addBet(member1, "Red Team");
        match.addBet(member2, "Blue Team");
    }

    @Test
    public void testGetTeams() {
        assertEquals("Red Team", match.getTeamA());
        assertEquals("Blue Team", match.getTeamB());
    }

    @Test
    public void testResolve() throws Exception {
        match.resolve("Red Team");
        assertEquals(1, member1.getCorrectBets());
        assertEquals(0, member1.getIncorrectBets());
        assertEquals(0, member2.getCorrectBets());
        assertEquals(1, member2.getIncorrectBets());
    }

    @Test
    public void testTestEquals() {
        Match rematch = new Match("Red Team", "Blue Team");
        assertEquals(rematch, match);
    }

    @Test
    public void testTestToString() {
        assertEquals("Match between Red Team and Blue Team",
                match.toString());
    }
}