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

    public abstract void attackEnemy(); //fixa alla attack-metoder

    public abstract void attackFriend();

    public abstract void attackPlayer();

    public abstract void moveForBattle();

    public boolean isPlayerWithinReach(Player player) {

        int npcPosX = this.posX;
        int npcPosY = this.posY;
        int playerPosX = player.posX;
        int playerPosY = player.posY;

        if ((npcPosY == playerPosY) &&
                ((npcPosX == (playerPosX + 1)) || (npcPosX == playerPosX - 1))) {
            return false;
        } else if ((npcPosX == playerPosX) &&
                ((npcPosY == (playerPosY + 1)) || (npcPosY == playerPosY - 1))) {
            return false;
        }
        return true;
    }

    public boolean isDead() {
        if (this.health <= 0){
            return true;
        } else {
            return false;
        }
    }

    private void NPC_Dies_Test(){ // heta die istället?

    }

    public void takeDamage(int damageFromPlayer){ //NPC takes Damage
        int NPCOriginalHealth = this.getHealth();
        int newHealth = (NPCOriginalHealth - damageFromPlayer);
        this.setHealth(newHealth);
    }

    public void moveDownwards(Tile newTile){
        if(checkIfLegalToMove(newTile)){
            this.posY--;
        }
    }

    public void moveRight(Tile newTile){
        if(checkIfLegalToMove(newTile)){
            this.posX++;
        }
    }

    public void moveLeft(Tile newTile){

        if(checkIfLegalToMove(newTile)){
            this.posX--;
        }
    }

    public void moveUpwards(Tile newTile){
        if (checkIfLegalToMove(newTile)) {
            this.posY++;
        }
    }

    boolean checkIfLegalToMove(Tile newTile){ //Logiska fel, gör om! Fixa strukturen
        if (newTile.isBlocked()) {
            direction = true;
            return false;
        } else {
            return true;
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
