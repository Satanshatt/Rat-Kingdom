import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TradeTest {

    @Test
    public void choosingTradeBuilder(){
        Player player = new Builder(new BasicPlayer());
        assertEquals(12, player.getStrength());
    }

    @Test
    public void choosingTradeCircusArtist(){
        Player player = new CircusArtist(new BasicPlayer());
        assertEquals(12, player.getDexterity());
    }

    @Test
    public void choosingTradeStoryteller(){
        Player player = new Storyteller(new BasicPlayer());
        assertEquals(12, player.getIntelligence());
    }
}