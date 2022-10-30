import java.util.Random;

abstract class NPC extends Entity{

    String name = "";
    String type = "";
    int size = 2;
    int damage = 2;
    int health = 2;
    int level = 2;

    NPC(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(type, posX, posY);
        this.name = name;
        this.type = type;
        this.health = health;
        this.damage = damage;
        this.size = size;
        this.level = level;
    }

    public abstract void battle ();

    public abstract void moveForBattle ();

    public void spawnNPC(int xCoordinate, int yCoordinate){
        this.setPosX(xCoordinate);
        this.setPosY(yCoordinate);
    }

    public void spawnNPCRandomPosition(){
        Random randomNumber = new Random();
        int xPosition = randomNumber.nextInt(12);
        int yPosition = randomNumber.nextInt(12);
        spawnNPC(xPosition, yPosition);
    }

    //skapa randomizer för när NPCs dör, 1 av 10 att vapen ges
    public boolean die() {
        if (this.health <= 0){
            return true;
        } else {
            return false;
        }
    }

    public void takeDamage(int damageFromPlayer){
        int NPCOriginalHealth = this.getHealth();
        int newHealth = (NPCOriginalHealth - damageFromPlayer);
        this.setHealth(newHealth);
    }

    public int damagePlayer(){
        return 2;
    };


        public String getName () {
            return name;
        }

        public String getType () {
            return type;
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

        public void setDamage(int newDamage){ this.damage = newDamage; }



}
