public class WhiteRat extends Race {
    private static final String NAME = "White rat";

    WhiteRat(OldPlayer player){
        super(player, NAME);
        player.increaseMana(player.getMana() + attribute);
    }
}
