import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicPlayerTest {

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
        assertEquals(100, player.getHealth());
        assertEquals(100, player.getMana());
        assertEquals(10, player.getStrength());
        assertEquals(10, player.getDexterity());
    }
}
