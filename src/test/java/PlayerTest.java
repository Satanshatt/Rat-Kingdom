import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private static final int START_POS_X = 0;
    private static final int START_POS_Y = 0;
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
    public void player_Walk_One_Step_Left () {
        Player player = new Player();
        int stepsInput = 1;
        player.walkLeft(stepsInput);
        int currentPosX = player.getPosX();
        assertEquals(START_POS_X - stepsInput, currentPosX);
    }

    @Test
    public void player_Walk_Negative_Step_Left_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                int stepsInput = -1;
                player.walkLeft(stepsInput);
            }
        });
    }

    @Test
    public void player_Walk_Zero_Step_Left_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                int stepsInput = 0;
                player.walkLeft(stepsInput);
            }
        });
    }

    @Test
    public void player_Walk_One_Step_Right () {
        Player player = new Player();
        int stepsInput = 1;
        player.walkRight(stepsInput);
        int currentPosX = player.getPosX();
        assertEquals(START_POS_X + stepsInput, currentPosX);
    }

    @Test
    public void player_Walk_Negative_Step_Right_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                int stepsInput = -1;
                player.walkRight(stepsInput);
            }
        });
    }

    @Test
    public void player_Walk_Zero_Step_Right_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                int stepsInput = 0;
                player.walkRight(stepsInput);
            }
        });
    }

    @Test
    public void player_Walk_One_Step_Forward () {
        Player player = new Player();
        int stepsInput = 1;
        player.walkForward(stepsInput);
        int currentPosY = player.getPosY();
        assertEquals(START_POS_Y + stepsInput, currentPosY);
    }

    @Test
    public void player_Walk_Negative_Step_Forward_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                int stepsInput = -1;
                player.walkForward(stepsInput);
                int currentPosY = player.getPosY();
                assertEquals(START_POS_Y + stepsInput, currentPosY);
            }
        });
    }

    @Test
    public void player_Walk_Zero_Step_Forward_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                int stepsInput = 0;
                player.walkForward(stepsInput);
            }
        });
    }

    //Snacka med Hannes
    @Test
    public void player_Try_Walk_Outside_Room_Error () {
    }

    @Test
    public void player_Try_Walk_One_Step_Forward_To_Occupied_Coordinate_Error () {

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = new Enemy("Namn", "Typ", 10, 10, 10, 1, 0,1);
                player.walkForward(1);
            }
        });

    }

    @Test
    public void player_Dies () {
        Player player = new Player();
        player.die();
        assertTrue(player.isDead());
    }

    @Test
    public void player_Use_Door () {}

    @Test
    public void player_Fret_NPC () {
        Player player = new Player();
        //NPC npc = new Enemy("Namn", "Type", 10, 10, 10, 10, 0, 1);
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
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
        // npc.hurtPlayer(Player player); Eller liknande
        int playerHealthAfterAttack = player.getHealth();
        assertTrue(playerStartHealth > playerHealthAfterAttack);
    }

    @Test
    public void add_Over_Health_Maxvalue_Health_Value_Is_Maxvalue () {
        Player player = new Player();
        player.increaseHealth(HEALTH_MAX_VALUE + 1);
        assertEquals(HEALTH_MAX_VALUE, player.getHealth());
    }

    @Test
    public void health_Goes_Under_Zero_Player_Dies () {
        Player player = new Player();
        player.damagePlayer(player.getHealth() + 1);
        assertTrue(player.isDead());
    }

    @Test
    public void mana_Increase_By_Level () {

    }

    @Test
    public void kill_NPC_Success () {
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Player player = new Player();
        Weapon sword = new Sword();
        boolean npcIsDead = npc.getHealth()<= 0;
        while (!npcIsDead) {
            player.useWeaponOnNPC(sword, npc);
        }
        assertTrue(npcIsDead);


    }

    @Test
    public void kill_NPC_And_Increase_Xp () {} //Eller annat än xp

    @Test
    public void level_Upgrade_With_Xp_Success(){
        Player player = new Player();
        int levelUp = 1;
        player.increaseXp(XP_MAX_VALUE);
        assertEquals(DEFAULT_VALUE_LEVEL + levelUp, player.getLevel());

    }

    @Test
    public void testFretDamage() {

    }
}
