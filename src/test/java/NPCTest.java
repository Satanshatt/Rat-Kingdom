import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

class NPCTest {

    int XPOSITION = 2;
    int YPOSITION = 4;
    int DAMAGE = 1;
    String NPCNAME = "NPC Name";

    @Test
    void walkIntoWallTest(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

    }

    @Test
    void isDeadTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        boolean expected = true;
        assertEquals(expected, npc.isDead());
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
    void damagePlayerTest(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        //npc.setDamage(DAMAGE);
        //assertEquals(npc.damagePlayer(), DAMAGE);
    }

    @Test
    void getNameAndSetNameTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        String expectedName = npc.setName(NPCNAME);
        assertEquals(npc.getName(), expectedName);
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
