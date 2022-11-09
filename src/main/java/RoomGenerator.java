import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class RoomGenerator {

    private int width;
    private int height;
    private Tile[][] tiles;
    private Set<NPC> npcs;

    public RoomGenerator(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.npcs = new HashSet<>();
    }

    public Tile generateTile(String type, int x, int y){
        if(Objects.equals(type, "ground")){
            return new Tile("ground", x,y,false);
        } else if (Objects.equals(type, "wall")) {
            return new Tile("wall",x,y,true);
        } else if (Objects.equals(type, "door")) {
            return new Tile("door",x,y,true);
        } else if (Objects.equals(type, "obstacle")) {
            return new Tile("obstacle",x,y,true);
        } else{
            return null;
        }
    }

    public RoomGenerator fillRoom(String type){
        for(int x= 0;x<width; x++){
            for(int y= 0;y<height; y++){
                tiles[x][y] = generateTile(type, x,y);
            }
        } return this;
    }

    public RoomGenerator createWallsAndDoors(){
        for(int x= 0;x<width; x++){
            tiles[x][0] = generateTile("wall", x,0);
            tiles[x][height-1] = generateTile("wall", x,height-1);
        }
        for(int y= 0;y<width; y++){
            tiles[0][y] = generateTile("wall", y,0);
            tiles[width-1][y] = generateTile("wall", y,width-1);
            if( y == (width-1)/2){
                tiles[0][y] = generateTile("door", y,0);
                tiles[width-1][y] = generateTile("door", y,width-1);
            }
        }
        return this;
    }

    public RoomGenerator generateObstacles(int numObstacles){
        Random random = new Random();
        int randomX;
        int randomY;

        for(int i=0; i<numObstacles;i++){
            do {
                randomX = random.nextInt(width);
                randomY = random.nextInt(height);
            } while (tiles[randomX][randomY].isBlocked());
            tiles[randomX][randomY] = generateTile("obstacle", randomX,randomY);
        }

        return this;
    }

    public RoomGenerator generateEnemies(int numEnemies){
        Random random = new Random();
        int randomX = 0;
        int randomY = 0;
        NPC npc;

        for(int i=0; i<numEnemies;i++){
            while (tiles[randomX][randomY].isBlocked()){
                randomX = random.nextInt(width);
                randomY = random.nextInt(height);
            }

            npc = new Ant("Ant", 100, 5, false, "Ant", 1, 1);
            npcs.add(npc);

        }

        return this;

    }

    public RoomGenerator createBoss(){
        Boss boss = new Boss("Big Cat", 200, 10, false, "Boss", 1, 1);
        npcs.add(boss);
        return this;
    }


    public Room generate(){
        return new Room(tiles, npcs);
    }

}
