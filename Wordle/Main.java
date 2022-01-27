import java.util.*;
/*
 * Programmer: Abteen Arab
 * Program: Wordle
 * Date: Jan. 26, 2022
 */
public class Main {
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Puzzle puzzle = new Puzzle();
        Language lang = new Language();
        System.out.println("* = Correct\n? = Wrong Place\nX = Wrong");
        System.out.println("If you need help, please type HELP.");
        System.out.println("Make A Guess: ");
        while (puzzle.isUnsolved() && puzzle.live()) {
            String predict = scanner.nextLine();
            if (predict.equals("HELP")){
                String guess = lang.english();
                System.out.println(guess);
                puzzle.guess(guess);
                System.out.println();
            } else if(predict.length()!= 5){
                System.out.println("Please Enter A 5 Letter Word");
            } else {
                puzzle.guess(predict);
                System.out.println();
            }
        }
        if (!puzzle.isUnsolved()) { 
            System.out.println("You Won");
        } else {
            System.out.println("You Lost. The Word Was " + puzzle.getWord());
        }
    }
}
