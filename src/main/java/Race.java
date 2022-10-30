abstract class Race extends OldPlayerDecorator {
    String name;
    final int attribute = 20;

    public Race(OldPlayer player, String name) {
        super(player);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
