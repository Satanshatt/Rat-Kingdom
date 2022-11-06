public class Main {

    public static void main(String args[]){
        Game game = new Game();

        boolean running = true;
        while(running){
            game.display();
//            String action = game.takeInput();
//            game.act(action);
            running = false;
        }
    }

}
