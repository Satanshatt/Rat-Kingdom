public class BuilderTrade extends Trade {

    public static final String NAME = "Builder";
    BuilderTrade(Player player) {
        super(NAME);
        player.setStrength(player.getStrength() + attribute);
    }
    @Override
    void raiseAttribute(Player player) {
        player.setStrength(player.getStrength() + attribute);
    }

    @Override
    String getName() {
        return NAME;
    }
}
