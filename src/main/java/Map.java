import java.util.ArrayList;

public class Map {

    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;
    private ArrayList<Room> rooms;
    public Map(){
        this.rooms = this.generateMap();
    }

    private ArrayList<Room> generateMap(){
        ArrayList<Room> roomsToAdd = new ArrayList<>();

        Room room1 = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().
                createWallsAndDoors().generateObstacles(10).generateEnemies(10).generate();
        Room room2 = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().
                createWallsAndDoors().generateObstacles(15).generateEnemies(12).generate();
        Room room3 = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().
                createWallsAndDoors().generateObstacles(13).generateEnemies(20).generate();
        Room room4 = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().
                createWallsAndDoors().generateObstacles(10).generateEnemies(24).generate();
        Room bossRoom = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().
                createWallsAndDoors().generateObstacles(10).createBoss().generate();

        roomsToAdd.add(room1);
        roomsToAdd.add(room2);
        roomsToAdd.add(room3);
        roomsToAdd.add(room4);
        roomsToAdd.add(bossRoom);

        return roomsToAdd;

    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }


}
