import java.util.*;

public class UserInput {

    public final String  WALK_UPWARDS = "Upwards";
    public final String WALK_DOWNWARDS = "Downwards";
    public final String WALK_LEFT = "Left";
    public final String WALK_RIGHT = "Right";

    Scanner sc = new Scanner(System.in);

    public int askPlayerWhereToWalk(){
        boolean correctInput = false;

        do {
            System.out.print("Where will you walk? Upwards, Downwards, Left or Right.");
            String userInput = sc.nextLine();
            correctInput = checkIfUserInputIsCorrect(userInput);
            if(!correctInput) {
                System.out.println("Not a correct input, try again. Needs to be Upwards, Downwards, Left or Right.");
            }
        } while(!correctInput);
         return 1;
    }

    private boolean checkIfUserInputIsCorrect(String userInput){
        userInput.trim();
        switch (userInput) {
            case WALK_UPWARDS:
                    return true;
            case WALK_DOWNWARDS:
                    return true;
            case WALK_LEFT:
                    return true;
            case WALK_RIGHT:
                    return true;
            default:
                return false;
        }

    }

}
