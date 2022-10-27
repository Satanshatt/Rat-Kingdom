public class Builder extends Trade {

    private static final String NAME = "Builder";
    Builder(Player player) {
        super(player, NAME);
        player.increaseStrength(player.getStrength() + attribute);
    }
}
