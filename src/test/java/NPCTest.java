import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.mockito.Mockito;

class NPCTest {

    int XPOSITION = 2;
    int YPOSITION = 4;
    int DAMAGE = 1;

    @Test
    void isDeadTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        boolean expected = true;
        assertEquals(expected, npc.die());
    }

    @Test
    void spawnNPCControlledPositionTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.spawnNPC(XPOSITION, YPOSITION);
        assertEquals(XPOSITION, npc.getPosX());
        assertEquals(YPOSITION, npc.getPosY());
    }

    @Test
    void NPCtakesDamageTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        int NPCHealth = npc.getHealth();
        int expectedHealth = (NPCHealth - DAMAGE);
        npc.takeDamage(DAMAGE);
        assertEquals(expectedHealth, npc.getHealth());
    }

    @Test
    void getName() {
    }

    @Test
    void getType() {
    }

    @Test
    void getSize() {
    }

    @Test
    void getDamage() {
    }

    @Test
    void getHealth() {
    }

    @Test
    void getLevel() {
    }
}
