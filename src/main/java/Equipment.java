public class Equipment extends Player {
    private String name;

    public Equipment(Player player, String name) {
        super();
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
