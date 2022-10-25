public class Tile extends Entity{

    private boolean blocked;

    public Tile(String type, int posX, int posY, boolean blocked) {
        super(type, posX, posY);
        this.blocked = blocked;
    }

    @Override
    public int getPosX() {
        return super.getPosX();
    }

    @Override
    public int getPosY() {
        return super.getPosY();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    public boolean isBlocked(){
        return this.blocked;
    }

}


