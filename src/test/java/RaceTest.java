import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    @Test
    public void testGetName(){
        Race raceBlackRat = new BlackRat(new Player());
        Race raceBrownRat = new BrownRat(new Player());
        Race raceWhiteRat = new WhiteRat(new Player());
        assertEquals("Black rat", raceBlackRat.getName());
        assertEquals("Brown rat", raceBrownRat.getName());
        assertEquals("White rat", raceWhiteRat.getName());
    }

    @Test
    public void choosingBlackRat(){
        Player player = new Player();
        player.chooseRace("Black rat");
        assertEquals(110, player.getHealth());
        assertEquals(110, player.getMana());
    }

    @Test
    public void choosingRaceBrownRat(){
        Player player = new Player();
        player.chooseRace("Brown rat");
        assertEquals(120, player.getHealth());
    }

    @Test
    public void choosingRaceWhiteRat(){
        Player player = new Player();
        player.chooseRace("White rat");
        assertEquals(120, player.getMana());
    }
}
