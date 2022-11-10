import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

public class AntTest {

    int NINETYFIVE = 95;

    @Test
    public void Should_BeFalse_When_NPCAttacksAndMissesPlayer() {
        Ant ant = new Ant(1, 2);
        Player player = new Player();
        player.setPosX(5);
        player.setPosY(2);
        assertFalse(ant.isPlayerWithinReach(player));

    }

    @Test
    public void Should_BeEqual_When_NPCAttacksAndHitsPlayer(){
        Ant ant = new Ant(1, 2);
        Player player = new Player();
        player.setPosX(2);
        player.setPosY(2);
        ant.setDamage(5);
        int playerExpectedHealth = NINETYFIVE;
        ant.attack(player);
        assertEquals(playerExpectedHealth, player.getHealth());
    }


}
