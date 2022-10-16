public class CircusArtist extends Trade{
    public static final String NAME = "Circus artist";
    CircusArtist(Player1 newPlayer) {
        super(newPlayer,NAME);
        newPlayer.setDexterity(newPlayer.getDexterity() + attribute);
    }
}