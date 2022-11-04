import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagicRingTest {
    private Player player;
    MagicRing fireRing;
    MagicRing iceRing;

    @BeforeEach
    public void setUp(){
        player = new Player();
    }

    @Test
    public void testFireRing(){
        fireRing = new FireRing();
        fireRing.setPlayer(player);
        //Player is level 1
        assertEquals(11, fireRing.attackDamage());
        assertEquals(11, fireRing.attackSpeed());
    }

    @Test
    public void testIceRing(){
        iceRing = new IceRing();
        iceRing.setPlayer(player);
        //Player is level 1
        assertEquals(11, iceRing.attackDamage());
        assertEquals(11, iceRing.attackSpeed());
    }

    @Test
    public void testChooseRingFirstTime(){
        fireRing = new FireRing();
        player.pickUpMagicRing(fireRing);
        assertSame(fireRing, player.getActiveMagicRing());
    }

    @Test
    public void testChooseRing(){
        fireRing = new FireRing();
        iceRing = new IceRing();
        player.pickUpMagicRing(fireRing);
        player.pickUpMagicRing(iceRing);
        assertSame(iceRing, player.getActiveMagicRing());
    }
}
