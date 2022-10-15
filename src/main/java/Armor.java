abstract class Armor extends PlayerDecorator{
    String name;

    public Armor(Player1 newPlayer, String name){
        super(newPlayer);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int levelRandomizer(){
        return (int)(Math.random() * 10) + 1;
    }

    abstract int getProtectionValue();

    abstract int getArmorLevel();
}
