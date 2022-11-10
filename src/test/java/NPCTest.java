import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

class NPCTest {

    int FOUR = 4;
    int THREE = 3;
    int FIVE = 5;
    int ONE = 1;
    int TWO = 2;
    int DAMAGE = 1;
    int NPC_HEALTH = 10;
    String NPC_NAME = "NPC Name";

    @Test
    void Should_BeFalse_When_PlayerNotWithinReach_ButOnSameYAxis(){

        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(TWO);
        player.setPosY(FOUR);
        npc.setPosX(FOUR);
        npc.setPosY(FOUR);
        assertFalse(npc.isPlayerWithinReach(player));
    }

    @Test
    void Should_BeFalse_When_PlayerNotWithinReach_ButOnSameXAxis(){

        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(TWO);
        npc.setPosX(FOUR);
        npc.setPosY(FOUR);
        assertFalse(npc.isPlayerWithinReach(player));
    }

    @Test
    void Should_BeTrue_When_PlayerWithinReach_OneYCoordinateBack(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(THREE);
        npc.setPosX(FOUR);
        npc.setPosY(FOUR);
        assertTrue(npc.isPlayerWithinReach(player));
    }

    @Test
    void Should_BeTrue_When_PlayerWithinReach_OneYCoordinateAhead(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(TWO);
        npc.setPosX(FOUR);
        npc.setPosY(ONE);
        assertTrue(npc.isPlayerWithinReach(player));
    }


    @Test
    void Should_BeTrue_When_PlayerWithinReach_OneXCoordinateAhead(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(FOUR);
        npc.setPosX(THREE);
        npc.setPosY(FOUR);
        assertTrue(npc.isPlayerWithinReach(player) == true);
    }



    @Test
    void Should_BeTrue_When_PlayerWithinReach_OneXCoordinateBack(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(FOUR);
        npc.setPosX(FIVE);
        npc.setPosY(FOUR);
        assertTrue(npc.isPlayerWithinReach(player) == true);
    }

    /*
    //Bort kommenterade då deras funktionalitet för tillfället inte verkar vara aktuell
    @Test
    void is_Dead_Should_Be_True_Test() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setHealth(-2);
        assertTrue(true == npc.isDead());
    }
    */

    /*
    @Test
    void is_Dead_Should_Be_False_Test(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setHealth(NPC_HEALTH);
        assertFalse(npc.isDead() == false);
    }
    */

    @Test
    void Should_BeEqual_When_NPCWalksLeft_And_TileIsNotBlocked(){
            NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
            Tile tile = new Tile("Ground", TWO, TWO, false);
            npc.setPosX(FOUR);
            npc.moveLeft(tile);
            int expectedXPosition = (FOUR -1);
            assertEquals(npc.getPosX(), expectedXPosition);
    }

    @Test
    void Should_BeEqual_When_NPCWalksRight_And_TileIsNotBlocked(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, false);
        npc.setPosX(FOUR);
        npc.moveRight(tile);
        int expectedXPosition = (FOUR +1);
        assertEquals(npc.getPosX(), expectedXPosition);
    }

    @Test
    void Should_BeEqual_When_NPCWalksUpwards_And_TileIsNotBlocked(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, false);
        npc.setPosY(FOUR); //satt till 4
        npc.moveUpwards(tile);
        int expectedYPosition = (FOUR +1);
        assertEquals(npc.getPosY(), expectedYPosition);
    }

    @Test
    void Should_BeEqual_When_NPCWalksDownwards_And_TileIsNotBlocked(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, false);
        npc.setPosY(FOUR);
        npc.moveDownwards(tile);
        int expectedYPosition = (FOUR -1);
        assertEquals(npc.getPosY(), expectedYPosition);
    }

    @Test
    void Should_BeFalse_When_NPCWalksOnBlockedTile(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, true);
        assertFalse(npc.checkIfLegalToMove(tile));
    }

    @Test
    void Should_BeEqual_When_NPCTakesDamage() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        int NPCHealth = npc.getHealth();
        int expectedHealth = (NPCHealth - DAMAGE);
        npc.takeDamage(DAMAGE);
        assertEquals(expectedHealth, npc.getHealth());
    }

    @Test
    void Should_BeTrue_When_PlayerTakesDamageFromNPC() {
        Player player = new Player();
        int playerHealth = player.getHealth();
        int playerExpectedHealth = playerHealth - DAMAGE;
        player.playerTakesDamage(this.DAMAGE);
        int playerNewHealth = player.getHealth();
        assertTrue(playerNewHealth == playerExpectedHealth);
    }

    @Test
    void Should_BeEqual_When_GettingAndSettingNPCName() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setName(NPC_NAME);
        assertEquals(npc.getName(), NPC_NAME);
    }

    @Test
    void Should_BeEqual_When_GettingAndSettingNPCDamage() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setDamage(DAMAGE);
        assertEquals(npc.getDamage(), DAMAGE);
    }

    @Test
    void Should_BeEqual_When_GettingAndSettingNPCHealth() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setHealth(NPC_HEALTH);
        assertEquals(npc.getHealth(), NPC_HEALTH);
    }

}
