public class Race1 extends DecoratorPlayer{

    protected Player1 player1;

    public Race1(Player1 newPlayer) {
        super(newPlayer);
        player1 = newPlayer;
    }

    @Override
    void addStrength(int strength) {
        player1.setStrength(strength);
    }


}
