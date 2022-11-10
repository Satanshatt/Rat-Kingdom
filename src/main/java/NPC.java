import java.util.Random;

abstract class NPC extends Entity{

    private String name;
    private int damage;
    private int health;
    private static boolean direction = false;

    NPC(String name, int damage, int health, boolean direction, String type, int posX, int posY) {
        super(type, posX, posY);

        this.name = name;
        this.damage = damage;
        this.health = health;
        this.direction = false;

    }

    public abstract void attackEnemy();

    public abstract void attackFriend();

    public abstract void attackPlayer();

    public abstract void moveForBattle();

    public boolean isPlayerWithinReach(Player player) {
        if ((this.posY == player.posY) &&
                ((this.posX == (player.posX++)) || (this.posX == player.posX--))) {
            return true;
        } else if ((this.posX == player.posX) &&
                ((this.posY == (player.posY++ )) || (this.posY == player.posY--))) {
            return true;
        }
        return false;
    }

    public boolean isDead() {
        if (this.health <= 0){
            return true;
        } else {
            return false;
        }
    }

    private void NPCDies(){

    }

    public void takeDamage(int damageFromPlayer){
        int NPCOriginalHealth = this.getHealth();
        int newHealth = (NPCOriginalHealth - damageFromPlayer);
        this.setHealth(newHealth);
    }

    public void moveDownwards(Tile newTile){
        if(isLegalToMove(newTile)){
            this.posY--;
        }
    }

    public void moveRight(Tile newTile){
        if(isLegalToMove(newTile)){
            this.posX++;
        }
    }

    public void moveLeft(Tile newTile){

        if(isLegalToMove(newTile)){
            this.posX--;
        }
    }

    public void moveUpwards(Tile newTile){
        if (isLegalToMove(newTile)) {
            this.posY++;
        }
    }

    private boolean isLegalToMove(Tile newTile){
        try {
            if (newTile == null) {
                throw new IllegalStateException("Can not move outside of the room, move elsewhere");
            }

            if (newTile.isBlocked()) {
                direction = true;
            }

            return true;

        } catch(IllegalStateException illegalStateException) {
            return false;
        }
    }

    public void damagePlayer(Player player) {
        player.playerTakesDamage(this.damage);
    }

        public String getName () {
            return name;
        }

        public int getDamage () {
            return damage;
        }

        public int getHealth () {
            return health;
        }

        public boolean getDirection () {
        return direction;
        }

        public void setHealth(int newHealth){
            this.health = newHealth;
        }

        public void setName(String newName){
            this.name = newName;
        }

        public void setDamage(int newDamage){
            this.damage = newDamage;
        }

        public void setDirection(boolean newDirection) {
        this.direction = newDirection;
        }

}
