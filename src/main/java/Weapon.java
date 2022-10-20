abstract class Weapon extends Equipment {

    public Weapon(Player newPlayer, String name) {
        super(newPlayer, name);
    }

    protected int levelRandomizer() {
        return (int) (Math.random() * 10) + 1;
    }

    abstract int attackDamage();

    abstract int attackSpeed();


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
