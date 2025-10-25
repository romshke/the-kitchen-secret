import java.io.File;
import java.util.Scanner;

public class Main {
    
    static char getLetter(String sequence) {
        char[][] keyboard = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P'}
        };

        int row = 0, column = 0;

        for (String movement : sequence.split(",")) {
            switch (movement) {
                case "UP" -> row -= row != 0 ? 1 : 0;
                case "DOWN" -> row += row != 3 ? 1 : 0;
                case "LEFT" -> column -= column != 0 ? 1 : 0;
                case "RIGHT" -> column += column != 3 ? 1 : 0;
            }
        }

        return keyboard[row][column];
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/hyperskill-dataset-117361242.txt");
        
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder word =  new StringBuilder();

            while (scanner.hasNextLine()) {
                word.append(getLetter(scanner.nextLine()));
            }

            System.out.println(word);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
