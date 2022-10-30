abstract class Trade extends OldPlayerDecorator {

    String name;
    final int attribute = 2;

    public Trade(OldPlayer player, String name) {
        super(player);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
