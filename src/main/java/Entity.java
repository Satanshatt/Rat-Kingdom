public class Entity {
    protected int posX;
    protected int posY;
    private String type;

    public Entity(String type, int posX, int posY ){
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int newXPosition){
        posX = newXPosition;
    };

    public void setPosX(int newYPosition){
        posY = newYPosition;
    }

    public String getType() {
        return type;
    }

}
