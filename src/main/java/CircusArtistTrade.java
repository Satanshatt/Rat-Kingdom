public class CircusArtistTrade extends Trade{
    public static final String NAME = "Circus artist";
    CircusArtistTrade(Player1 newPlayer) {
        super(newPlayer,NAME);
        newPlayer.setDexterity(newPlayer.getDexterity() + attribute);
    }
}