public class StorytellerTrade extends Trade{
    public static final String NAME = "Storyteller";
    StorytellerTrade(Player1 newPlayer) {
        super(newPlayer, NAME);
        newPlayer.setIntelligence(newPlayer.getIntelligence() + attribute);
    }
}