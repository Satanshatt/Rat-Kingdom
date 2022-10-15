public class BuilderTrade extends Trade {

    private static final String NAME = "Builder";
    BuilderTrade(Player1 newPlayer) {
        super(newPlayer, NAME);
        newPlayer.setStrength(newPlayer.getStrength() + attribute);
    }
}
