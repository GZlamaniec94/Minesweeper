
import java.util.Scanner;

public class Proby {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        System.out.println("Enter size of game field, for example, enter '10' and it will be 10x10. Maximum is 26x26");
        int sizeOfGameField = userInput.nextInt();


        String[][] gameField = new String[sizeOfGameField + 4][sizeOfGameField + 4];

        // Making array with alphabet
        char[] charsForLines = new char[sizeOfGameField];
        char alphabet = 'A';
        int positionInAlphabet = 0;
        do {

            charsForLines[positionInAlphabet] = alphabet;

            alphabet++;
            positionInAlphabet++;
        } while (positionInAlphabet != sizeOfGameField);
        String[] alphabetString = new String[sizeOfGameField];
        for (int i = 0; i < sizeOfGameField; i++) {
            alphabetString[i] = " " + charsForLines[i] + "  ";

        }


        //Loop for filling array with empty space
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (j < 11) {
                    gameField[i][j] = " 0  ";
                } else {
                    gameField[i][j] = "  0 ";
                }


            }
        }

        //Loop for numbering columns and add "-"
        for (int i = 2; i < gameField.length - 2; i++) {
            int j = i - 1;
            String s = Integer.toString(j);
            if (i < 11) {
                gameField[0][i] = "|" + s + "| ";
            } else {
                gameField[0][i] = "|" + s + "|";
            }

            if (i < 11) {
                gameField[1][i] = "--  ";
            } else {
                gameField[1][i] = " -- ";
            }
            if (i < 11) {
                gameField[gameField.length - 2][i] = "--  ";

            } else {
                gameField[gameField.length - 2][i] = " -- ";
            }


        }


        //Loop for numbering lines and add "|"
        for (int i = 2; i < gameField.length - 2; i++) {

            gameField[i][0] = alphabetString[i - 2];
            gameField[i][1] = " |  ";
            gameField[i][gameField.length - 2] = " |  ";
        }


        //Printing gamaField
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j]);

            }
            System.out.println();
            System.out.println();
        }


    }


}




