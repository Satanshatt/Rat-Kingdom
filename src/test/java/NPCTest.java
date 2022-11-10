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
    void walkIntoWallTest() {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    void player_Is_Not_Within_Reach_But_On_Same_Y_Axis_Test(){

        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(TWO);
        player.setPosY(FOUR);
        npc.setPosX(FOUR);
        npc.setPosY(FOUR);
        assertFalse(npc.isPlayerWithinReach(player));
    }

    @Test
    void player_Is_Not_Within_Reach_But_On_Same_X_Axis_Test(){

        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(TWO);
        npc.setPosX(FOUR);
        npc.setPosY(FOUR);
        assertFalse(npc.isPlayerWithinReach(player));
    }

    @Test
    void player_Is_Within_Reach_On_X_Axis_NPC_One_Y_Coordinate_Positive_Off_One_Test(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(FOUR);
        npc.setPosX(FOUR);
        npc.setPosY(THREE);
        assertTrue(npc.isPlayerWithinReach(player));
    }

    @Test
    void player_Is_Within_Reach_On_X_Axis_One_Y_Coordinate_Negative_Off_Test(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(4);
        player.setPosY(2);
        npc.setPosX(4);
        npc.setPosY(1);
        assertTrue(npc.isPlayerWithinReach(player));
    }


    @Test
    void player_Is_Within_Reach_On_Y_Axis_One_X_Coordinate_Negative_Off_Test(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(FOUR);
        npc.setPosX(THREE);
        npc.setPosY(FOUR);
        assertTrue(npc.isPlayerWithinReach(player) == true);
    }



    @Test
    void player_Is_Within_Reach_On_Y_Axis_One_X_Coordinate_Negative_OffTest(){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        player.setPosX(FOUR);
        player.setPosY(FOUR);
        npc.setPosX(FIVE);
        npc.setPosY(FOUR);
        assertTrue(npc.isPlayerWithinReach(player) == true);
    }

    /*
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
    void npc_Should_Move_Left_Tile_Not_Blocked_Test(){
            NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
            Tile tile = new Tile("Ground", TWO, TWO, false);
            npc.setPosX(FOUR);
            npc.moveLeft(tile);
            int expectedXPosition = (FOUR -1);
            assertEquals(npc.getPosX(), expectedXPosition);
    }

    @Test
    void npc_Should_Move_Right_Tile_Not_Blocked_Test(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, false);
        npc.setPosX(FOUR);
        npc.moveRight(tile);
        int expectedXPosition = (FOUR +1);
        assertEquals(npc.getPosX(), expectedXPosition);
    }

    @Test
    void npc_Should_Move_Up_Tile_Not_Blocked_Test(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, false);
        npc.setPosY(FOUR); //satt till 4
        npc.moveUpwards(tile);
        int expectedYPosition = (FOUR +1);
        assertEquals(npc.getPosY(), expectedYPosition);
    }

    @Test
    void npc_Should_Move_Down_Tile_Not_Blocked_Test(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, false);
        npc.setPosY(FOUR);
        npc.moveDownwards(tile);
        int expectedYPosition = (FOUR -1);
        assertEquals(npc.getPosY(), expectedYPosition);
    }

    @Test
    void npc_Try_To_Move_Tile_Is_Blocked_Test(){
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Tile tile = new Tile("Ground", TWO, TWO, true);
        assertFalse(npc.checkIfLegalToMove(tile));
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
    void damagePlayerTest() {
        Player player = new Player();
        int playerHealth = player.getHealth();
        int playerExpectedHealth = playerHealth - DAMAGE;
        player.playerTakesDamage(this.DAMAGE);
        int playerNewHealth = player.getHealth();
        assertTrue(playerNewHealth == playerExpectedHealth);
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
