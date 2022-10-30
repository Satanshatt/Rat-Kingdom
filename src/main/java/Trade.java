abstract class Trade extends Player {

    String name;
    final int attribute = 2;

    public Trade(String name) {
        super();
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
