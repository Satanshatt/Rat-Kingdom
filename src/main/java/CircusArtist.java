public class CircusArtist extends Trade{
    public static final String NAME = "Circus artist";
    CircusArtist(Player player) {
        super(NAME);
        player.increaseDexterity(player.getDexterity() + attribute);
    }
}