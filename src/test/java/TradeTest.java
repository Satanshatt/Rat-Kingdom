import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class TradeTest {

    @Test
    public void testGetName(){
        Trade tradeBuilder = new Builder(new BasicPlayer());
        Trade tradeCircusArtist = new CircusArtist(new BasicPlayer());
        Trade tradeStoryteller = new Storyteller(new BasicPlayer());
        assertEquals("Builder", tradeBuilder.getName());
        assertEquals("Circus artist", tradeCircusArtist.getName());
        assertEquals("Storyteller", tradeStoryteller.getName());

    }

    @Test
    public void choosingTradeBuilder(){
        Player player = new BasicPlayer();
        player.chooseTrade("Builder");
        assertEquals(12, player.getStrength());
    }

    @Test
    public void choosingTradeCircusArtist(){
        Player player = new BasicPlayer();
        player.chooseTrade("Circus artist");
        assertEquals(12, player.getDexterity());
    }

    @Test
    public void choosingTradeStoryteller(){
        Player player = new BasicPlayer();
        player.chooseTrade("Storyteller");
        assertEquals(12, player.getIntelligence());
    }

    @Test
    public void choosingTradeBuilderWithMatchers(){
        Player player= new BasicPlayer();
        player.chooseTrade("Builder");
        assertThat(12, is(equalTo(player.getStrength())));
    }
}