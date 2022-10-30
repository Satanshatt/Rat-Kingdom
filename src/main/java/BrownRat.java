public class BrownRat extends Race {
    private static final String NAME = "Brown rat";

    BrownRat(OldPlayer player){
        super(player, NAME);
        player.setHealth(player.getHealth() + attribute);
    }
}
