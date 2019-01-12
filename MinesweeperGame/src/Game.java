import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String[][] gameFieldReady;
        Scanner userInput = new Scanner(System.in);


        System.out.println("Enter size of game field, for example, enter '10' and it will be 10x10. Maximum is 26x26");
        int sizeOfGameField = userInput.nextInt();





    }

    private static void printGameField(String[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j]);

            }
            System.out.println();
            System.out.println();
        }


    }



}
