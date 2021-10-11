
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
        assertEquals(player.getTeam(), "Washington Capitals");
    }

    @Test(timeout = 50)
    public void TestPositionSetterandGetter() {
        player.setPosition("Left winger");
        assertEquals(player.getPosition(), "Left winger");
    }

    @Test(timeout = 50)
    public void TestAgeSetterandGetter() {
        assertEquals(36, player.getAge());
        player.setAge(37);
        assertEquals(player.getAge(), 37);
    }
}
