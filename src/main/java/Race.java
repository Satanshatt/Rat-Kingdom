abstract class Race extends PlayerDecorator {
    String name;
    final int attribute = 20;

    public Race(Player1 newPlayer, String name) {
        super(newPlayer);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
