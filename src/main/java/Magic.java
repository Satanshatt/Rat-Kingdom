abstract class Magic extends PlayerDecorator {

    public Magic(Player player){
        super(player);
    }

    abstract void spellOne();
    abstract void spellTwo();
    abstract void spellThree();
}
