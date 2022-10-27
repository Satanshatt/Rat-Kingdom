abstract class Trade extends PlayerDecorator{

    String name;
    final int attribute = 2;

    public Trade(Player player, String name) {
        super(player);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
