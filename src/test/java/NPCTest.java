import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

class NPCTest {

    int XPOSITION = 2;
    int YPOSITION = 4;
    int DAMAGE = 1;
    int NPC_HEALTH = 10;
    int NPC_LEVEL = 10;
    int NPC_SIZE = 10;
    String NPC_NAME = "NPC Name";
    String NPC_TYPE = "NPC Type";

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
        /*npc.spawnNPC(XPOSITION, YPOSITION);
        assertEquals(XPOSITION, npc.getPosX());
        assertEquals(YPOSITION, npc.getPosY());*/
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

    }

    @Test
    void getNameAndSetNameTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setName(NPC_NAME);
        assertEquals(npc.getName(), NPC_NAME);
    }


    @Test
    void getDamageAndSetDamageTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setDamage(DAMAGE);
        assertEquals(npc.getDamage(), DAMAGE);
    }

    @Test
    void getHealthAndSetHealthTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setHealth(NPC_HEALTH);
        assertEquals(npc.getHealth(), NPC_HEALTH);
    }

}
