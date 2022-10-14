public class WhiteRat extends Race {
    private static final String NAME = "White rat";

    WhiteRat(Player player){
        super(NAME);
        player.setMana(player.getMana() + attribute);
    }
}
