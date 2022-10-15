public class BlackRat extends Race {
    private static final String NAME = "Black rat";

    BlackRat(Player1 newPlayer){
        super(newPlayer, NAME);
        newPlayer.setHealth(newPlayer.getHealth() + (attribute / 2));
        newPlayer.setMana(newPlayer.getMana() + (attribute / 2));
    }
}
