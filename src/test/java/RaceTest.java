import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    @Test
    public void checkHealth(){
        Player player1 = new BasicPlayer();
        assertEquals(100, player1.getHealth());
    }

    @Test
    public void choosingRaceBrownRat(){
        Player player2 = new BrownRat(new BasicPlayer());
        assertEquals(120, player2.getHealth());
    }

    @Test
    public void choosingRaceWhiteRat(){
        Player player3 = new WhiteRat(new BasicPlayer());
        assertEquals(120, player3.getMana());
    }

    @Test
    public void choosingBlackRat(){
        Player player4 = new BlackRat(new BasicPlayer());
        assertEquals(110, player4.getHealth());
        assertEquals(110, player4.getMana());
    }
}
