public class Equipment extends OldPlayerDecorator {
    private String name;

    public Equipment(OldPlayer player, String name) {
        super(player);
        this.name = name;
    }

    protected int levelRandomizer() {
        return (int) (Math.random() * 10) + 1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
