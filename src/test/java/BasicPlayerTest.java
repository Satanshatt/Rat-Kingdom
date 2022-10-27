import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BasicPlayerTest {

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

/*
    @Test
    public void list_Should_Be_Empty () {
        Player player = new BasicPlayer();
        assertTrue( player.getEquipment().isEmpty());
    }

    @Test
    public void test_Add_Object_To_List_Success () {
        Player player = new BasicPlayer();
        Equipment e = new Equipment(player, SWORD_EQUIPMENT);
        player.addEquipment(e);
        assertTrue (player.getEquipment().contains(e));
    }

    @Test
    public void add_Duplicates_To_List_Success () {
        Player player = new BasicPlayer();
        Equipment e = new Equipment(player, SWORD_EQUIPMENT);
        Equipment e2 = new Equipment(player, SWORD_EQUIPMENT);
        player.addEquipment(e, e2);
        assertTrue(player.getEquipment().contains(e) &&
                player.getEquipment().contains(e2));
    }

    @Test
    public void test_Add_Null_To_List_Get_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new BasicPlayer();
                player.addEquipment(null);
            }
        });
    }

    @Test
    public void test_Add_Object_When_List_Is_Full_Error () {}

 */

    @Test
    public void basicPlayer_defaultValue_Is_Correct () {
        BasicPlayer player = new BasicPlayer();
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
        Player player = new BasicPlayer();
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
                Player player = new BasicPlayer();
                int stepsInput = -1;
                player.walkLeft(stepsInput);
                //int currentPosX = player.getPosX();
                //assertEquals(START_POS_X + stepsInput, currentPosX);
            }
        });
    }

    @Test
    public void player_Walk_Zero_Step_Left_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new BasicPlayer();
                int stepsInput = 0;
                player.walkLeft(stepsInput);
                int currentPosX = player.getPosX();
                assertEquals(START_POS_X - stepsInput, currentPosX);
            }
        });
    }

    @Test
    public void player_Walk_One_Step_Right () {
        Player player = new BasicPlayer();
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
                Player player = new BasicPlayer();
                int stepsInput = -1;
                player.walkRight(stepsInput);
                int currentPosX = player.getPosX();
                assertEquals(START_POS_X + stepsInput, currentPosX);
            }
        });
    }

    @Test
    public void player_Walk_Zero_Step_Right_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new BasicPlayer();
                int stepsInput = 0;
                player.walkRight(stepsInput);
                int currentPosX = player.getPosX();
                assertEquals(START_POS_X + stepsInput, currentPosX);
            }
        });
    }

    @Test
    public void player_Walk_One_Step_Forward () {
        Player player = new BasicPlayer();
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
                Player player = new BasicPlayer();
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
                Player player = new BasicPlayer();
                int stepsInput = 0;
                player.walkForward(stepsInput);
                int currentPosY = player.getPosY();
                assertEquals(START_POS_Y + stepsInput, currentPosY);
            }
        });
    }

    @Test
    public void player_Try_Walk_Outside_Room_Error () {
        Player player = new BasicPlayer();
        //Room room = new Room()

    }

    @Test
    public void player_Try_Walk_One_Step_Forward_To_Occupied_Coordinate_Error () {

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new BasicPlayer();
                NPC npc = new Enemy("Namn", "Typ", 10, 10, 10, 10, 0,1);
                player.walkForward(1);
            }
        });

    }

    @Test
    public void player_Can_Jump () {}

    @Test
    public void player_Can_Jump_Over_Obsticle () {}

    @Test
    public void player_Try_Jump_Over_Too_High_Obsticle_Error () {

    }

    @Test
    public void player_Dies () {
        Player player = new BasicPlayer();
        player.die();
        assertTrue(player.isDead());
    }

    @Test
    public void player_Use_Door () {}

    @Test
    public void player_Fret_NPC () {
        BasicPlayer player = new BasicPlayer();
        NPC npc = new Enemy("Namn", "Type", 10, 10, 10, 10, 0, 1);
        int npcStartDamage = npc.getDamage();
        player.fret(npc);
        int npcDamageAfterAttack = npc.getDamage();
        assertTrue(npcStartDamage > npcDamageAfterAttack);
    }

    @Test
    public void player_Try_Fret_NPC_Out_Of_Range_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                BasicPlayer player = new BasicPlayer();
                NPC npc = new Enemy("Namn", "Type", 10, 10, 10, 10, 0, 2);
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
                BasicPlayer player = new BasicPlayer();
                NPC npc = new Enemy("Namn", "Type", 10, 10, 10, 2, 0, 1);

            }
        });
    }

    @Test
    public void player_Gets_Hurt_By_NPC () {}

    @Test
    public void health_Add_Over_Maxvalue_100_Error () {}

    @Test
    public void health_Goes_Under_Zero_Player_Dies () {
        Player player = new BasicPlayer();
        int currentHealth = player.getHealth();
        assertTrue(player.isDead());
    }

    @Test
    public void mana_Increase_By_Level () {}

    @Test
    public void kill_NPC_Success () {
        NPC enemy = new Enemy("Fiende", "type", 10, 10, 2, 1, 0, 0);
        Player player = new BasicPlayer();
        Weapon sword = new Sword(player);
        /*
        while (!enemy.getIsDead) {
            player.useWeapon(sword, enemy);
        }
        assertTrue(enemy.isDead);
         */


    }

    @Test
    public void kill_NPC_And_Increase_Xp () {} //Eller annat än xp

    @Test
    public void level_Upgrade_With_Xp_Success(){
        Player player = new BasicPlayer();
        int levelUp = 1;
        player.increaseXp(XP_MAX_VALUE);
        assertEquals(DEFAULT_VALUE_LEVEL + levelUp, player.getLevel());

    }

    @Test
    public void testFretDamage() {
        BasicPlayer player = new BasicPlayer();
        Player player1 = new BasicPlayer();

    }
}
