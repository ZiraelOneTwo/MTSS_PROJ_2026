////////////////////////////////////////////////////////////////////
// [ALEX] [SINGH] [2148621]
// [ALESSANDRO] [PADURET] [2150445]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import java.util.stream.Collectors;
import java.util.List;

public class RomanPrinter {

    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) {
        String[] ASCII_ART = {
            " ___ \n"     +
            "|_ _|\n"     +
            " | | \n"     +
            " | | \n"     +
            "|___|",

            "__     __\n" +
            "\\ \\   / /\n" +
            " \\ \\ / / \n" +
            "  \\ V /  \n" +
            "   \\_/   ",

            "__  __\n"   +
            "\\ \\/ /\n"   +
            " \\  / \n"   +
            " /  \\ \n"   +
            "/_/\\_\\",

            " _     \n"   +
            "| |    \n"   +
            "| |    \n"   +
            "| |___ \n"   +
            "|_____|",

            " ____ \n"    +
            "/ ___|\n"    +
            "| |   \n"    +
            "| |___\n"    +
            "\\____|",

            "_____  \n"   +
            "|  _ \\ \n"   +
            "| | | |\n"   +
            "| |_| |\n"   +
            "|____/ ",

            " __  __ \n"  +
            "|  \\/  |\n" +
            "| |\\/| |\n" +
            "| |  | |\n"  +
            "|_|  |_|"
        };

        List<String[]> letterMatrices = romanNumber.chars()
            .mapToObj(c -> switch (c) {
                case 'I' -> ASCII_ART[0];
                case 'V' -> ASCII_ART[1];
                case 'X' -> ASCII_ART[2];
                case 'L' -> ASCII_ART[3];
                case 'C' -> ASCII_ART[4];
                case 'D' -> ASCII_ART[5];
                case 'M' -> ASCII_ART[6];
                default -> throw new IllegalArgumentException("Carattere non riconosciuto: " + (char) c);
            })
            .map(art -> art.split("\n"))
            .toList();

        StringBuilder ASCII_MATRIX_FLATTENED = new StringBuilder();
        int height = 5; 

        for (int i = 0; i < height; i++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int j = 0; j < letterMatrices.size(); j++) {
                if (i < letterMatrices.get(j).length) {
                    rowOutput.append(letterMatrices.get(j)[i]);
                }
                if (j < letterMatrices.size() - 1) {
                    rowOutput.append("   ");
                }
            }
            if (i <= height-1) {
                ASCII_MATRIX_FLATTENED.append(rowOutput.toString()).append("\n");
            }
        }

        return ASCII_MATRIX_FLATTENED.toString();
    }
}
