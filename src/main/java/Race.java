abstract class Race extends PlayerDecorator {
    String name;
    final int attribute = 20;

    public Race(Player player, String name) {
        super(player);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
