import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;


    @BeforeEach
    void setup(){

    }
    @Test
    public void correctSizeOfRoom(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom("ground").generate();
        int width = room.getWidth();
        int height = room.getHeight();
        assertEquals(20, width);
        assertEquals(20, height);
    }

    @Test
    public void roomContainsTiles(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").generate();
        for(int x= 0;x<MAP_WIDTH-1; x++){
            for(int y= 0;y<MAP_HEIGHT-1; y++){
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
    public void createWallAroundEdges(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();
        String wallTile = room.getTile(0,0).getType();
        String groundTile = room.getTile(1,1).getType();
        assertEquals("wall", wallTile);
        assertEquals("ground", groundTile);
    }

    @Test
    public void createDoorsAtCorrectPosition(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();
        String doorTile1 = room.getTile(0,(MAP_HEIGHT-1)/2).getType();
        String doorTile2 = room.getTile(MAP_WIDTH-1,(MAP_HEIGHT-1)/2).getType();
        assertEquals("door", doorTile1);
        assertEquals("door", doorTile2);
    }

    @Test
    public void correctAmountOfEnemiesExist(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom("ground").createWallsAndDoors().generateEnemies(4).generate();
        int numEnemies = room.getSet().size();
        assertEquals(4, numEnemies);
    }

    @Test
    public void obstaclesAreGenerated(){
        int counter = 0;
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom("ground").createWallsAndDoors().generateObstacles(10).generate();

        for(int x= 0;x<MAP_WIDTH-1; x++){
            for(int y= 0;y<MAP_HEIGHT-1; y++){
                if(room.getTile(x,y).getType().equals("obstacle")){
                    counter++;
                }
            }
        }

        assertEquals(10, counter);

    }

    @Test
    public void obstaclesCantBeCreatedInFrontOfDoors(){
        int counter = 0;
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom("ground").createWallsAndDoors().generateObstacles(100).generate();

        for(int x= 0;x<MAP_WIDTH-1; x++){
            for(int y= 0;y<MAP_HEIGHT-1; y++){
                if(room.getTile(x,y).getType().equals("obstacle")){
                    counter++;
                }
            }
        }

        assertEquals(100, counter);

    }

    @Test
    public void newMap(){
        Map map = new Map();
        int counter = 0;
        for(int i = 0;i<map.getRooms().size;i++){
            counter++;
        }

        assertEquals(5,counter);

    }




}