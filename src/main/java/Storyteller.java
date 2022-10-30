public class Storyteller extends Trade{
    public static final String NAME = "Storyteller";
    Storyteller(OldPlayer newPlayer) {
        super(newPlayer, NAME);
        newPlayer.increaseIntelligence(newPlayer.getIntelligence() + attribute);
    }
}