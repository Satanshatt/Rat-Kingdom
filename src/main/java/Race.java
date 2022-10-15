abstract class Race {
    String name;
    final int attribute = 20;

    public Race(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
