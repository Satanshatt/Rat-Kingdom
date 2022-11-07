import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private static final int START_POS_X = 1;
    private static final int START_POS_Y = 1;
    private static final int DEFAULT_VALUE_HEALTH = 100;
    private static final int DEFAULT_VALUE_MANA = 100;
    private static final int DEFAULT_VALUE_STRENGTH = 10;
    private static final int DEFAULT_VALUE_DEXTERITY = 10;
    private static final int DEFAULT_VALUE_INTELLIGENCE = 10;
    private static final int DEFAULT_VALUE_XP = 0;
    private static final int DEFAULT_VALUE_LEVEL = 1;
    private static final String SWORD_EQUIPMENT = "Sword";
    private static final int XP_MAX_VALUE = 100;
    private static final int HEALTH_MAX_VALUE = 100;
    private static final int NEGATIVE_INPUT = -1;
    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;

    @Test
    public void player_defaultValue_Is_Correct () {
        Player player = new Player();
        assertEquals(DEFAULT_VALUE_HEALTH, player.getHealth());
        assertEquals(DEFAULT_VALUE_MANA, player.getMana());
        assertEquals(DEFAULT_VALUE_STRENGTH, player.getStrength());
        assertEquals(DEFAULT_VALUE_DEXTERITY, player.getDexterity());
        assertEquals(DEFAULT_VALUE_INTELLIGENCE, player.getIntelligence());
        assertEquals(DEFAULT_VALUE_XP, player.getXp());
        assertEquals(DEFAULT_VALUE_LEVEL, player.getLevel());
        assertEquals(START_POS_X, player.getPosX());
        assertEquals(START_POS_Y, player.getPosY());
    }

    @Test
    public void player_Moves () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();

        int xBefore = player.getPosX();
        player.move(room, START_POS_X + 1, START_POS_Y);
        int xAfter = player.getPosX();

        System.out.println("Before: " + xBefore + "after: " + xAfter);

        assertTrue(xBefore != xAfter);
    }

    @Test
    public void plyer_Moves_room_is_null_error () {
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                Room room = null;
                player.move(room, START_POS_X + 1, START_POS_Y);
            }
        });
    }

    @Test
    public void player_Try_Move_To_Occupied_coordinate_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();

                npc.setPosX(2);
                npc.setPosY(2);
                room.addEntity(npc);

                player.move(room, 2, 2);
            }
        });
    }
    //Snacka med Hannes
    @Test
    public void player_Try_Walk_Outside_Room_Error () {
    }

    @Test
    public void player_Dies () {
        Player player = new Player();
        player.increaseLevel();
        int higherLevel = player.getLevel();
        player.die();
        assertTrue(higherLevel > DEFAULT_VALUE_LEVEL);
    }

    @Test
    public void player_Use_Door () {}

    @Test
    public void player_Fret_NPC () {
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        npc.setPosX(npc.getPosX()+1);
        int npcStartDamage = npc.getHealth();
        player.fret(npc);
        int npcDamageAfterAttack = npc.getHealth();
        assertTrue(npcStartDamage > npcDamageAfterAttack);
    }

    @Test
    public void player_Try_Fret_NPC_Out_Of_Range_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                player.fret(npc);
            }
        });
    }

    //Kommer en npc kunna möta en npc som inte är samma level? Testa i npc-klassen?
    @Test
    public void player_Level_And_NPC_Level_Not_The_Same_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                player.increaseLevel();
            }
        });
    }

    //Ej klar, behöver metod i NPC som skadar en player
    @Test
    public void player_Gets_Hurt_By_NPC () {
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

        int playerStartHealth = player.getHealth();
        npc.damagePlayer(player);
        int playerHealthAfterAttack = player.getHealth();

        assertTrue(playerStartHealth > playerHealthAfterAttack);
    }

    /*
    @Test
    public void add_Over_Health_Maxvalue_Health_Value_Is_Maxvalue () {
        Player player = new Player();
        player.increaseHealth(HEALTH_MAX_VALUE + 1);
        assertEquals(HEALTH_MAX_VALUE, player.getHealth());
    }


     */
    /*
    När spelaren dör startar man om på ruta ett igen, dvs tillbaka till nivå 1.
     */
    @Test
    public void health_Goes_Under_Zero_Player_Dies () {
        Player player = new Player();
        player.increaseLevel();
        int higherLevel = player.getLevel();
        player.damagePlayer(player.getHealth() + 1);
        assertTrue(higherLevel > DEFAULT_VALUE_LEVEL);
    }

    @Test
    public void mana_Increase_By_Level () {

    }

    @Test
    public void kill_NPC_With_Weapon_Increase_Xp () {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Player player = new Player();
        Weapon sword = new Sword();

        int xPBefore = player.getXp();
        player.killNPCWithWeapon(npc, sword);
        int xPAfter = player.getXp();

        assertTrue(xPBefore < xPAfter);
    }

    @Test
    public void kill_NPC_And_Increase_Xp () {
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

        int xPBefore = player.getXp();
        player.killNPCWithoutWeapon(npc);
        int xPAfter = player.getXp();

        assertTrue(xPBefore < xPAfter);
    } //Eller annat än xp

    @Test
    public void level_Upgrade_With_Xp_Success(){
        Player player = new Player();
        int levelUp = 1;
        player.increaseXp( XP_MAX_VALUE +1);
        assertEquals(DEFAULT_VALUE_LEVEL + levelUp, player.getLevel());

    }

    @Test
    public void pick_Up_Weapon_And_Activate () {
        Player player = new Player();
        Weapon weapon = Mockito.mock(Weapon.class, Mockito.CALLS_REAL_METHODS);
        player.pickUpWeapon(weapon);
        assertEquals(weapon, player.getActiveWeapon());
    }

    @Test
    public void increase_With_Negative_Health_input_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseHealth(NEGATIVE_INPUT);
            }
        });

    }

    @Test
    public void player_Pick_Up_MagicRing () {}

    @Test
    public void player_Choose_Trade () {}

    @Test
    public void player_Choose_Race () {}



}
