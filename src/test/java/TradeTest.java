import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TradeTest {

    @Test
    public void choosingTradeBuilder(){
        Player1 player1 = new Builder(new BasicPlayer());
        assertEquals(12, player1.getStrength());
    }

    @Test
    public void choosingTradeCircusArtist(){
        Player1 player1 = new CircusArtist(new BasicPlayer());
        assertEquals(12, player1.getDexterity());
    }

    @Test
    public void choosingTradeStoryteller(){
        Player1 player1 = new Storyteller(new BasicPlayer());
        assertEquals(12, player1.getIntelligence());
    }
}