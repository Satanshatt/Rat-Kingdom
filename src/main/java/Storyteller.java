public class Storyteller extends Trade{
    public static final String NAME = "Storyteller";
    Storyteller(Player newPlayer) {
        super(newPlayer, NAME);
        newPlayer.setIntelligence(newPlayer.getIntelligence() + attribute);
    }
}