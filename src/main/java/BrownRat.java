public class BrownRat extends Race {
    private static final String NAME = "Brown rat";

    BrownRat(Player player){
        super(player, NAME);
        player.increaseHealth(player.getHealth() + attribute);
    }
}
