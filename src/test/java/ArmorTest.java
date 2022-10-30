import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ArmorTest {
    Player player;

    @BeforeEach
    void setup(){
        player = new Player();
    }

    @Test
    public void testLevelRandomizer(){
        ArrayList<Armor> armor = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            armor.add(new BodyArmor(player));
        }
        for (int i = 0; i < 100; i++){
            assertTrue(0 < armor.get(i).getArmorLevel() && armor.get(i).getArmorLevel() <= 10);
        }
    }

    @Test
    public void testBodyArmor(){
        Armor bodyArmor = new BodyArmor(player);
        int armorLevel = bodyArmor.getArmorLevel();
        assertEquals(armorLevel * 5, bodyArmor.getProtectionValue());
    }

    @Test
    public void testBoots(){
        Armor boots = new Boots(player);
        int armorLevel = boots.getArmorLevel();
        assertEquals(armorLevel * 3, boots.getProtectionValue());
    }

    @Test
    public void testHelmet(){
        Armor helmet = new Helmet(player);
        int armorLevel = helmet.getArmorLevel();
        assertEquals(armorLevel * 2, helmet.getProtectionValue());
    }
}
