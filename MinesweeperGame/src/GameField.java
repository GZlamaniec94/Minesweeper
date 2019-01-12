import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameField {
    int sizeOfGameField;




   public String[][] readyGameField(String[][] gameField) {
        gameField=quantityOfBombsPerCell(placeBombs(makingEmptyGameField()));


        return gameField;
    }

    private String[][] makingEmptyGameField (){
       String[][] gameField;
       gameField = new String[sizeOfGameField + 4][sizeOfGameField + 4];

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
        return gameField;




    }

    private String[][] placeBombs(String[][] gameField) {

        for (int i = 0; i < 10; i++) {
            int line = ThreadLocalRandom.current().nextInt(2, 12);
            int column = ThreadLocalRandom.current().nextInt(2, 12);
            if (gameField[line][column].equals(" ")) {
                gameField[line][column] = "b";
            } else {
                i = i - 1;
            }
        }

        return gameField;
    }

    private String[][] quantityOfBombsPerCell(String[][] gameField) {

        for (int i = 2; i < gameField.length - 2; i++) {

            for (int j = 2; j < gameField.length - 2; j++) {
                int numberOfBombs = 0;
                if (gameField[i][j].equals("b")) {
                    continue;
                } else {
                    for (int k = i - 1; k < i+2; k++) {
                        for (int l = j - 1; l < j+2; l++) {

                            if (gameField[k][l].equals("b")) {
                                numberOfBombs += 1;
                            }
                        }

                    }
                }
                if (!(numberOfBombs ==0)) {
                    gameField[i][j] = Integer.toString(numberOfBombs);
                }

            }


        }

        return gameField;
    }













}
