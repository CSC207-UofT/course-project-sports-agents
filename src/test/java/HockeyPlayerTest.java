import org.junit.*;

import static org.junit.Assert.*;

public class HockeyPlayerTest {
    HockeyPlayer player;

    @Before
    public void setUp() {
        player = new HockeyPlayer("Alex Ovechkin", 36, "Russian");
    }

    @After
    public void tearDown() {}

    @Test(timeout = 50)
    public void TestTeamSetterAndGetter() {
        player.setTeam("Washington Capitals");
        assertEquals("Washington Capitals", player.getTeam());
    }

    @Test(timeout = 50)
    public void TestPositionSetterAndGetter() {
        player.setPosition("Left winger");
        assertEquals("Left winger", player.getPosition());
    }

    @Test(timeout = 50)
    public void TestAgeSetterAndGetter() {
        assertEquals(36, player.getAge());
        player.setAge(37);
        assertEquals(37, player.getAge());
    }

    @Test(timeout = 50)
    public void TestAssistAndGoalSetterAndGetter() {
        player.setAssists(10);
        player.setGoals(5);
        assertEquals(5, player.getGoals());
        assertEquals(10, player.getAssists());
        assertEquals(15, player.getPoints());
    }

}
