abstract class Race extends Player {
    String name;
    final int attribute = 20;

    public Race(Player player, String name) {
        super();
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
