public class Storyteller extends Trade{
    public static final String NAME = "Storyteller";
    Storyteller(Player1 newPlayer) {
        super(newPlayer, NAME);
        newPlayer.setIntelligence(newPlayer.getIntelligence() + attribute);
    }
}