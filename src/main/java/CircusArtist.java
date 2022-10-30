public class CircusArtist extends Trade{
    public static final String NAME = "Circus artist";
    CircusArtist(OldPlayer newPlayer) {
        super(newPlayer,NAME);
        newPlayer.increaseDexterity(newPlayer.getDexterity() + attribute);
    }
}