import java.util.*;


public class Room {
    private Tile[][] tiles;
    private int width;
    private int height;

    public Player player;
    public Set<Entity> entities;

    public Room(Tile[][] tiles, Set<Entity> entities){
        this.entities = new HashSet<>();
        this.entities.addAll(entities);
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void addEntity(Enemy enemy){
        this.entities.add(enemy);
    }

    public Tile getTile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return null;
        else
            return tiles[x][y];
    }

    public boolean isBlocked(int x, int y) {
        return (tiles[x][y].isBlocked());
    }

}
