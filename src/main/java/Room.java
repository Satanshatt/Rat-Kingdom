import java.util.*;


public class Room {
    private Tile[][] tiles;
    private int width;
    private int height;

    public Player player;
    public Set<Enemy> enemies;

    public Room(Tile[][] tiles, Set<Enemy> enemies){
        this.enemies = new HashSet<>();
        this.enemies.addAll(enemies);
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void addEntity(Enemy enemy){
        this.enemies.add(enemy);
    }

    public Tile getTile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return null;
        else
            return tiles[x][y];
    }

    public <T extends Entity> T getEntityAt(Class<T> type, int x, int y) {
        if (type == NPC.class) {
            NPC npc = enemies.stream()
                    .filter(enemies -> enemies.getPosX() == x && enemies.getPosY() == y)
                    .findFirst()
                    .orElse(null);
            return type.cast(npc);
        } else if (type == Tile.class) {
            return type.cast(tiles[x][y]);
        } else if (type == Entity.class) {
            NPC npc = getEntityAt(Enemy.class, x, y);
            if (npc != null) {
                return type.cast(npc);
            } else {
                return type.cast(getEntityAt(Tile.class, x, y));
            }
        }
        return null;
    }

    public boolean isBlocked(int x, int y) {
        return (tiles[x][y].isBlocked() || getEntityAt(NPC.class, x, y) != null);
    }

}
