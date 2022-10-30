abstract class Magic extends OldPlayerDecorator {

    public Magic(OldPlayer player){
        super(player);
    }

    abstract void spellOne();
    abstract void spellTwo();
    abstract void spellThree();
}
