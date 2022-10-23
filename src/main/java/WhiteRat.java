public class WhiteRat extends Race {
    private static final String NAME = "White rat";

    WhiteRat(Player player){
        super(player, NAME);
        player.setMana(player.getMana() + attribute);
    }
}
