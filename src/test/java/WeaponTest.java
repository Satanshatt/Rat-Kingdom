import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {
    Player player;

    @BeforeEach
    void setup(){
        player = new BasicPlayer();
    }

    @Test
    public void testLevelRandomizer(){
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            weapons.add(new Axe(player));
        }
        for (int i = 0; i < 100; i++){
            assertTrue(0 < weapons.get(i).getWeaponLevel() && weapons.get(i).getWeaponLevel() <= 10);
        }
    }

    @Test
    public void testAxe(){
        Weapon axe = new Axe(player);
        int weaponLevel = axe.getWeaponLevel();
        assertEquals(weaponLevel + 4, axe.getDamage());
        assertEquals(weaponLevel + 2, axe.getSpeed());
        assertEquals(10 + axe.getDamage(), axe.attackDamage());
        assertEquals(10 + axe.getSpeed(), axe.attackSpeed());
    }

    @Test
    public void testSword(){
        Weapon sword = new Sword(player);
        int weaponLevel = sword.getWeaponLevel();
        assertEquals(weaponLevel + 2, sword.getDamage());
        assertEquals(weaponLevel + 4, sword.getSpeed());
        assertEquals(10 + sword.getDamage(), sword.attackDamage());
        assertEquals(10 + sword.getSpeed(), sword.attackSpeed());
    }

    @Test
    public void testWand(){
        Weapon wand = new Wand(player);
        int weaponLevel = wand.getWeaponLevel();
        assertEquals(weaponLevel + 3, wand.getDamage());
        assertEquals(weaponLevel + 3, wand.getSpeed());
        assertEquals(10 + wand.getDamage(), wand.attackDamage());
        assertEquals(10 + wand.getSpeed(), wand.attackSpeed());
    }

    @Test
    public void testPickUpWeaponSuccess(){
        Weapon sword = new Sword(player);
        Weapon axe = new Axe(player);
        sword.setWeaponLevel(0);
        axe.setWeaponLevel(1);
        player.setActiveWeapon(sword);
        player.pickUpWeapon(axe);
        assertSame(axe, player.getActiveWeapon());
    }

    @Test void testPickUpWeaponFail(){
        Weapon sword = new Sword(player);
        Weapon axe = new Axe(player);
        sword.setWeaponLevel(1);
        axe.setWeaponLevel(0);
        player.setActiveWeapon(sword);
        player.pickUpWeapon(axe);
        assertSame(sword, player.getActiveWeapon());
    }
}
