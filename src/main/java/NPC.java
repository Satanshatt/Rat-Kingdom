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

    public void spawn(){

    }

    //skapa randomizer för när NPCs dör, 1 av 10 att vapen ges
    public boolean die() {
        if (this.health <= 0){
            return true;
        } else {
            return false;
        }
    }

    public int takeDamage(){
            return 2;
    }


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



}
