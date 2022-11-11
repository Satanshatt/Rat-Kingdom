import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

public class OwlTest {

    private static final int NINETYFIVE = 95;
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int ONE = 1;
    private static final int DAMAGE_FIVE = 5;
    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;

    @Test
    public void Should_DamagePlayer_When_NPCAttacks(){
        Player player = new Player();
        Owl owl = new Owl(ONE,TWO);
        player.setPosX(ONE);
        player.setPosY(TWO);
        owl.setDamage(DAMAGE_FIVE);
        int playerExpectedHealth = NINETYFIVE;
        owl.attack(player);
        assertEquals(playerExpectedHealth, player.getHealth());
    }

    @Test
    public void Should_MoveOneStepRight_When_PathIsNotBlocked_AndDirectionSetToTrue(){
        Owl owl = new Owl(ONE, TWO);
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        owl.setDirection(true);
        owl.moveForBattle(room);
        int expectedXPosition = TWO;
        assertEquals(owl.getPosX(), expectedXPosition);

    }

    @Test
    public void Should_MoveOneStepLeft_When_PathIsNotBlocked_And_DirectionSetToFalse(){
        Owl owl = new Owl(TWO, TWO);
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        owl.setDirection(false);
        owl.moveForBattle(room);
        int expectedXPosition = ONE;
        assertEquals(owl.getPosX(), expectedXPosition);

    }

    @Test
    public void Should_SetDirectionToFalse_When_TileIsBlockedAndDirectionIsTrue(){
        Owl owl = new Owl(ONE, ONE);
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        Tile blockedTile = room.getTile(ZERO, ONE);
        owl.setDirection(true);
        owl.moveForBattle(room);
        assertTrue(blockedTile.isBlocked());
        assertTrue(owl.getDirection());
    }

    @Test
    public void Should_SetDirectionToTrue_When_TileIsBlockedAndDirectionIsFalse(){
        Owl owl = new Owl(MAP_WIDTH-2, ONE);
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        Tile blockedTile = room.getTile(MAP_WIDTH-1, ONE);
        owl.setDirection(false);
        owl.moveForBattle(room);
        assertTrue(blockedTile.isBlocked());
        assertFalse(owl.getDirection());
    }







}
