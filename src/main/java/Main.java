public class Main {

    public static void main(String args[]){
        Game game = new Game();

        boolean running = true;
        while(running){

            game.startGame();
//            String action = game.takeInput();
//            game.act(action);
            running = false;
        }
    }

}
