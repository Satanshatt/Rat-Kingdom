import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class WeaponTest {
    private Player player;

    @Mock
    Weapon sword;
    @Mock
    Weapon axe;

    @BeforeEach
    void setup() {
        player = new Player();
    }

    @Test
    public void testLevelRandomizer() {
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            weapons.add(new Axe());
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(0 < weapons.get(i).getWeaponLevel() && weapons.get(i).getWeaponLevel() <= 10);
        }
    }

    @Test
    public void testLevelRandomizerWithMatchers(){
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            weapons.add(new Axe());
        }
        for (int i = 0; i < 100; i++) {
            assertThat(weapons.get(i).getWeaponLevel(), both(greaterThan(0)).and(lessThanOrEqualTo(10)));
        }
    }

    @Test
    public void testAxe() {
        Weapon axe = new Axe();
        axe.setPlayer(player);
        int weaponLevel = axe.getWeaponLevel();
        assertEquals(weaponLevel + 4, axe.getDamage());
        assertEquals(weaponLevel + 2, axe.getSpeed());
        assertEquals(10 + axe.getDamage(), axe.attackDamage());
        assertEquals(10 + axe.getSpeed(), axe.attackSpeed());
    }

    @Test
    public void testAxeWithMatchers(){
        Weapon axe = new Axe();
        axe.setPlayer(player);
        int weaponLevel = axe.getWeaponLevel();
        assertThat(axe.getDamage(), is(equalTo(weaponLevel + 4)));
        assertThat(axe.getSpeed(), is(equalTo(weaponLevel + 2)));
        assertThat(axe.attackDamage(), is(equalTo(10 + axe.getDamage())));
        assertThat(axe.attackSpeed(), is(equalTo(10 + axe.getSpeed())));
    }

    @Test
    public void testSword() {
        Weapon sword = new Sword();
        sword.setPlayer(player);
        int weaponLevel = sword.getWeaponLevel();
        assertEquals(weaponLevel + 2, sword.getDamage());
        assertEquals(weaponLevel + 4, sword.getSpeed());
        assertEquals(10 + sword.getDamage(), sword.attackDamage());
        assertEquals(10 + sword.getSpeed(), sword.attackSpeed());
    }

    @Test
    public void testWand() {
        Weapon wand = new Wand();
        wand.setPlayer(player);
        int weaponLevel = wand.getWeaponLevel();
        assertEquals(weaponLevel + 3, wand.getDamage());
        assertEquals(weaponLevel + 3, wand.getSpeed());
        assertEquals(10 + wand.getDamage(), wand.attackDamage());
        assertEquals(10 + wand.getSpeed(), wand.attackSpeed());
    }

    @Test
    public void testPickUpWeaponSuccess() {
        Weapon sword = new Sword();
        Weapon axe = new Axe();
        sword.setWeaponLevel(0);
        axe.setWeaponLevel(1);
        player.setActiveWeapon(sword);
        player.pickUpWeapon(axe);
        assertSame(axe, player.getActiveWeapon());
    }

    @Test
    public void testPickUpWeaponSuccessWithMock() {
        when(sword.getWeaponLevel()).thenReturn(0);
        when(axe.getWeaponLevel()).thenReturn(1);
        player.pickUpWeapon(sword);
        player.pickUpWeapon(axe);
        assertSame(axe, player.getActiveWeapon());
    }

    @Test
    public void testPickUpWeaponSuccessWithMatchers(){
        Weapon sword = new Sword();
        Weapon axe = new Axe();
        sword.setWeaponLevel(0);
        axe.setWeaponLevel(1);
        player.setActiveWeapon(sword);
        player.pickUpWeapon(axe);
        assertThat(axe, sameInstance(player.getActiveWeapon()));
    }

    @Test
    public void testPickUpWeaponFailWithMock() {
        when(sword.getWeaponLevel()).thenReturn(1);
        when(axe.getWeaponLevel()).thenReturn(0);
        player.pickUpWeapon(sword);
        player.pickUpWeapon(axe);
        assertSame(sword, player.getActiveWeapon());
    }

    @Test
    void testPickUpWeaponFail() {
        Weapon sword = new Sword();
        Weapon axe = new Axe();
        sword.setWeaponLevel(1);
        axe.setWeaponLevel(0);
        player.setActiveWeapon(sword);
        player.pickUpWeapon(axe);
        assertSame(sword, player.getActiveWeapon());
    }
}
