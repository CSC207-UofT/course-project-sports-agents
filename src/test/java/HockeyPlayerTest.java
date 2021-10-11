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
    public void TestTeamSetterandGetter() {
        player.setTeam("Washington Capitals");
        assertEquals("Washington Capitals", player.getTeam());
    }

    @Test(timeout = 50)
    public void TestPositionSetterandGetter() {
        player.setPosition("Left winger");
        assertEquals("Left winger", player.getPosition());
    }

    @Test(timeout = 50)
    public void TestAgeSetterandGetter() {
        assertEquals(36, player.getAge());
        player.setAge(37);
        assertEquals(37, player.getAge());
    }

    @Test(timeout = 50)
    public void TestGoalSetterandGetter() {
        assertEquals(0, player.getGoals());
        player.addGoal();
        player.addGoal();
        assertEquals(2, player.getGoals());
        assertEquals(2, player.getPoints());
    }

    @Test(timeout = 50)
    public void TestAssistSetterandGetter() {
        assertEquals(0, player.getAssists());
        player.addAssist();
        player.addAssist();
        player.addAssist();
        assertEquals(3, player.getAssists());
        assertEquals(5, player.getPoints());
    }
}
