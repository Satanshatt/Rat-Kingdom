public class IceRing extends MagicRing{
    private static final String NAME = "Ice ring";
    private Player player;

    public IceRing(){
        super();
    }

    public int attackDamage(){
        return player.getIntelligence() + player.getLevel();
    }

    public int attackSpeed(){
        return player.getDexterity() + player.getLevel();
    }

    public String getName(){
        return NAME;
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
