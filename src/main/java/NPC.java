abstract class NPC {

    String name = "";
    String type = "";
    int size = 2;
    int damage = 2;
    int health = 2;
    int level = 2;

    NPC(String name, String type, int health, int damage, int size, int level) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.damage = damage;
        this.size = size;
        this.level = level;
    }

    public abstract void battle ();

    public abstract void moveForBattle ();

    public abstract void spawn ();

    public boolean die() {
        return true;
    }

    public int takeDamage ( int damageFromPlayer){
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
