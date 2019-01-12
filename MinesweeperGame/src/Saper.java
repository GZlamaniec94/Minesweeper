
import java.util.concurrent.ThreadLocalRandom;

public class Saper {
    public static void main(String[] args) {
        String[][] gameFieldModel = {{" ", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "", ""}, {" ", " ", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", ""},
                {"A", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {"B", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {"C", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""},
                {"D", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {"E", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {"F", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""},
                {"G", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {"H", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {"I", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""},
                {"J", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ""}, {" ", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", ""}, {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}};
        placeBombs(gameFieldModel);
        quantityOfBombsPerCell(gameFieldModel);
        printGameField(gameFieldModel);


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

    private static void placeBombs(String[][] gameField) {

        for (int i = 0; i < 10; i++) {
            int line = ThreadLocalRandom.current().nextInt(2, 12);
            int column = ThreadLocalRandom.current().nextInt(2, 12);
            if (gameField[line][column].equals(" ")) {
                gameField[line][column] = "b";
            } else {
                i = i - 1;
            }
        }


    }

    private static void quantityOfBombsPerCell(String[][] gsmeField) {

        for (int i = 2; i < gsmeField.length - 2; i++) {

            for (int j = 2; j < gsmeField.length - 2; j++) {
                int numberOfBombs = 0;
                if (gsmeField[i][j].equals("b")) {
                    continue;
                } else {
                    for (int k = i - 1; k < i+2; k++) {
                        for (int l = j - 1; l < j+2; l++) {

                            if (gsmeField[k][l].equals("b")) {
                                numberOfBombs += 1;
                            }
                        }

                    }
                }
                if (!(numberOfBombs ==0)) {
                    gsmeField[i][j] = Integer.toString(numberOfBombs);
                }

            }


        }


    }


}
