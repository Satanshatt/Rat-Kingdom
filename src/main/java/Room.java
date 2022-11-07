import java.util.*;


public class Room {
    private Tile[][] tiles;
    private int width;
    private int height;

    public Player player;
    public Set<NPC> npcs;

    public Room(Tile[][] tiles, Set<Enemy> enemies){
        this.npcs = new HashSet<>();
        this.npcs.addAll(enemies);
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void addEntity(NPC npc){
        this.npcs.add(npc);
    }

    public Tile getTile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return null;
        else
            return tiles[x][y];
    }

    public <T extends Entity> T getEntityAt(Class<T> type, int x, int y) {
        if (type == NPC.class) {
            NPC npc = npcs.stream()
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
        return null; //Kanske returnera ett fel istället? En fiende eller en tile kan ju inte vara utanför rummet
    }

    public String generateRoomToShow(Player player){
        String representation = "";
        for(int x = 0; x < this.getWidth(); x++) {
            representation += "\n";
            for (int y = 0; y < this.getHeight(); y++) {
                try {
                    if(player.getPosX() == x && player.getPosY() == y) {
                        representation +="[P]";
                    }
                    else {
                        Class<? extends Tile> type = this.tiles[x][y].getClass();
                        representation +="[" + this.getEntityAt(type, x,y).getType().substring(0, 1).toUpperCase(Locale.ROOT) + "]";
                    }
                } catch(Exception e) {
                    representation +="[]";
                }

            }
        }
        representation += "\n";
        return representation;
    }

    public boolean isBlocked(int x, int y) {
        return (tiles[x][y].isBlocked() || getEntityAt(NPC.class, x, y) != null);
    }

}
