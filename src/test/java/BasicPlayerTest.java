import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void list_Should_Be_Empty () {
        Player player = new BasicPlayer();
        assertTrue( player.getEquipment().isEmpty());
    }

    @Test
    public void list_Should_Contain_Object () {
        Player player = new BasicPlayer();
        Equipment e = new Equipment(player, "Sword");
        player.addEquipment(e);
        assertTrue (player.getEquipment().contains(e));
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
        int steps = 1;
        player.walkLeft(steps);
        int currentPosX = player.getPosX();
        assertEquals(START_POS_X + steps, currentPosX);
    }
}
