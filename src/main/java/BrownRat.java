public class BrownRat extends Race {
    private static final String NAME = "Brown rat";

    BrownRat(Player newPlayer){
        super(newPlayer, NAME);
        newPlayer.setHealth(newPlayer.getHealth() + attribute);
    }
}
