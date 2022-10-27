import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    @Test
    public void testGetName(){
        Race raceBlackRat = new BlackRat(new BasicPlayer());
        Race raceBrownRat = new BrownRat(new BasicPlayer());
        Race raceWhiteRat = new WhiteRat(new BasicPlayer());
        assertEquals("Black rat", raceBlackRat.getName());
        assertEquals("Brown rat", raceBrownRat.getName());
        assertEquals("White rat", raceWhiteRat.getName());
    }

    @Test
    public void choosingBlackRat(){
        Player player = new BasicPlayer();
        player.chooseRace("Black rat");
        assertEquals(110, player.getHealth());
        assertEquals(110, player.getMana());
    }

    @Test
    public void choosingRaceBrownRat(){
        Player player = new BasicPlayer();
        player.chooseRace("Brown rat");
        assertEquals(120, player.getHealth());
    }

    @Test
    public void choosingRaceWhiteRat(){
        Player player = new BasicPlayer();
        player.chooseRace("White rat");
        assertEquals(120, player.getMana());
    }

}
