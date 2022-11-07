import java.util.Random;

abstract class NPC extends Entity{

    String name = "";
    String type = "";
    int size = 2;
    int damage = 2;
    int health = 2;
    int level = 2;
    boolean direction = false;

    NPC(String name, String type, int health, int damage, int size, int level, int posX, int posY, boolean direction) {
        super(type, posX, posY);
        this.name = name;
        this.type = type;
        this.health = health;
        this.damage = damage;
        this.size = size;
        this.level = level;
        this.direction = direction;
    }

    public abstract void attackEnemy();

    public abstract void attackFriend();

    public abstract void attackPlayer();

    public abstract void moveForBattle();

    public boolean isEntityWithinReach(Player player) {
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

        public String getName () {
            return name;
        }

        public int getSize () {
            return size;
        }

        public int getDamage () {
            return damage;
        }

        public int getHealth () {
            return health;
        }

        public int getLevel () {
            return level;
        }

        public void setHealth(int newHealth){
            this.health = newHealth;
        }

        public void setName(String newName){
            this.name = newName;
        }

        public void setLevel(int newLevel){
            this.level = newLevel;
        }

        public void setType(String newType){
            this.type = newType;
        }

        public void setSize(int newSize){
            this.size = newSize;
        }

        public void setDamage(int newDamage){
            this.damage = newDamage;
        }


    public void damagePlayer(Player player) {
    }
}
