public class Equipment extends PlayerDecorator {
    private String name;

    public Equipment(Player1 newPlayer, String name) {
        super(newPlayer);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
