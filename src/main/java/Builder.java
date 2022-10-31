public class Builder extends Trade {

    private static final String NAME = "Builder";
    Builder(Player player) {
        super(NAME);
        player.increaseStrength(player.getStrength() + attribute);
    }
}
