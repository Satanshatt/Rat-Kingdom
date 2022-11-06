public class Game {

    public Room room;
    public Player player;
    public Friend friend;
    public Fiend fiend;
    public Boss boss;

    Game() {
        RoomGenerator rg = new RoomGenerator(7, 7);
        rg = rg.fillRoom("ground");
        rg = rg.createWallsAndDoors();
        rg = rg.generateAntEnemies(2);

        this.room = rg.generate();
        this.player = new Player(); //TODO: Finns inget sätt att representera spelaren i rummet


    }

    public void display(){
        System.out.print(this.room.generateRoomToShow());
    }

}
