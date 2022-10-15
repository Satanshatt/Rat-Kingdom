public class WhiteRat extends Race {
    private static final String NAME = "White rat";

    WhiteRat(Player1 newPlayer){
        super(newPlayer, NAME);
        newPlayer.setMana(newPlayer.getMana() + attribute);
    }
}
