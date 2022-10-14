public class BuilderTrade extends Trade {

    private static final String NAME = "Builder";
    BuilderTrade(Player player) {
        super(NAME);
        player.setStrength(player.getStrength() + attribute);
    }
    @Override
    void raiseAttribute(Player player) {
        player.setStrength(player.getStrength() + attribute);
    }
}
