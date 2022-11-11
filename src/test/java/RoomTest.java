import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;


    @Test
    public void testCorrectSizeOfRoomX(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        int width = room.getWidth();
        assertEquals(20, width);
    }

    @Test
    public void testCorrectSizeOfRoomY(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        int height = room.getHeight();
        assertEquals(20, height);
    }

    @Test
    public void testFalseSizeOfRoomX(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        int width = room.getWidth();
        assertFalse(width!=MAP_WIDTH);
    }

    @Test
    public void testFalseSizeOfRoomY(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        int height = room.getWidth();
        assertFalse(height!=MAP_HEIGHT);
    }

    @Test
    public void roomContainsTiles(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().generate();
        for(int x= 0;x<MAP_WIDTH-1; x++){
            for(int y= 0;y<MAP_HEIGHT-1; y++){
                assertEquals("ground",room.getTile(x,y).getType());
            }
        }
    }

    @Test
    public void testGetTileCorrectPositionX(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        Tile expectedTile = room.getTile(0,0);
        assertEquals(expectedTile.getPosX(), 0);

    }

    @Test
    public void testGetTileCorrectPositionY(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        Tile expectedTile = room.getTile(0,0);
        assertEquals(expectedTile.getPosY(), 0);
    }

    @Test
    public void testGetEntityAt(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generate();
        NPC npc = new Ant(1,1);
        room.addEntity(npc);
        NPC npcInRoom = room.getEntityAt(NPC.class, 1 ,1 );
        String type = npcInRoom.getName();
        assertEquals("Ant", type);
    }

    @Test
    public void testOneEntityPerTileCorrect(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generate();
        NPC npc = new Ant(1,1);
        NPC npc1 = new Rattlesnake(1,1);
        room.getSet().add(npc);
        room.getSet().add(npc1);
        assertTrue(room.getEntityAt(NPC.class,1,1).getName().equals("Rattlesnake"));
    }

    @Test
    public void testOneEntityPerTileFalse(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generate();
        NPC npc = new Ant(1,1);
        NPC npc1 = new Rattlesnake(1,1);
        room.getSet().add(npc);
        room.getSet().add(npc1);
        assertFalse(room.getEntityAt(NPC.class,1,1).getName().equals("Ant"));
    }

    @Test
    public void testEntityPositionX(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generate();
        Entity entity = room.getEntityAt(Entity.class, 1 ,1 );
        int posX = entity.getPosX();
        assertEquals(1, posX);
    }

    @Test
    public void testEntityPositionY(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generate();
        Entity entity = room.getEntityAt(Entity.class, 1 ,1 );
        int posY = entity.getPosY();
        assertEquals(1, posY);
    }

    @Test
    public void testGetTileCorrectType(){
        RoomGenerator roomGen = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT);
        Room room = roomGen.fillRoom().generate();
        String type = room.getTile(1,1).getType();
        assertEquals(type, "ground");
    }


    @Test
    public void createWallAroundEdges(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        String wallTile = room.getTile(0,0).getType();
        assertEquals("wall", wallTile);
    }

    @Test
    public void testGroundInsideWalls(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        String groundTile = room.getTile(1,1).getType();
        assertEquals("ground", groundTile);
    }

    @Test
    public void testDoorAtCorrectPostion1(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        String doorTile1 = room.getTile(0,(MAP_HEIGHT-1)/2).getType();
        assertEquals("door", doorTile1);
    }

    @Test
    public void testDoorAtCorrectPostion2(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();
        String doorTile2 = room.getTile(MAP_WIDTH-1,(MAP_HEIGHT-1)/2).getType();
        assertEquals("door", doorTile2);
    }

    @Test
    public void testCorrectAmountOfEnemiesExist(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generateEnemies(4).generate();
        int numEnemies = room.getSet().size();
        assertEquals(4, numEnemies);
    }


    @Test
    public void obstaclesAreGenerated(){
        int counter = 0;
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generateObstacles(10).generate();

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
    public void testObstacleCantBeCreatedInFrontOfDoor(){
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).
                fillRoom().createWallsAndDoors().generateObstacles(322).generate();
        String tileInFrontOfDoor1 = room.getTile(9,1).getType();
        assertEquals("ground", tileInFrontOfDoor1);
    }


    @Test
    public void testIfEnemyAreGenerated(){

        Room room = new RoomGenerator(3,3).
                fillRoom().createWallsAndDoors().generateEnemies(1).generate();
        NPC npc = room.getEntityAt(NPC.class,1,1);
        assertTrue(npc.getName().equals("Owl") ||
                npc.getName().equals("Rattlesnake") ||
                npc.getName().equals("Ant"));

    }

    @Test
    public void testIfMapContainsFiveRooms(){
        Map map = new Map();
        int counter = 0;
        for(int i = 0;i<map.getRooms().size();i++){
            counter++;
        }
        assertEquals(5,counter);

    }

    @Test
    public void testIfTooManyEnemiesAreGenerated(){

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Room room = new RoomGenerator(3,3).
                        fillRoom().createWallsAndDoors().generateEnemies(2).generate();
            }
        });

    }

    @Test
    public void testIfTooManyObstaclesAreGenerated(){

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Room room = new RoomGenerator(4,4).
                        fillRoom().createWallsAndDoors().generateObstacles(3).generate();
            }
        });

    }










}