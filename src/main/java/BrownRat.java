public class BrownRat extends Race {
    private static final String NAME = "Brown rat";

    BrownRat(Player player){
        super(NAME);
        player.setHealth(player.getHealth() + attribute);
    }
}
