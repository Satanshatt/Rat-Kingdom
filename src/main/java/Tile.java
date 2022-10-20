public class Tile extends Entity{

    private boolean blocked = false;

    public Tile(String type, int posX, int posY, boolean blocked) {
        super(type, posX, posY);
        this.blocked = blocked;
    }

    public boolean isBlocked(){
        return this.blocked;
    }

}


