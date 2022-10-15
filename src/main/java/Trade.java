abstract class Trade extends PlayerDecorator {

    String name;
    final int attribute = 2;

    public Trade(Player1 newPlayer, String name) {
        super(newPlayer);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
