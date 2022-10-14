public class BuilderTrade extends Trade {

    public static final String NAME = "Builder";
    BuilderTrade() {
        super(NAME);
    }
    @Override
    void raiseAttribute(Player player) {
        player.setStrength(player.getStrength() + attribute);
    }

    @Override
    String getName() {
        return null;
    }
}
