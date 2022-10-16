public class Builder extends Trade {

    private static final String NAME = "Builder";
    Builder(Player1 newPlayer) {
        super(newPlayer, NAME);
        newPlayer.setStrength(newPlayer.getStrength() + attribute);
    }
}
