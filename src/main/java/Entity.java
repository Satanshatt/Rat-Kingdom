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

    public void setPosX(int newXPosition){
        posX = newXPosition;
    };

    public void setPosY(int newYPosition){
        posY = newYPosition;
    }

    public String getType() { // TODO: Den här ärvs till alla klasser, men ni deklarerar fortfarande många getType metoder i klasserna under.
        return type;
    }
    //TODO: ni bör ha ett sätt att generera en representation av type, som exempelvis ett G för ground eller P för player.

}
