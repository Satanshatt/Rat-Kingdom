abstract class Weapon extends PlayerDecorator {
    String name;

    public Weapon(Player1 newPlayer, String name){
        super(newPlayer);
        this.name = name;
    }

    public int levelRandomizer(){
        return (int)(Math.random() * 10) + 1;
    }

    abstract int attackDamage();

    abstract int attackSpeed();

    public String getName(){
        return name;
    }


    /*@Override
    public void mainAttack() {
        int attackDamage = tempPlayer.getStrength() + DAMAGE;
        int attackSpeed = tempPlayer.getDexterity() + SPEED;
    }

    @Override
    public void secondaryAttack(){
        int attackDamage = tempPlayer.getStrength() + (DAMAGE * 2);
        int attackSpeed = (tempPlayer.getDexterity() / 2) + SPEED;
    }*/
}
