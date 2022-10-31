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
        assertEquals(0, fireRing.attackDamage());
        assertEquals(0, fireRing.attackSpeed());
    }

    @Test
    public void testIceRing(){
        iceRing = new IceRing();
        iceRing.setPlayer(player);
        assertEquals(0, iceRing.attackDamage());
        assertEquals(0, iceRing.attackSpeed());
    }

    @Test
    public void testFireRingAttack(){}

    @Test
    public void testIceRingAttack(){}

    @Test
    public void testChooseRing(){
        fireRing = new FireRing();
        iceRing = new IceRing();
        player.chooseRing(fireRing);
        player.chooseRing(iceRing);
        assertSame();
    }
}
