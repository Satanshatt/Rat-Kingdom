public class Axe extends Weapon {
    private static final String NAME = "Axe";
    private static final int DAMAGE = 4;
    private static final int SPEED = 2;

    public Axe(){
        super(NAME, DAMAGE, SPEED);
    }

    @Override
    public void mainAttack(Player player) {
        int attackDamage = player.getStrength() + DAMAGE;
        int attackSpeed = player.getDexterity() + SPEED;
    }

    @Override
    public void secondaryAttack(Player player){
        int attackDamage = player.getStrength() + (DAMAGE * 2);
        int attackSpeed = player.getDexterity();
    }
}
