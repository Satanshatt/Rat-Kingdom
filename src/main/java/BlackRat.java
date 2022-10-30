public class BlackRat extends Race {
    private static final String NAME = "Black rat";

    BlackRat(Player player){
        super(player, NAME);
        player.increaseHealth(player.getHealth() + (attribute / 2));
        player.increaseMana(player.getMana() + (attribute / 2));
    }
}
