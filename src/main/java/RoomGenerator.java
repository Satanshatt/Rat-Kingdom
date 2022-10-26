import java.util.HashSet;
import java.util.Set;

public class RoomGenerator {

    private int width;
    private int height;
    private Tile[][] tiles;
    private Set<Entity> entities;

    public RoomGenerator(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.entities = new HashSet<Entity>();
    }

    public Tile generateTile(String type, int x, int y){
        if(type == "ground"){
            return new Tile("ground", x,y,false);
        } else if (type == "wall") {
            return new Tile("wall",x,y,true);
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

    public Room generate(){
        return new Room(tiles, entities);
    }

}
