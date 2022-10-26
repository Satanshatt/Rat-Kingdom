public class Equipment extends PlayerDecorator {
    private String name;

    public Equipment(Player player, String name) {
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
