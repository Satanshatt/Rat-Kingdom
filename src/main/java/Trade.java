abstract class Trade {

    String name;
    final int attribute = 2;

    public Trade(String name) {
        this.name = name;
    }

    abstract void raiseAttribute(Player player);

    public String getName(){
        return name;
    }
}
