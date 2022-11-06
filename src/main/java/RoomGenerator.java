import java.util.HashSet;
import java.util.Set;

public class RoomGenerator {

    private int width;
    private int height;
    private Tile[][] tiles;
    private Set<Enemy> enemies;

    public Tile generateTile(String type, int x, int y){
        if(type == "ground"){
            return new Tile("ground", x,y,false);
        } else if (type == "wall") {
            return new Tile("wall",x,y,true);
        } else if (type == "door") {
            return new Tile("door",x,y,true);
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

    public RoomGenerator(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.enemies = new HashSet<Enemy>();
    }

    /* TODO: De här metoderna här under bör inte vara publika.
             Det bör enbart finnas en enda metod som genererar ett rum (givet width, height och type of room)
             För annars finns det chans att man generar rum som är helt tomma, utan mark eller något.


     */
    public RoomGenerator generateObstacles(int numObstacles){
        return this;
    }

    public RoomGenerator generateAntEnemies(int numEnemies){
        return this;
    }

    public RoomGenerator generateRattlesnakeEnemies(int numEnemies){
        return this;
    }

    public RoomGenerator generateOwlEnemies(int numEnemies){
        return this;
    }
    /* TODO: Den här metoden bör fungera som en "gör allt", och inte bara hämta ut ett rum..
    * */
    public Room generate(){
        return new Room(tiles, enemies);
    }

}
