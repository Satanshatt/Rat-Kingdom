import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class NPCTest {

    @Test
    void isDeadTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        boolean expected = true;
        assertEquals(expected, npc.die());
    }

    @Test
    void battle() {
    }

    @Test
    void moveForBattle() {
    }

    @Test
    void spawn() {
    }

    @Test
    void NPCtakesDamageTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        //int dealtDamage = health - npc.getDamage()
        //assertEquals(dealtDamage, npc.getDamage());

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
