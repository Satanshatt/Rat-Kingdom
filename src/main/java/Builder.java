public class Builder extends Trade {

    private static final String NAME = "Builder";
    Builder(Player newPlayer) {
        super(newPlayer, NAME);
        newPlayer.increaseStrength(newPlayer.getStrength() + attribute);
    }
}
