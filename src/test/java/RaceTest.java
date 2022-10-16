import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {



    @Test
    public void choosingRaceWhiteRat(){
        Player1 player1 = new WhiteRat(new BasicPlayer());
        assertEquals(120, player1.getMana());
    }
}
