public class StorytellerTrade extends Trade{
    public static final String NAME = "Storyteller";
    StorytellerTrade() {
        super(NAME);
    }
    @Override
    void raiseAttribute(Player player) {
        player.setIntelligence(player.getIntelligence() + attribute);
    }
}
