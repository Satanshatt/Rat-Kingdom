public class Storyteller extends Trade{
    public static final String NAME = "Storyteller";
    Storyteller(Player player) {
        super(NAME);
        player.increaseIntelligence(player.getIntelligence() + attribute);
    }
}