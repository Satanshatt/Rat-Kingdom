public class Wand extends Weapon {
    private static final String NAME = "Wand";
    private static final int DAMAGE = 3;
    private static final int SPEED = 3;

    public Wand(){
        super(NAME, DAMAGE, SPEED);
    }

    @Override
    public void mainAttack(Player player) {
        int attackDamage = player.getIntelligence() + DAMAGE;
        int attackSpeed = player.getDexterity() + SPEED;
    }

    @Override
    public void secondaryAttack(Player player){
        int attackDamage = player.getIntelligence() + (DAMAGE * 2);
        int attackSpeed = player.getDexterity();
    }
}
