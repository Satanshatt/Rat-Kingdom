public class Sword extends Weapon{
    private static final String NAME = "Sword";
    private static final int DAMAGE = 2;
    private static final int SPEED = 4;

    public Sword(){
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
