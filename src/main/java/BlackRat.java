public class BlackRat extends Race {
    private static final String NAME = "Black rat";

    BlackRat(Player player){
        super(NAME);
        player.setHealth(player.getHealth() + (attribute / 2));
        player.setMana(player.getMana() + (attribute / 2));
    }
}
