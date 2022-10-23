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
    public void basicPlayer_defaultValue_Is_Correct () {
        Player player = new BasicPlayer();
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
                int currentPosX = player.getPosX();
                assertEquals(START_POS_X - stepsInput, currentPosX);
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



}
