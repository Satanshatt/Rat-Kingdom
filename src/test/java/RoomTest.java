import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;
    private  Set<Entity> entities = new HashSet<>();

    @Test
    public void correctSizeOfRoom(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom("").generate();
        int width = room.getWidth();
        int height = room.getHeight();
        assertEquals(10, width);
        assertEquals(10, height);
    }

    @Test
    public void roomContainsTiles(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").generate();
        for(int x= 0;x<10; x++){
            for(int y= 0;y<10; y++){
                assertEquals("ground",room.getTile(x,y).getType());
            }
        }

    }
    @Test
    public void testGetTileCorrectPosition(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom("ground").generate();
        Tile expectedTile = room.getTile(0,0);
        assertEquals(expectedTile.getPosX(), 0);
        assertEquals(expectedTile.getPosY(), 0);
    }

    @Test
    public void testGetTileCorrectType(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom("ground").generate();
        String type = room.getTile(1,1).getType();
        assertEquals(type, "ground");
    }


    @Test
    public void cantWalkOverBlockedTiles(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").generate();

    }




}