public class CircusArtistTrade extends Trade{
    public static final String NAME = "Circus artist";
    CircusArtistTrade() {
        super(NAME);
    }
    @Override
    void raiseAttribute(Player player) {
        player.setDexterity(player.getDexterity() + attribute);
    }
}
